/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scene;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import org.model.Pictogram;


/**
 *
 * @author Martin
 */
public class ResultPane {
    private final Pane _resultPane;
    private final ImageView _resultImageView;
    private Pane _itemPane;
    private Map<String, Pictogram> _items;
    
    public void setItemsInfo(Pane p, Map<String, Pictogram> m) {
        _itemPane = p;
        _items = m;
    }

    public Pane getBodyPane() {
        return _resultPane;
    }
    
    public ResultPane() {
        _resultPane = new Pane();
        _resultImageView = new ImageView("images/dropHere.jpg");
        
        _resultPane.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            // If this is a meaningful drop...
            if (db.hasString()) {
                // Get an item ID here, which was stored when the drag started.
                String nodeId = db.getString();
                // ...search for the item in unequipped items. If it is there...
                ImageView picto = (ImageView) _itemPane.lookup("#" + nodeId);
                if (picto != null) {
                    // ... the item is removed from the unequipped list
                    // and attached to body.
                    _itemPane.getChildren().remove(picto);
                    _resultPane.getChildren().add(picto);
                    picto.relocate(0, 0);
                    success = true;
                }
                // ...anyway, the item is now equipped.
                _items.get(nodeId).putOn();
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
        _resultPane.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != _resultImageView &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
        
        _resultPane.getChildren().add(_resultImageView);
        _resultPane.setMinWidth(_resultImageView.getImage().getWidth());
        _resultPane.setPadding(new Insets(10.0));
    }
    
    public Node getNode() {
        return _resultPane;
    }
}
