/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services;

/**
 *
 * @author Martin
 */
public class EventManager 
{
    private static EventManager _instance = null;
    
    public static EventManager getInstance()
    {
        if(_instance == null)
        {
            _instance = new EventManager();
        }
        return _instance;
    }
    
    private EventManager()
    {
        
    }
    
}
