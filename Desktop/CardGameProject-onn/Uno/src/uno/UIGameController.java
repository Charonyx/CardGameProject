/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class UIGameController implements Initializable {

    @FXML
    private HBox GameBtn, HandCard;
    @FXML
    private Rectangle card1,card2,card3,card4,card5;
    @FXML
    private Rectangle deck,playcard;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void useHit(ActionEvent event) {
    }

    @FXML
    private void useUno(ActionEvent event) {
    }
    
    public void PlayerDraw(){
        
    }
}
