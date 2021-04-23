
package uno;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A_MainRun extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //StackPane pane = new StackPane();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
//        FXMLLoader loader = new FXMLLoader(new File("fullpath").toURI().toURL());
//        Parent root = loader.load();
        
        //Group root = new Group();
        Scene scene = new Scene(root,1080,720);
        
        stage.setTitle("ENGO!");
        
        //add pic icon
        Image icon = new Image("img/logo.png");
        stage.getIcons().add(icon);
        
        //add pic menu
        Image logo = new Image("img/logonobg.png");
//        Image logo = new Image(new File("img/logonobg.png").toURI().toURL()); -> onn test can not resolve this QAQ
        ImageView imageView = new ImageView(logo);
        
        /*imageView.setX(20);
        imageView.setY(-30);
        imageView.setScaleX(0.5);
        imageView.setScaleY(0.5);
        root.getChildren().add(imageView);*/
        //scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Gafata%22");
        
        scene.getStylesheets().add(getClass().getResource("UnoStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
    
}
