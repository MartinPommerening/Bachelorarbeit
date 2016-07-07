/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.ArrayList;


/**
 *
 * @author Martin Pommerening
 */
public class SourceImageContainer
{
    private ArrayList<Pictrogram> _listSourceImage = null;
    
    public SourceImageContainer()
    {
        _listSourceImage = new ArrayList<>();
    }
    
    public void add(Pictrogram _picto)
    {
        _listSourceImage.add(_picto);
    }
    
    public void removeIndex(int _index)
    {
        _listSourceImage.remove(_index);
    }
    
    public void removeObject(Pictrogram _picto)
    {
        _listSourceImage.remove(_picto);
    }
    
    public void removeAll()
    {
        _listSourceImage.removeAll(_listSourceImage);
    }
    
    public int size()
    {
       return  _listSourceImage.size();
    }
}
