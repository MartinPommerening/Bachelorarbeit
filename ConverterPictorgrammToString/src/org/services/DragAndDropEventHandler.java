/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Martin
 */
public class DragAndDropEventHandler implements EventHandler<MouseEvent>
{
    private Dragboard _db = null;
    private ClipboardContent _clipBoard = null;
    private ImageView _ImageSource = null;
    
    @Override
    public void handle(MouseEvent event) {
        System.out.println("org.services.DragAndDropEventHandler.handle()");
        
    }
    
//    public DragAndDropEventHandler(ImageView _source)
//    {
//        _db = _source.startDragAndDrop(TransferMode.ANY);
//        _clipBoard = new ClipboardContent();
//        _ImageSource = _source;  
//    }
    
    public DragAndDropEventHandler()
    {
        
    }
}
