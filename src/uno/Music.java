/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.File;
import javafx.event.Event;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author chura
 */
public class Music {

    public static double musicVolumn = 50;

    // ------------ MUSIC BACKGROUND -------------
    public static MediaPlayer mediaMenu;
    public static MediaPlayer mediaHowto;
    public static MediaPlayer mediaDirect;
    public static MediaPlayer mediaRank;
    public static MediaPlayer mediaGame;

    public static String musicMenu = "../Uno/src/sound/menu.mp3";
    public static String musicHowto = "../Uno/src/sound/howto.mp3";
    public static String musicDirect = "../Uno/src/sound/direct.mp3";
    public static String musicRank = "../Uno/src/sound/direct.mp3";
    public static String musicGame = "../Uno/src/sound/menu.mp3";

    // ------------ SOUND EFFECT -----------------
    public static MediaPlayer soundClick;
    public static MediaPlayer soundType;
    public static MediaPlayer soundWin;
    public static MediaPlayer soundGameover;

    public static String sourceClick = "../Uno/src/sound/click.wav";
    public static String sourceType = "../Uno/src/sound/type.wav";
    public static String sourceWin = "../Uno/src/sound/win2.wav";
    public static String sourceGameover = "../Uno/src/sound/gameover.wav";

//    public static 
//            if(Event.getSource () 
//        == Button){
//                    
//        Media sound2 = new Media(new File(sourceClick).toURI().toString());
//        soundClick = new MediaPlayer(sound2);
//        soundClick.play();
//    }
    public static void playSoundEffect(String f, MediaPlayer m) {
        Media sound2 = new Media(new File(f).toURI().toString());
        m = new MediaPlayer(sound2);
        m.play();
    }

    public static void playMusicBG(String f, MediaPlayer m) {
        Media sound = new Media(new File(f).toURI().toString());
        m = new MediaPlayer(sound);
        m.setOnEndOfMedia(new Runnable() {
            public void run() {
//                m.seek(Duration.ZERO);
            }
        });
    }
}
