/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.util.HashMap;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.model.Pictogram;
import org.model.PictogramListBuilder;
import org.scene.MainView;
import org.scene.ResultPane;


/**
 *
 * @author Martin
 */
public class MainSceneController 
{
    private static MainSceneController _instance        = null;
    private Stage _primaryStage                         = null;
    private MainView _mainView                          = null;
    
    private FlowPane _itemPane = null;
    
    private HashMap<String, Pictogram> _items;
    
    
    
    public static MainSceneController getInstance(Stage _primaryStage)
    {
        if(_instance == null)
        {
            _instance = new MainSceneController(_primaryStage);
        }
        
        return _instance;
    }
    
    private MainSceneController()
    {
    }
    
    private MainSceneController(Stage _primaryStage)
    {   
        this._primaryStage = _primaryStage;
        ResultPane resultPane = new ResultPane();
        
        this._mainView = new MainView(resultPane.getBodyPane(),createItemPane(resultPane.getBodyPane()));
        
        _items = new HashMap<>();
        
        resultPane.setItemsInfo(_itemPane, _items);
        
        populatePictograms();
                                    
        
        //setting the Title of the Window at the top left border
        this._primaryStage.setTitle("PictorgrammToString Converter");
        
        // get the Scene from _mainView and set it as Scene for the primaryStage
        this._primaryStage.setScene(_mainView.getScene());
        
        // sizing the Window to size of the scene
        this._primaryStage.sizeToScene();
        
        // showing the window with all components
        this._primaryStage.show();
    }
    
    private FlowPane createItemPane(final Pane targetPane) {
        if (!(_itemPane == null))
            return _itemPane;
        
        _itemPane = new FlowPane();
        _itemPane.setPadding(new Insets(10.0));
        
        _itemPane.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            //Get an item ID here, which was stored when the drag started.
            boolean success = false;
            // If this is a meaningful drop...
            if (db.hasString()) {
                String nodeId = db.getString();
                // ...search for the item on body. If it is there...
                ImageView picto = (ImageView) targetPane.lookup("#" + nodeId);
                if (picto != null) {
                    // ... it is removed from target
                    // and added to an source container.
                    targetPane.getChildren().remove(picto);
                    _itemPane.getChildren().add(picto);
                    success = true;
                }
                // ...anyway, the item is not active or equipped anymore.
                this._items.get(nodeId).takeOff();
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
        _itemPane.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != _itemPane &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });        
        
        return _itemPane;
    }
    
    private void populatePictograms() {
        PictogramListBuilder pictoBuilder = new PictogramListBuilder();
        
        if (_itemPane == null)
            throw new IllegalStateException("Should call getItems() before populating!");
        
        List<Pictogram> pictos = pictoBuilder.getPictorgrammList();
        
        pictos.stream().map((c) -> {
            _itemPane.getChildren().add(c.getNode());
            return c;
        }).forEach((c) -> {
            _items.put(c.getImageViewId(), c);
        });
    }
}
