/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scene;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 *
 * @author Martin
 */
public class MainView
{

    private Scene _mainScene            = null;
    private BorderPane _border          = null;
    private Image _image                = null;
    private ImageView _imageView        = null;
    
    public MainView(Pane _targetPane, FlowPane _itemPane)
    {
        this._border    = new BorderPane();
        
        this._border.setTop(generateTopContent());
        this._border.setCenter(_targetPane);
        this._border.setBottom(generateBottomContent(_itemPane));
        
        _mainScene = new Scene(_border, 800, 600);
    }
    
    private HBox generateTopContent()
    {
        Text helloWorldText = new Text("Hello World!");
        helloWorldText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        helloWorldText.setFill(Color.WHITE);
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().add(helloWorldText);
        
        return hbox;
    }
    
    private FlowPane generateBottomContent(FlowPane _flow)
    {
        _flow.setPadding(new Insets(5, 0, 5, 0));
        //flow.setVgap(4);
        _flow.setHgap(10);
        _flow.setPrefWrapLength(300); // preferred width allows for two columns
        _flow.setStyle("-fx-background-color: DAE6F3;");
        
        return _flow;
    }
    
//    public void setSourceData(ListArray<> _sourceList)
//    {
//        
//    }
    
    public final Scene getScene()
    {
        return _mainScene;
    }
    
}
