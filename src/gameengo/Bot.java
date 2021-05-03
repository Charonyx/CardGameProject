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

    private String[] botName = {"Grace", "Farsai", "Onn", "Rom", "Cherry", "Micheal", "Justin", "Taylor", "Pupz" , "Pupae"};
    private String botAsplayerName;
    private int queue;
    private ArrayList<UnoCard> cards;
    boolean isCanPlay = true;
    boolean hasCard = true;
    private ArrayList<Rectangle> cardRect;
    HBox botHBox;
    Game game;
    Button engoButton;
    public Bot(HBox botHBox, Button engoButton) {

        this.botHBox = botHBox;
        this.engoButton = engoButton;
    }

    public void BotgetGame(Game game) {
        this.game = game;
    }

    public void setBotCard(ArrayList<UnoCard> card) {
        this.cards = card;
    }

    public void setBotRect(ArrayList<Rectangle> rect) {
        this.cardRect = rect;
    }

    public void botPlay(String currentPlayerName, UnoCard nowCard, Rectangle nowCardRect,boolean isCanPlay)
            throws Game.InvalidColorSubmissionException, Game.InvalidValueSubmissionException, Game.InvalidPlayerTurnException {
        if (currentPlayerName.equals(botAsplayerName)) {
            this.isCanPlay = isCanPlay;
            hasCard = true;
            ArrayList<UnoCard> getCardCanPlay = new ArrayList<UnoCard>();
            System.out.println("bot hand : " + cards.size());
            if (this.isCanPlay) {
                for (UnoCard card : cards) {
                    if ((nowCard.getColor().equals(card.getColor()) || nowCard.getValue().equals(card.getValue()) || card.getColor().equals(UnoCard.Color.Wild))) {
                        getCardCanPlay.add(card);
                    }
                }

                if (getCardCanPlay.size() == 0) {
                    System.out.println("No card can play");
                    this.game.submitDraw(botAsplayerName, cardRect, nowCard, botHBox);
                    if(cards.get(cards.size()-1).getColor().equals(nowCard.getColor())||cards.get(cards.size()-1).getColor().equals(UnoCard.Color.Wild)||cards.get(cards.size()-1).getValue().equals(nowCard.getValue())){
                        game.submitPlayerCard(botAsplayerName, nowCard,cards.get(cards.size()-1), cardRect.get(cards.size()-1), nowCardRect, botHBox, cardRect); 
                        System.out.println("--------------- 1 --------------------");
                    }
                    else{
                        game.changePlayer(game.getGameDirection());
                    }
                    //isCanPlay = false;
                } else {
                    Random random = new Random();
                    int index = random.nextInt(getCardCanPlay.size());
                    cards.remove(getCardCanPlay.get(index));
                    game.submitPlayerCard(botAsplayerName, nowCard, getCardCanPlay.get(index), cardRect.get(index), nowCardRect, botHBox, cardRect);
                    System.out.println("Bot play : " + getCardCanPlay.get(index).toString());
                }
            }
            if (game.getPlayerHandSize(botAsplayerName) == 1) {
                game.isPressEngo(true);
            }
            if (game.getPlayerHandSize(botAsplayerName) > 1) {
                game.isPressEngo(false);
            }
            //this.isCanPlay = false;
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

}
