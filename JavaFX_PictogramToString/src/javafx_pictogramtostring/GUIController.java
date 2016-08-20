/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx_pictogramtostring.controller.CustomEventHandler;
import javafx_pictogramtostring.controller.PictogramListBuilder;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class GUIController implements Initializable {
    
    @FXML
    private ListView sourceListView;
    
    @FXML
    private ListView targetListView;
    
    @FXML 
    private Label resultLabel;
    
    @FXML
    private Button resetButton;
    
    private PictogramListBuilder sourceListItems;
    
    static final DataFormat PICTO_LIST = new DataFormat("PictoList");
    
    private CustomEventHandler _eventHandler;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sourceListItems = new PictogramListBuilder();
        _eventHandler = new CustomEventHandler();
        initializeListView();
        initializeListener();
    } 
    
    private void initializeListView()
    {
        sourceListView.setItems(sourceListItems.getItems());
        sourceListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        sourceListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
        
        targetListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        targetListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
    }
    
    private void initializeListener()
    {
        // start sourceList listener
        sourceListView.setOnDragDetected((MouseEvent event) -> {
            _eventHandler.onDragDetected(event, PICTO_LIST, sourceListView);
        });
        
        sourceListView.setOnDragOver((DragEvent event) ->{
            _eventHandler.onDragOver(event, PICTO_LIST, sourceListView);
        });
        
        sourceListView.setOnDragDropped((DragEvent event) -> {
            _eventHandler.onDragDropped(event, PICTO_LIST, sourceListView, resultLabel);
        });
        
        sourceListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, sourceListView);
        });
        // end sourceList listener
        
        // initializing targetList listener
        targetListView.setOnDragDetected((MouseEvent event) -> {
            _eventHandler.onDragDetected(event, PICTO_LIST, targetListView);
        });
        
        targetListView.setOnDragOver((DragEvent event) -> {
            _eventHandler.onDragOver(event, PICTO_LIST, targetListView);
        });
        
        targetListView.setOnDragDropped((DragEvent event) -> {
            _eventHandler.onDragDropped(event, PICTO_LIST, targetListView, resultLabel);
        });
        
        targetListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, targetListView);
        });
        // end initializing targetList listener
        
    }
}