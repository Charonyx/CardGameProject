/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chura
 */
public class Test extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Button btn1 = new Button("Hello World!");
        StackPane pane = new StackPane();
        pane.getChildren().add(btn1);
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Test JavaFX");
        stage.setScene(scene);
        stage.show();
    }

}
