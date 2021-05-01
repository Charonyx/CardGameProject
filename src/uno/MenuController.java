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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import static uno.Music.*;

/**
 * FXML Controller class
 *
 * @author chura
 */
public class MenuController implements Initializable {

    @FXML
    private Button play;
    @FXML
    private Button howto;
    @FXML
    private Button direct;
    @FXML
    private Button exit;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Image icon = new Image("img/engoLogo.png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        mediaRank.stop();
//        mediaDirect.stop();
//        mediaGame.stop();
//        mediaHowto.stop();
        // --------------- ADD SOUND ----------------------

//        File file = new File(musicMenu);
//        System.out.println("exists : " + file.exists());
//        System.out.println("isfile : " + file.isFile());
        Media sound = new Media(new File(musicMenu).toURI().toString());
        mediaMenu = new MediaPlayer(sound);
        mediaMenu.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaMenu.seek(Duration.ZERO);
            }
        });
        mediaMenu.play();
        mediaMenu.setVolume(musicVolumn);
    }

    @FXML
    private void actionPlay(ActionEvent event) throws IOException {
//        mediaMenu.stop();

//        play.getOnDragDone().
//        playSoundEffect(sourceType, soundType);

        Media sound2 = new Media(new File(sourceClick).toURI().toString());
        soundClick = new MediaPlayer(sound2);
        soundClick.play();
        soundClick.stop();

        root = FXMLLoader.load(getClass().getResource("Play.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionHowto(ActionEvent event) throws IOException {

        mediaMenu.stop();

        Media sound = new Media(new File(musicHowto).toURI().toString());
        mediaHowto = new MediaPlayer(sound);
        mediaHowto.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaHowto.seek(Duration.ZERO);
            }
        });
        mediaHowto.play();
        mediaHowto.setVolume(musicVolumn);

        root = FXMLLoader.load(getClass().getResource("Howto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionDirect(ActionEvent event) throws IOException {

        mediaMenu.stop();
        Media sound = new Media(new File(musicDirect).toURI().toString());
        mediaDirect = new MediaPlayer(sound);
        mediaDirect.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaDirect.seek(Duration.ZERO);
            }
        });
        mediaDirect.play();
        mediaDirect.setVolume(musicVolumn);

        root = FXMLLoader.load(getClass().getResource("Direct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionExit(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

}
