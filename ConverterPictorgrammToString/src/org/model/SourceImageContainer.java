/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.awt.List;

/**
 *
 * @author Martin
 */
public class SourceImageContainer extends List
{
    private static SourceImageContainer _instance = null;
    
    public static SourceImageContainer getInstance()
    {
        if(_instance == null)
        {
            _instance = new SourceImageContainer();
        }
        return _instance;
    }
    
    private SourceImageContainer()
    {}
}
