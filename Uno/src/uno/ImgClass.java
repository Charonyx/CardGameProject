/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import javax.swing.text.html.ImageView;

/**
 *
 * @author chura
 */
public class ImgClass {

    // data fields
    public static ImageView[][] imgCards;

    // constructor
    public ImgClass() {

    }

    public ImgClass(javafx.scene.image.ImageView[][] imgArraysMethod) {
        this.imgCards = imgCards;
    }

    // getter
    public static ImageView[][] getImgCards() {
        return imgCards;
    }

    // setter
    public static void setImgCards(ImageView[][] imgCards) {
        ImgClass.imgCards = imgCards;
    }

}
