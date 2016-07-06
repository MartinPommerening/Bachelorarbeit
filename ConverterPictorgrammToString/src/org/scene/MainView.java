/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scene;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

    private Scene _mainScene = null;
    private BorderPane _border = null;
    
    public MainView()
    {
        _border = new BorderPane();
        Text helloWorldText = new Text("Hello World!");
        helloWorldText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        helloWorldText.setFill(Color.WHITE);
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().add(helloWorldText);
        _border.setTop(hbox);
        
        
        _mainScene = new Scene(_border, 800, 600);
    }
    
    public final Scene getScene()
    {
        return _mainScene;
    }
    
}
