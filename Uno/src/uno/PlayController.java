/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import data.DataFile;
import java.awt.Font;
import java.io.*;
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
import java.util.ArrayList;
import javafx.scene.media.*;
import javafx.util.Duration;
import static uno.Music.*;

/**
 * FXML Controller class
 *
 * @author ROG
 * @author chura
 */
public class PlayController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
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
        mediaMenu.stop();
//        mediaRank.stop();
//        mediaDirect.stop();
//        mediaHowto.stop();
//        mediaGame.stop();

        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionSetName(ActionEvent event) throws IOException, ClassNotFoundException {
//        new AddPlayerNames().setVisible(true);
//        this.dipose();
        if (event.getSource() == setName) {
            if (name.getText().isBlank()) {
                System.out.println("nooo");
                
//                alerr
//                JLabel msg = new JLabel("Please en    ter your name");
//                msg.setFont(new Font("Tahoma", Font.BOLD, 48));
//                JOptionPane.showMessageDialog(null, "oh nooooo");
//                System.out.println(name.getText());
//                System.out.println("1234"+String.format("%s", name));
            } else {
                mediaMenu.stop();

                Media sound = new Media(new File(musicGame).toURI().toString());
                mediaGame = new MediaPlayer(sound);
                mediaGame.setOnEndOfMedia(new Runnable() {
                    public void run() {
                        mediaGame.seek(Duration.ZERO);
                    }
                });
                mediaGame.play();
                mediaGame.setVolume(musicVolumn);

//                String namePlayer = name.getText().trim();
//                System.out.println("name" + name.getText());
//                DataFile collectName = new DataFile(name.getText());
////                System.out.println(haveFile());
////                System.out.println("123"+String.format("%s", name));
//                int score = 0;
//                System.out.println(name.getText() + "," + score);               
//                DataFile data = new DataFile(name.getText(), score);
//                data.writeData();
//                data.readData();
//                /---------------SEND NAME TO GAME SCENE------------------
//                textName = name.getText();
//                try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("name.dat"))) {
//            out.writeObject(new ));
//        }
                //save file txt
                ObjectOutputStream wName = new ObjectOutputStream(new FileOutputStream("../Uno/src/data/name.dat"));
                DataOutputStream wScore = new DataOutputStream(new FileOutputStream("../Uno/src/data/score.dat"));
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FXML+"data/nameOfBot.dat"));
//                DataInputStream rPlayer = new DataInputStream(new FileInputStream(DATA_FXML+"data/player.dat"));

                ArrayList<String> nameArrayList = new ArrayList<>();

//                int num = rPlayer.readInt();
//                rPlayer.close();
//                ArrayList<String> botName = (ArrayList<String>) ois.readObject();
//                ois.close();
                nameArrayList.add(name.getText());
//                for (int i = 1; i <= num; i++) {
//                    String st = botName.get((int) (Math.random() * botName.size()));
//                    a.add(st);
//                    botName.remove(a);
//                }
                wName.writeObject(nameArrayList);
                wName.close();

                wScore.writeInt(0);
                wScore.close();

                root = FXMLLoader.load(getClass().getResource("MAIN.fxml"));
//                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
                stage.setScene(scene);
                stage.show();

            }
        }
    }

}
