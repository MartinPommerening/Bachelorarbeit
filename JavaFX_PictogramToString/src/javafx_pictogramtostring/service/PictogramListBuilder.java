/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx_pictogramtostring.model.Pictogram;

/**
 *
 * @author Martin
 */
public class PictogramListBuilder
{
    private ObservableList<Pictogram> _subjectListList;
    private ObservableList<Pictogram> _predicateList;
    private ObservableList<Pictogram> _objectList;
    
    public ObservableList getSubjcetPictograms()
    {
        if(_subjectListList == null)
        {
            buildSubjectPictogramList();
        }
        return _subjectListList;
    }
    
    public ObservableList getPredicatePictograms()
    {
        if(_predicateList == null)
        {
            buildPredicatePictogramList();
        }
        return _predicateList;
    }
    public ObservableList getObjectPictograms()
    {
        if(_objectList == null)
        {
            buildObjectPictogramList();
        }
        return _objectList;
    }
    
    private void buildSubjectPictogramList()
    {}
    
    private void buildPredicatePictogramList()
    {
        _predicateList = FXCollections.observableArrayList();
        Pictogram picto = new Pictogram("Windeln wechseln","verb",getPictogramImage("change_the_diapers.png"));
        Pictogram picto1 = new Pictogram("einkaufen","verb",getPictogramImage("einkaufen.png"));
        Pictogram picto2 = new Pictogram("parken","verb",getPictogramImage("parken.png"));
        Pictogram picto3 = new Pictogram("trinken","verb",getPictogramImage("trinken.png"));
        
        _predicateList.addAll(picto,picto1,picto2,picto3);
    }
    
    private void buildObjectPictogramList()
    {}
    
//    private void buildPictogramList()
//    {
//        _pictoList = FXCollections.observableArrayList();
//        for(int i = 0; i < 3; i++)
//        {
//            Pictogram picto = new Pictogram("Windeln wechseln","verb",getPictogramImage("change_the_diapers.png"));
//            _pictoList.add(picto);
//        }
//        Pictogram picto = new Pictogram("", "fragezeichen", "Satzzeichen", getPictogramImage("fragezeichen.png"));
//        _pictoList.add(picto);
//    }
    
    private Image getPictogramImage(String name)
    {
        Image pictogramImage = ImageManager.getImage("Images/"+name);
        return pictogramImage;
    }
}
