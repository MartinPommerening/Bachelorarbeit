/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;


/**
 *
 * @author Martin
 */
public class Pictogram implements Serializable
{
    private static final long   serialVersionUID = 1L;
    private String              _name;
    private String              _description;
    private transient Image     _image;
    private String              _type;
    
    public Pictogram() 
    {  
    }

            
    public Pictogram(String name, String description, String type, Image image)
    {
        this._name          = name;
        this._description   = description;
        this._type          = type;
        this._image         = image;
    }
    
    public String getName()
    {
        return this._name;
    }
    
    public void setName(String name)
    {
        this._name = name;
    }
    
    public String getDescription()
    {
        return this._description;
    }
    
    public Image getImage()
    {
        return this._image;
    }
    
    public String getType()
    {
        return this._type;
    }
    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this._image = SwingFXUtils.toFXImage(ImageIO.read(s), null);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        ImageIO.write(SwingFXUtils.fromFXImage(this._image, null), "png", s);
    }
    
//    public String getType()
//    {
//        return this._type;
//    }
}
