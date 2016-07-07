/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import javafx.scene.image.Image;

/**
 *
 * @author Martin
 */
public class Pictrogram 
{
    private javafx.scene.image.Image _image         = null;
    private String _discription                     = null;
    private String _path                            = null;
    
public Pictrogram(javafx.scene.image.Image _img, String _disc, String _url)
    {
        this._image          = _img;
        this._discription    = _disc;
        this._path           = _url;
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
