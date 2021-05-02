/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import static uno.Music.*;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class HowtoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane howto1;
    @FXML
    private AnchorPane howto2;
    @FXML
    private Button p1;
    @FXML
    private Button p2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaMenu.stop();
        
        howto1.setVisible(true);
        howto2.setVisible(false);
        
        
    }

    @FXML
    private void actionBack(ActionEvent event) throws IOException {
        mediaHowto.stop();
        playSoundClick();

        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionPage1(ActionEvent event) {
        playSoundClick();
        howto1.setVisible(true);
        howto2.setVisible(false);
    }

    @FXML
    private void actionPage2(ActionEvent event) {
        playSoundClick();
        howto1.setVisible(false);
        howto2.setVisible(true);
    }

}
