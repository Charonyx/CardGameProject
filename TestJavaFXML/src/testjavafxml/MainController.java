/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author somsakw
 */
public class MainController implements Initializable {

    @FXML
    private Button okBtn;
    @FXML
    private TextField tf;
    @FXML
    private Button clearBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOkBtnAction(ActionEvent event) {
        System.out.println("You have click ok button");
        tf.setText("You have click ok button");
    }

    @FXML
    private void handleClearBtnAction(ActionEvent event) {
        System.out.println("Clear text");
        tf.clear();
    }
    
}