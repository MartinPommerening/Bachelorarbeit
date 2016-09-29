/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx_pictogramtostring.model.ListViewCell;
import javafx_pictogramtostring.service.CustomEventHandler;
import javafx_pictogramtostring.service.PictogramListBuilder;
import javafx_pictogramtostring.model.Pictogram;

/**
 *
 * @author Martin
 */
public class GUIController implements Initializable {
    
    @FXML
    private ListView _subjectListView;
    
    @FXML
    private ListView _predicateListView;
    
    @FXML
    private ListView _objectListView;
    
    @FXML
    private ListView _targetListView;
    
    @FXML 
    private Label _resultLabel;
    
    @FXML
    private Button _resetButton;
    
    
    private PictogramListBuilder    _pictogramListBuilder;
    
    static final DataFormat         PICTO_LIST = new DataFormat("PictoList");
    
    private CustomEventHandler      _eventHandler;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _pictogramListBuilder   = new PictogramListBuilder();
        _eventHandler           = new CustomEventHandler();
        
        initializeListView();
        initializeListener();
    } 
    
    private void initializeListView()
    {
        //initialize subjectListView
        _subjectListView.setItems(_pictogramListBuilder.getSubjcetPictograms());
        _subjectListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        _subjectListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
        // end initialize SubjectListView
        
        _predicateListView.setItems(_pictogramListBuilder.getPredicatePictograms());
        _predicateListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        _predicateListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
        
        _objectListView.setItems(_pictogramListBuilder.getObjectPictograms());
        _objectListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        _objectListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
        
        _targetListView.setCellFactory(new Callback<ListView<Pictogram>,ListCell<Pictogram>>()
        {
            @Override
            public ListCell<Pictogram> call(ListView<Pictogram> listView)
            {
                return new ListViewCell();
            }
        });
    }
    
    private void initializeListener()
    {
        // start initialize subjectList listener
        _subjectListView.setOnDragDetected((MouseEvent event) -> {
            _eventHandler.onDragDetected(event, PICTO_LIST, _subjectListView);
        });
        
        _subjectListView.setOnDragOver((DragEvent event) ->{
            _eventHandler.onDragOver(event, PICTO_LIST, _subjectListView);
        });
        
        _subjectListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, _subjectListView);
        });
        // end initialize subjectList listener
        
        // start sourceList listener
        _predicateListView.setOnDragDetected((MouseEvent event) -> {
            _eventHandler.onDragDetected(event, PICTO_LIST, _predicateListView);
        });
        
        _predicateListView.setOnDragOver((DragEvent event) ->{
            _eventHandler.onDragOver(event, PICTO_LIST, _predicateListView);
        });
        
        _predicateListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, _predicateListView);
        });
        // end sourceList listener
        
        // start sourceList listener
        _objectListView.setOnDragDetected((MouseEvent event) -> {
            _eventHandler.onDragDetected(event, PICTO_LIST, _objectListView);
        });
        
        _objectListView.setOnDragOver((DragEvent event) ->{
            _eventHandler.onDragOver(event, PICTO_LIST, _objectListView);
        });
        
        _objectListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, _objectListView);
        });
        // end sourceList listener
        
        
        _targetListView.setOnDragOver((DragEvent event) -> {
            _eventHandler.onDragOver(event, PICTO_LIST, _targetListView);
        });
        
        _targetListView.setOnDragDropped((DragEvent event) -> {
            _eventHandler.onDragDropped(event, PICTO_LIST, _targetListView, _resultLabel);
        });
        
        _targetListView.setOnDragDone((DragEvent event) -> {
            _eventHandler.onDragDone(event, _targetListView);
        });
        // end initializing targetList listener
        
        //setting up resetButtonOnClickListener
        _resetButton.setOnMouseClicked((MouseEvent event) -> {
            _eventHandler.onResetButtonClicked(_predicateListView,_subjectListView,_objectListView, _targetListView, _resultLabel);
        });
        
    } 
}