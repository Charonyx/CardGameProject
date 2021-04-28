/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import data.DataFile;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import data.DataFile;

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
    @FXML
    private TextField name;

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
    private void actionSetName(ActionEvent event) throws IOException {

//        new AddPlayerNames().setVisible(true);
//        this.dipose();
        if (event.getSource() == setName) {
            if (name.getText().isBlank()) {
                System.out.println("nooo");
//                JLabel msg = new JLabel("Please en    ter your name");
//                msg.setFont(new Font("Tahoma", Font.BOLD, 48));
//                JOptionPane.showMessageDialog(null, "oh nooooo");
//                System.out.println(name.getText());
//                System.out.println("1234"+String.format("%s", name));
            } else {
                String namePlayer = name.getText().trim();
                System.out.println("name" + name.getText());
//                System.out.println(haveFile());
//                System.out.println("123"+String.format("%s", name));
                double score = 0;
                System.out.println(name.getText() + "," + score);
                //DataFile(name.getText(),score);

                DataFile data = new DataFile(name.getText(),score);
                data.writeData();
                data.readData();
//                try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("name.dat"))) {
//            out.writeObject(new ));
//        }


                //save file txt
                
                
                root = FXMLLoader.load(getClass().getResource("../gameengo/MAIN.fxml"));
//                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
                stage.setScene(scene);
                stage.show();

            }
        }
//            Parent root = FXMLLoader.load(getClass().getResource("../gameengo/MAIN.fxml")); //play
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle("Engo");
//            stage.show();
    }

   
        
}
