/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_pictogramtostring;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import model.Pictogram;

/**
 *
 * @author Martin
 */
public class ListViewCell extends ListCell<Pictogram>
{
    @Override
    public void updateItem(Pictogram item, boolean empty)
    {
        super.updateItem(item,empty);
        if(item == null || empty)
        {
            // ToDo set Data in listCell
            setGraphic(null);
        }
        else
        {
            // ToDo set Data in listCell
            ImageView imageView = new ImageView(item.getImage());
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            setGraphic(imageView);
        }
    }
}
