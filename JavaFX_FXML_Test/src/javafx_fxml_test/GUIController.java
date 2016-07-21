/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_fxml_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx_fxml_test.controller.PictogramListBuilder;
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
    
    private PictogramListBuilder sourceItems;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sourceItems = new PictogramListBuilder();
        initializeListView();
    } 
    
    private void initializeListView()
    {
        sourceListView.setItems(sourceItems.getPictogramList());
        sourceListView.setCellFactory(new Callback<ListView<Pictogram>, ListCell<Pictogram>>() {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> list) {
                return new PictogramListCell();
            }
        }
        );
    }
    
    static class PictogramListCell extends ListCell<Pictogram> {

        @Override
        public void updateItem(Pictogram item, boolean empty) {
            super.updateItem(item, empty);

            if (item != null) {
                ImageView node = new ImageView(item.getImage());
                node.setFitWidth(100);
                node.setFitHeight(100);
                setGraphic(node);
            }
        }
    }
    
}
