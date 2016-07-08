/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

/**
 *
 * @author Martin
 */
public class Pictogram 
{
    private javafx.scene.image.Image _image         = null;
    private String _discription                     = null;
    private String _path                            = null;
    
    private final Image _previewImage;
    private final Image _activeImage;
    private final Image _equippedImage;
    
    private final ImageView _currentImage;
    
    public Pictogram(Image[] _pictoImages)
    {
        this._previewImage = _pictoImages[0];
        this._activeImage = _pictoImages[1];
        this._equippedImage = _pictoImages[2];
        
        _currentImage = new ImageView();
        _currentImage.setImage(_previewImage);
        _currentImage.setFitHeight(100);
        _currentImage.setFitWidth(100);
        _currentImage.setId(this.getClass().getSimpleName() + System.currentTimeMillis());
        
        _currentImage.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = _currentImage.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            // Store the node ID in order to know what is dragged.
            content.putString(_currentImage.getId());
            db.setContent(content);
            event.consume();
        });
    }
    
    public void putOn() {
        _currentImage.setImage(_equippedImage);
    }
    
    public void takeOff() {
        _currentImage.setImage(_previewImage);
    }
    
    private void activate() {
        _currentImage.setImage(_activeImage);
    }
    
    public String getImageViewId() {
        return _currentImage.getId();
    }
    
    public Node getNode() {
        return _currentImage;
    }

    public Image getImage() {
        return _image;
    }

    public void setImage(Image _image) {
        this._image = _image;
    }

    public String getDiscription() {
        return _discription;
    }

    public void setDiscription(String _discription) {
        this._discription = _discription;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String _path) {
        this._path = _path;
    }

}
