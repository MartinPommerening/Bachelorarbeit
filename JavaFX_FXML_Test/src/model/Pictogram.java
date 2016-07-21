/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;


/**
 *
 * @author Martin
 */
public class Pictogram 
{
    private final int _id;
    private final String _name;
    private final String _description;
    private final Image _image;
    
    public Pictogram(int id, String name, String description, Image image)
    {
        this._id = id; 
        this._name = name;
        this._description = description;
        this._image = image;
    }
    
    public String getName()
    {
        return this._name;
    }
    
    public int getID()
    {
        return this._id;
    }
    
    public String getDescription()
    {
        return this._description;
    }
    
    public Image getImage()
    {
        return this._image;
    }
}
