/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.controller;
import javafx_pictogramtostring.service.ImageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class PictogramListBuilder
{
    private ObservableList<Pictogram> _pictoList;
    
    public ObservableList getItems()
    {
        if(_pictoList == null)
        {
            buildPictogramList();
        }
        return _pictoList;
    }
    
    private void buildPictogramList()
    {
        _pictoList = FXCollections.observableArrayList();
        for(int i = 0; i < 3; i++)
        {
            Pictogram picto = new Pictogram("changeTheDiapers", "Windeln wechseln","verb",getPictogramImage("change_the_diapers.png"));
            _pictoList.add(picto);
        }
        Pictogram picto = new Pictogram("", "fragezeichen", "Satzzeichen", getPictogramImage("fragezeichen.png"));
        _pictoList.add(picto);
    }
    
    private Image getPictogramImage(String name)
    {
        Image pictogramImage = ImageManager.getImage("Images/"+name);
        return pictogramImage;
    }
    
    public void removeAll(ObservableList obList)
    {
        this._pictoList.removeAll(obList);
    }
    
    public void removeItem(Pictogram item)
    {
        this._pictoList.remove(item);
    }

    
}
