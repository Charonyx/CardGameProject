/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafxml2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author chura
 */
public class MainController implements Initializable {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn1) {
            System.out.println("You have clicked OK button.");
        }
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        if (event.getSource() == btn2) {
            System.out.println("clear text");
        }
    }

}
