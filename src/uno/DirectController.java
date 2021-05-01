/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static uno.Music.*;

/**
 * FXML Controller class
 *
 * @author chura
 */
public class DirectController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaMenu.stop();
    }

    @FXML
    private void actionBack(ActionEvent event) throws IOException {
        mediaDirect.stop();
        
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
