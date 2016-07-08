/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import javafx.scene.image.Image;

/**
 *
 * @author Martin
 */
public class ImageManager 
{
    public static String getResource(String resource) {
        return ImageManager.class.getResource(resource).toExternalForm();
    }
    
    public static Image getImage(String image) {
        return new Image(getResource(image));
    }
    
}
