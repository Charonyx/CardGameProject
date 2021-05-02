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

    public static boolean accessLoader = true;

    // ------------ SET VOLUMN -------------------
    public static double musicVolumn = 15;
    public static double clickVolumn = 25;
    public static double errorVolumn = 30;
    public static double winVolumn = 25;
    public static double gameoverVolumn = 25;
    public static double hoverVolumn = 20;
    
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
    public static MediaPlayer soundError;
    public static MediaPlayer soundWin;
    public static MediaPlayer soundGameover;
    public static MediaPlayer soundHover;

    public static MediaPlayer soundCardWild;
    public static MediaPlayer soundCardStop;
    public static MediaPlayer soundCardReverse;
    public static MediaPlayer soundEngo;

    public static String sourceClick = "../Uno/src/sound/click.wav";
    public static String sourceType = "../Uno/src/sound/type.wav";
    public static String sourceError = "../Uno/src/sound/error.mp3";
    public static String sourceWin = "../Uno/src/sound/winReward.wav";
    public static String sourceGameover = "../Uno/src/sound/gameover.wav";
    public static String sourceHover = "../Uno/src/sound/error.mp3";
    
    public static String sourceCardWild = "../Uno/src/sound/cardWild.wav";
    public static String sourceCardStop = "../Uno/src/sound/cardStop.wav";
    public static String sourceCardReverse = "../Uno/src/sound/cardReverse.wav";
    public static String sourceEngo = "../Uno/src/sound/turnon.wav";

//    public static 
//            if(Event.getSource () 
//        == Button){
//                    
//        Media sound2 = new Media(new File(sourceClick).toURI().toString());
//        soundClick = new MediaPlayer(sound2);
//        soundClick.play();
//    }
    public static void playSoundClick() {
        Media sound2 = new Media(new File(sourceClick).toURI().toString());
        soundClick = new MediaPlayer(sound2);
        soundClick.setVolume(clickVolumn);
        soundClick.play();
    }

    public static void playSoundHover() {
        playSoundEffect(sourceHover, soundHover);
        soundHover.setVolume(hoverVolumn);
    }

    public static void playSoundError() {
        Media sound2 = new Media(new File(sourceError).toURI().toString());
        soundError = new MediaPlayer(sound2);
        soundError.setVolume(errorVolumn);
        soundError.play();
    }

    public static void playSoundWin() {
        playSoundEffect(sourceWin, soundWin);
        soundWin.setVolume(winVolumn);
    }

    public static void playSoundGameover() {
        playSoundEffect(sourceGameover, soundGameover);
        soundGameover.setVolume(gameoverVolumn);
    }

    // -------------------SOUND CARD ---------------------------
    public static void playSoundCardWild() {
        playSoundEffect(sourceCardWild, soundCardWild);
    }

    public static void playsoundLoader() {
        Media sound = new Media(new File(sourceCardWild).toURI().toString());
        soundCardWild = new MediaPlayer(sound);
        soundCardWild.setOnEndOfMedia(new Runnable() {
            public void run() {
                soundCardWild.seek(Duration.ZERO);
            }
        });
        soundCardWild.play();
    }

    // ---------------- CODE PATTERN -------------------
    public static void playSoundEffect(String f, MediaPlayer m) {
        Media sound2 = new Media(new File(f).toURI().toString());
        m = new MediaPlayer(sound2);
        m.play();
    }
    /*
    public static void playMusicBG(String f, MediaPlayer m) {
        Media sound = new Media(new File(f).toURI().toString());
        m = new MediaPlayer(sound);
        m.setOnEndOfMedia(new Runnable() {
            public void run() {
//                m.seek(Duration.ZERO);
            }
        });
        m.play();
    }
     */
}
