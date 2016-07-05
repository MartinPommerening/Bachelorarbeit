/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import javafx.stage.Stage;
import org.services.EventManager;

/**
 *
 * @author Martin
 */
public class ApplicationController 
{
    private static ApplicationController _instance  = null;
    private EventManager _eventManager              = null;
    
    public static ApplicationController getInstance()
    {
        if(_instance == null)
        {
            _instance = new ApplicationController();
        }
        
        return _instance;
    }
    
    public void initialize(Stage _primaryStage)
    {
        _primaryStage.setTitle("PictrogrammToString");
        _primaryStage.
    }
    
    private ApplicationController()
    {
        _eventManager = new EventManager();
    }
}
