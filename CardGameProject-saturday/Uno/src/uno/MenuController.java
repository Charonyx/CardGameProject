/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private Button rank;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Image icon = new Image("img/engoLogo.png");

    @FXML
    private AnchorPane menuScene;
    @FXML
    private ImageView hoverPlay;
    @FXML
    private ImageView hoverHowto;
    @FXML
    private ImageView hoverDirect;
    @FXML
    private ImageView hoverExit;
    @FXML
    private AnchorPane loaderScene;
    @FXML
    private ProgressBar loaderBar;
    @FXML
    private Label load1;
    @FXML
    private Label load2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // --------------- CHECK FILE SOUND ----------------------
//        File file = new File(musicMenu);
//        System.out.println("exists : " + file.exists());
//        System.out.println("isfile : " + file.isFile());

        // --------------- ADD SOUND ----------------------
        Media sound = new Media(new File(musicMenu).toURI().toString());
        mediaMenu = new MediaPlayer(sound);
        mediaMenu.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaMenu.seek(Duration.ZERO);
            }
        });
        mediaMenu.play();
        mediaMenu.setVolume(musicVolumn);

        hoverShowImage();
        if (accessLoader == true) {
            startLoader();
            accessLoader = false;
            
        } else {
            loaderScene.setVisible(false);
        }
    }

    @FXML
    private void actionPlay(ActionEvent event) throws IOException {
//        mediaMenu.stop();
        playSoundClick();

        root = FXMLLoader.load(getClass().getResource("Play.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionHowto(ActionEvent event) throws IOException {
        playSoundClick();
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
        playSoundClick();

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

    @FXML
    private void actionRank(ActionEvent event) throws IOException {
        mediaMenu.stop();
        playSoundClick();

        Media sound = new Media(new File(musicRank).toURI().toString());
        mediaRank = new MediaPlayer(sound);
        mediaRank.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaRank.seek(Duration.ZERO);
            }
        });
        mediaRank.play();
        mediaRank.setVolume(musicVolumn);

        root = FXMLLoader.load(getClass().getResource("Rank.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    
    //-------------- SET HOVER BUTTON TO SHOW IMAGE ---------------
    private void hoverShowImage() {

        hoverPlay.setVisible(false);
        hoverHowto.setVisible(false);
        hoverDirect.setVisible(false);
        hoverExit.setVisible(false);

        play.hoverProperty().addListener((event) -> {
            if (true) {
                hoverPlay.setVisible(true);
//                System.out.println("hover");
            }
        });
        howto.hoverProperty().addListener((event) -> {
            hoverHowto.setVisible(true);
        });
        direct.hoverProperty().addListener((event) -> {
            hoverDirect.setVisible(true);
        });
        exit.hoverProperty().addListener((event) -> {
            hoverExit.setVisible(true);
        });

        play.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                hoverPlay.setVisible(false);
            }
        });
        howto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                hoverHowto.setVisible(false);
            }
        });
        direct.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                hoverDirect.setVisible(false);
            }
        });
        exit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                hoverExit.setVisible(false);
            }
        });
    }

    // ------------------------- LOADER SCENE -------------------------
    private void startLoader() {
        Timeline task = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(loaderBar.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.seconds(4),
                        new KeyValue(loaderBar.progressProperty(), 1)
                )
                
        );
        task.playFromStart();

        PauseTransition visiblePause = new PauseTransition(Duration.seconds(4.5));
        visiblePause.setOnFinished(event -> {
            loaderScene.setVisible(false);
            playSoundCardWild();
        });
//        visiblePause.setOnFinished(event -> playSoundCardWild());
        visiblePause.play();
        
    }
}
