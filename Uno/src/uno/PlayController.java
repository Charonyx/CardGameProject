/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Font;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class PlayController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage stage1;
    private Scene scene1;
    private Parent root1;
    @FXML
    private Button home;
    @FXML
    private Button setName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionSetName(ActionEvent event)  throws IOException {

//        new AddPlayerNames().setVisible(true);
//        this.dipose();
        if (setName.getText().isBlank()) {
            JLabel msg = new JLabel("Please enter your name");
            msg.setFont(new Font("Tahoma", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, msg);
        } else {
            String name = setName.getText().trim();

            //save file txt
            root = FXMLLoader.load(getClass().getResource("../gameengo/MAIN.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
            stage.setScene(scene);
            stage.show();

//            Parent root = FXMLLoader.load(getClass().getResource("../gameengo/MAIN.fxml")); //play
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle("Engo");
//            stage.show();
        }
    }

}
