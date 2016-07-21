/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_fxml_test.controller;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx_fxml_test.service.ImageManager;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class PictogramListBuilder 
{
    private ObservableList<Pictogram> _pictoList;
    
    public ObservableList<Pictogram> getPictogramList()
    {
        if(this._pictoList == null)
        {
            buildPictogramList();
        }
        return this._pictoList;
    }
    
    private void buildPictogramList()
    {
        _pictoList = FXCollections.observableArrayList();
        for(int i = 0; i < 3; i++)
        {
            Pictogram picto = new Pictogram(i, "changeTheDiapers", "Windeln wechseln",getPictogramImage("change_the_diapers.png"));
            _pictoList.add(picto);
        }
    }
    
    private Image getPictogramImage(String name)
    {
        Image pictogramImage = ImageManager.getImage("Images/"+name);
        return pictogramImage;
    }
}
