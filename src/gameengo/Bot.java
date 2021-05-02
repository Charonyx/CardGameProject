/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author USER
 */
public class Bot {

    private String[] botName = {"Grace", "Farsai", "Onn", "Rom", "Cherry", "Micheal", "Justin", "Taylor"};
    private String botAsplayerName;
    private int queue;
    private ArrayList<UnoCard> cards;
    boolean isCanPlay = true;
    boolean hasCard = true;
    private ArrayList<Rectangle> cardRect;
    HBox botHBox;
    Game game;
    Button engoButton;
    
    public Bot(HBox botHBox,Button engoButton) {
        
        this.botHBox = botHBox;
        this.engoButton = engoButton;
    }
    
    public void BotgetGame(Game game){
        this.game = game;
    }
    public void setBotCard(ArrayList<UnoCard> card){
        this.cards = card;
    }
    
    public void setBotRect(ArrayList<Rectangle> rect){
        this.cardRect = rect;
    }
    public void botPlay(String currentPlayerName, UnoCard nowCard, Rectangle nowCardRect) 
            throws Game.InvalidColorSubmissionException, Game.InvalidValueSubmissionException, Game.InvalidPlayerTurnException {
        if (currentPlayerName.equals(botAsplayerName)) {
            isCanPlay = true;
            hasCard = true;
            System.out.println("HI! I'm bot");
            if (isCanPlay) {
                for (UnoCard card : cards) {
                    if ((nowCard.getColor().equals(card.getColor()) || nowCard.getValue().equals(card.getValue()) || card.getColor().equals(UnoCard.Color.Wild))) {
                        game.submitPlayerCard(botAsplayerName, nowCard, card,cardRect.get(cards.indexOf(card)), nowCardRect, botHBox, cardRect);
                        if(card.getColor().equals(UnoCard.Color.Wild)){
                            Random random = new Random();
                                int randomColor = random.nextInt(card.colors.length );
                                nowCard.setColor(card.colors[randomColor]);
                        }
                        isCanPlay = false;
                    }

                }
                hasCard = false;
                if (!hasCard) {
                    this.game.submitDraw(botAsplayerName,cardRect, nowCard, botHBox);
                    isCanPlay = false;
                }
            }
            if(game.getPlayerHandSize(botAsplayerName) == 1){
             game.setIsPressedEngoButton(true);
            }
            if(game.getPlayerHandSize(botAsplayerName)> 1 ){
                game.setIsPressedEngoButton(false);
            }

        }

    }

    public String randomBotName() {
        Random random = new Random();

        for (int i = 0; i < 1; i++) {
            int randomValue = i + random.nextInt(botName.length - i);
            botAsplayerName = botName[randomValue];
        }
        return botAsplayerName;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public ArrayList<UnoCard> getCards() {
        return this.cards;
    }

    public ArrayList<Rectangle> getCardRect() {
        return cardRect;
    }

    public void setCardRect(ArrayList<Rectangle> cardRect) {
        this.cardRect = cardRect;
    }
}
