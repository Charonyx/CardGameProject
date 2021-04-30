/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.*;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chura
 */
public class RankController implements Initializable {

    @FXML
    private TextField name1;
    @FXML
    private TextField score1;
    @FXML
    private TextField name2;
    @FXML
    private TextField score2;
    @FXML
    private TextField name3;
    @FXML
    private TextField score3;
    @FXML
    private TextField name4;
    @FXML
    private TextField score4;
    @FXML
    private TextField name5;
    @FXML
    private TextField score5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        ArrayList<String> leaderName = null;
        ArrayList<Integer> leaderScore = null;
//        try {
//            ois = new ObjectInputStream(new FileInputStream("Data/data.dat"));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            leaderName = (ArrayList<String>) ois.readObject();
//        } catch (IOException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            leaderScore = (ArrayList<Integer>) ois.readObject();
//        } catch (IOException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            ois.close();
//        } catch (IOException ex) {
//            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        name1.setText(leaderName.get(0));
        name2.setText(leaderName.get(1));
        name3.setText(leaderName.get(2));
        name4.setText(leaderName.get(3));
        name5.setText(leaderName.get(4));

        score1.setText(Integer.toString(leaderScore.get(0)));
        score2.setText(Integer.toString(leaderScore.get(1)));
        score3.setText(Integer.toString(leaderScore.get(2)));
        score4.setText(Integer.toString(leaderScore.get(3)));
        score5.setText(Integer.toString(leaderScore.get(4)));
    }
    

//    @FXML
//    private void actionBack(ActionEvent event) {
//    }

}