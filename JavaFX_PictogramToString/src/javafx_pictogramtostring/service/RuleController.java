/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring.service;

import javafx.scene.control.ListView;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class RuleController 
{
    public String getTextFromList(ListView<Pictogram> resultList) {
        String result = "";
        
        if (resultList.getItems().isEmpty()) 
        {
            return result;
        }
        else
        {
            result = checkResultList(resultList);
        }
        return result;
    }
    
    private String checkResultList(ListView<Pictogram> resultList)
    {
        
        if(resultList.getItems().size() == 1)
        {
            return resultList.getItems().get(0).getDescription();
        }
        else if(resultList.getItems().size() == 2)
        {
            if(resultList.getItems().get(0).getType().equalsIgnoreCase("verb") 
                && resultList.getItems().get(1).getType().equalsIgnoreCase("Satzzeichen"))
            {
                return "Wo kann ich "+ resultList.getItems().get(0).getDescription()+"?";
            }
            
        }
        return "TextHere!";   
    }
}


