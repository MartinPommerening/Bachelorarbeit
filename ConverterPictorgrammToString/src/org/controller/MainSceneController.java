/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import javafx.stage.Stage;
import org.scene.MainView;

/**
 *
 * @author Martin
 */
public class MainSceneController 
{
    private static MainSceneController _instance = null;
    private MainView _mainView = null;
    
    public static MainSceneController getInstance(Stage _primaryStage)
    {
        if(_instance == null)
        {
            _instance = new MainSceneController(_primaryStage);
        }
        
        return _instance;
    }
    
    private MainSceneController(Stage _primaryStage)
    {
        // creating an new MainView Object
        _mainView = new MainView();
        
        // get the Scene from _mainView and set it as Scene for the primaryStage
        _primaryStage.setScene(_mainView.getScene());
        
        // 
        _primaryStage.sizeToScene();
        _primaryStage.show();
    }
    
    
}
