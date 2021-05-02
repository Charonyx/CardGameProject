/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etc;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author chura
 */
public class LoaderController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ProgressBar loaderBar;
    @FXML
    private Label load1;
    @FXML
    private Label load2;

    private double progess = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        readFile();
//        increaseBar();
//        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
////        Pane root2 = new Pane();
////        ImageView background = new ImageView(new Image("img/menu.png", 1080, 720, false, true));
////        root2.getChildren().add(background);
////
//        Scene scene = new Scene(root, 1080, 720);
//        stage.setTitle("ENGO!");
////
////        Image icon = new Image("img/engoLogo.png");
////        stage.getIcons().add(icon);
////
////        //add pic menu
////        Image logo = new Image("img/engoLogo.png");
//////        Image logo = new Image(new File("img/logonobg.png").toURI().toURL()); -> onn test can not resolve this QAQ
////        ImageView imageView = new ImageView(logo);
//
//        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();

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

    }

    private void readFile() {
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                File file = new File("../Uno/src/pic");
                File[] listFile = file.listFiles();
                for (int i = 0; i < listFile.length; i++) {
                    updateProgress(i, listFile.length);
                    updateMessage(listFile[i].getName());
                    Thread.sleep(10);

                }
                return null;
            }

        };

        task.messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> find, String file1, String file2) {
                load2.setText(file2 + "...");
            }

        });

        loaderBar.progressProperty().unbind();
        loaderBar.progressProperty().bind(task.progressProperty());

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void increaseBar() {
//        if (progess <= 100) {
        for (int i = 0; i < 1; i+=0.1) {
            loaderBar.setProgress(i);

        }

//        }
    }

}
