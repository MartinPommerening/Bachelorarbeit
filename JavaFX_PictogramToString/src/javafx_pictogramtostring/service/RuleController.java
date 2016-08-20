/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.service;

import javafx.scene.control.ListView;

/**
 *
 * @author Martin
 */
public class RuleController 
{
    public String getTextFromList(ListView resultList) {
        String result = "";
        
        if (resultList.getItems().isEmpty()) 
        {
            return result;
        }
        else
        {
            checkResultList(resultList);
        }
        return result;
    }
    
    private void checkResultList(ListView resultList)
    {
        
    }
}


