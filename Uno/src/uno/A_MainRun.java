package uno;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A_MainRun extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));


        Pane root2 = new Pane();
        ImageView background = new ImageView(new Image("img/menu.png", 1080, 720, false, true));
        root2.getChildren().add(background);

        Scene scene = new Scene(root, 1080, 720);

        stage.setTitle("ENGO!");


        Image icon = new Image("img/engoLogo.png");
        stage.getIcons().add(icon);

        //add pic menu
        Image logo = new Image("img/engoLogo.png");
//        Image logo = new Image(new File("img/logonobg.png").toURI().toURL()); -> onn test can not resolve this QAQ
        ImageView imageView = new ImageView(logo);

         // --------------- ADD SOUND ----------------------
        String musicFile = "../Uno/src/sound/howtoplay.mp3";

        File file = new File(musicFile);
        System.out.println("isfile exists : " + file.exists());
        System.out.println("isfile : " + file.isFile());

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(70.5);
        
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
