/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import images.ImageManager;


/**
 *
 * @author Martin Pommerening
 */
public class PictogramListBuilder
{
    private List<Pictogram> _pictogramList;
    
     private final String []pictogramNames = {
        "img01.jpg", "dress2.png", "dress3.png", "dress4.png"
    };
    
    private Image[] getPictogramImages(String pictoName) {
        Image []pictogramImages = new Image[3];
        pictogramImages[0] = ImageManager.getImage(pictoName);
        pictogramImages[1] = ImageManager.getImage(pictoName);
        pictogramImages[2] = ImageManager.getImage(pictoName);
        
        return pictogramImages;
    }
    
     private void buildPictogramList()
    {
        _pictogramList = new ArrayList<>();

        for (String pictoName : pictogramNames) {
            Pictogram picto = new Pictogram(getPictogramImages(pictoName));
            _pictogramList.add(picto);
        }
    }
    
   
    
    public void add(Pictogram _picto)
    {
        _pictogramList.add(_picto);
    }
    
    public void removeIndex(int _index)
    {
        _pictogramList.remove(_index);
    }
    
    public void removeObject(Pictogram _picto)
    {
        _pictogramList.remove(_picto);
    }
    
    public void removeAll()
    {
        _pictogramList.removeAll(_pictogramList);
    }
    
    public int size()
    {
       return  _pictogramList.size();
    }
    
    public List<Pictogram> getPictorgrammList()
    {
        if(_pictogramList == null)
        {
            buildPictogramList();
        }
        return _pictogramList;
    }
}
