/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.controller;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx_pictogramtostring.service.RuleController;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class CustomEventHandler 
{
    private RuleController ruleController = null;
    
    public CustomEventHandler()
    {
        ruleController = new RuleController();
    }
    
    public void onDragDetected(Event event,DataFormat dataFormat, ListView<Pictogram> listView)
    {
        String item = listView.getItems().get(listView.getSelectionModel().getSelectedIndex()).toString();
        
        Dragboard db = listView.startDragAndDrop(TransferMode.MOVE);
        
        ClipboardContent content = new ClipboardContent();
        System.out.println("Selectet Item" + item);
        // Put the the selected items to the dragboard
        ArrayList<Pictogram> selectedItems = new ArrayList<>(listView.getSelectionModel().getSelectedItems());
        if (item != null) {
            content.put(dataFormat, selectedItems);
            db.setContent(content);
            event.consume();
        }
    }
    
    public void onDragOver(DragEvent event,DataFormat dataFormat, ListView<Pictogram> listView)
    {
        // If drag board has an ITEM_LIST and it is not being dragged
        // over itself, we accept the MOVE transfer mode
        Dragboard dragboard = event.getDragboard();
 
        if (event.getGestureSource() != listView && dragboard.hasContent(dataFormat))
        {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();

    }
    
    public void onDragDropped(DragEvent event,DataFormat dataFormat, ListView<Pictogram> listView, Label resultLabel)
    {
        boolean dragCompleted = false;
 
        // Transfer the data to the target
        Dragboard dragboard = event.getDragboard();
        
        if(dragboard.hasContent(dataFormat))
        {
            // getting all items from the Event Dragboard
            // and building an ArrayList<Pictogram>
            ArrayList<Pictogram> list = (ArrayList<Pictogram>)dragboard.getContent(dataFormat);
            listView.getItems().addAll(list);
            
            System.out.println(event.getSource().hashCode());
            // getting the hashCode for dragEvent from sourceList to targetList
            if(event.getSource().hashCode() == 1337822282)
            {
                // setting the description Text to resultLabel
                resultLabel.setText(ruleController.getTextFromList(listView));
            }
            else
            {
                // setting the resultLabel to default text if the dragEvent hashCode
                // is not from sourceList to targetList
                resultLabel.setText(ruleController.getTextFromList(listView));
            }
            
            // Data transfer is successful
            dragCompleted = true;
        }
        // Data transfer is not successful
        event.setDropCompleted(dragCompleted);
        
        
        event.consume();
    }
    
    public void onDragDone(DragEvent event, ListView<Pictogram> listView) 
    {
        // Check how data was transfered to the target
        // If it was moved, clear the selected items
        TransferMode tm = event.getTransferMode();
        if (tm == TransferMode.MOVE)
        {
            removeSelectetItems(listView);
        }
        event.consume();
    }
    
    private void removeSelectetItems(ListView<Pictogram> listView)
    {
        // Get all selected Fruits in a separate list to avoid the shared list issue
        ArrayList<Pictogram> selectedList = new ArrayList<>();
 
        listView.getSelectionModel().getSelectedItems().stream().forEach((picto) -> {
            selectedList.add(picto);
        });
        // Clear the selection
        listView.getSelectionModel().clearSelection();
        // Remove items from the selected list
        listView.getItems().removeAll(selectedList);
    }
    
    public void onResetButtonClicked(ListView<Pictogram> sourceListView, ListView<Pictogram> targetListView, Label resultLabel)
    {
        targetListView.getItems().clear();
        sourceListView.setItems(new PictogramListBuilder().getItems());
        resultLabel.setText("Text here!");
    }

}
