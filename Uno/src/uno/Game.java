/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author USER
 */
public class Game {
    
    private int currentPlayer;
    private boolean nowPlayer;
    private String[] playerID;
    
    private UnoDeck deck;
    private ArrayList<Rectangle> BotRect;
    private HBox playerBox;
    private AnchorPane pane;
    
    public UnoDeck getDeck() {
        return deck;
    }
    private ArrayList<ArrayList<UnoCard>> playerHand;
    private ArrayList<UnoCard> stockPile;
    
    private UnoCard.Color nowColor;
    private UnoCard.Value nowValue;
    private UnoCard topCard;
    private boolean gameDirection;
    private Image imageInCardRect;
    Bot bot;
    HBox botHBox;
    char[] picName = {'A', 'B', 'C', 'D', 'E'};
    private ArrayList<ArrayList<Rectangle>> playerRect;
    
    public ArrayList<Rectangle> getPlayerRect(String pid) {
        int index = Arrays.asList(playerID).indexOf(pid);
        return playerRect.get(index);
    }
    private boolean isPressedEngoButton = false;
//    private ArrayList<Rectangle> botRect;
    private boolean canPlay = false;
    private Button engoButton;
    private ArrayList<String> Name;
    
    public void setBotRect(ArrayList<Rectangle> botRect) {
        this.BotRect = botRect;
        bot.setBotRect(botRect);
    }
    
    public Game(ArrayList<String> Name, HBox botHBox, Button engoButton) { // initialgame
        this.bot = new Bot(botHBox, engoButton);
        
        String tempName = bot.randomBotName();
        
        this.Name = Name;
        this.Name.add(tempName);
        this.botHBox = botHBox;
        deck = new UnoDeck(); // creat 108 cards 
        deck.reset();
        deck.shuffle();
        stockPile = new ArrayList<UnoCard>();
        
        playerID = new String[this.Name.size()];
        int i = 0;
        for (String name : this.Name) {
            playerID[i] = this.Name.get(i);
            i++;
            this.bot.BotgetGame(this);
        }
        currentPlayer = 0;
        gameDirection = true;
        
        playerHand = new ArrayList<ArrayList<UnoCard>>();
        
        for (i = 0; i < this.Name.size(); i++) {
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
        bot.setBotCard(this.getPlayerHand(playerID[1]));
        bot.setBotRect(BotRect);
        System.out.println("member : " + playerID[0] + playerID[1]);
    }
    
    public void start(Game game) {//
    }
    
    public UnoCard getTopCard() {
        return new UnoCard(nowColor, nowValue);
    }
    
    public boolean isGameOver() {
        for (String player : this.playerID) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }
    
    public String getCurrentPlayer() {
        return this.playerID[this.currentPlayer];
    }

//    public String getPreviousPlayer(int i) {
//        int index = this.currentPlayer - i;
//        if (index == -1) {
//            index = playerID.length - i;
//        }
//        return this.playerID[index];
//    }
    public String[] getPlayerID() {
        return playerID;
    }
    
    public ArrayList<UnoCard> getPlayerHand(String pid) {
        int index = Arrays.asList(playerID).indexOf(pid);
        return playerHand.get(index);
    }
    
    public int getPlayerHandSize(String player) {
        return getPlayerHand(player).size();
    }
    
    public UnoCard getPlayerCard(String player, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(player);
        return hand.get(choice);
    }
    
    public boolean hasEmptyHand(String pid) {
        return getPlayerHand(pid).isEmpty();
    }
    
    public boolean nowCardPlay(UnoCard card) {
        return card.getColor() == nowColor || card.getValue() == nowValue;
    }

    // part 5
    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if (this.playerID[this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("It isn't " + pid + " 's turn", pid);
        }
    }
    
    public void submitDraw(String playerName, ArrayList<Rectangle> rect, UnoCard drawCard, HBox hbox) {
        //checkPlayerTurn(pid);
        int temp = getPlayerHand(playerName).size();
        if (deck.isEmpty()) {
            deck.replaceDeck(stockPile);
            deck.shuffle();
        }
        
        Rectangle newCardRect = new Rectangle();
        newCardRect.setId("card" + (108 - getDeck().getCardInDeck()));
        
        rect.add(newCardRect);
        getPlayerHand(playerName).add(drawCard);
        System.out.println("carddrown value : " + getPlayerHand(playerName).get(temp).toString());
        
        newCardRect.setFill(Color.AQUA);
        newCardRect.setWidth(100.0f);
        newCardRect.setHeight(140.0f);
        
        int count = 0;
        System.out.println("current player : " + getCurrentPlayer());
        if (playerName != playerID[1]) {
            System.out.println("draw1 !!!");
            
            for (UnoCard.Color color : drawCard.colors) {
                if (drawCard.getColor().equals(drawCard.colors[count])) {
//                    System.out.println("/pics/" + drawCard.getValueToInt() + picName[count] + ".png");
                    newCardRect.setFill(new ImagePattern(deck.drawCardImage(drawCard, picName[count])));
                    this.imageInCardRect = deck.drawCardImage(drawCard, picName[count]);
                }
                count++;
            }
            
        } else {
            newCardRect.setFill(new ImagePattern(new Image("/pic/back.png")));
            newCardRect.setRotate(180.0);
        }
        
        newCardRect.setStroke(Color.BLACK);
        
        hbox.getChildren().add(newCardRect);
        HBox.setMargin(newCardRect,
                new Insets(0, 0, 0, -50));
    }
    
    public void setCardColor(UnoCard.Color color) {
        nowColor = color;
    }
    
    public void submitPlayerCard(String pid, UnoCard nowCard, UnoCard playerCard, Rectangle cardRect,
            Rectangle nowCardRect, HBox playerBox, ArrayList<Rectangle> playerHand)
            throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
        System.out.println("PLayer hand : " + this.getPlayerHandSize(playerID[0]));
        if (this.getCurrentPlayer().equals(pid)) {
            System.out.println("" + this.getCurrentPlayer());
            System.out.println("====================== before ==================================");
            System.out.println("turn : " + this.getCurrentPlayer());
            System.out.println("playercard : " + playerCard.toString());
            System.out.println("nowcard : " + nowCard.toString());
            
            ArrayList<UnoCard> pHand = getPlayerHand(pid);
            
            this.nowColor = nowCard.getColor();
            this.nowValue = nowCard.getValue();
            if (playerCard.getColor().equals(nowCard.getColor()) || playerCard.getValue().equals(nowCard.getValue()) || playerCard.getColor().equals(UnoCard.Color.Wild)) {
                
                stockPile.add(playerCard);
                pHand.remove(playerCard);
                playerHand.remove(cardRect);
                
                nowCard.setColor(playerCard.getColor());
                nowCard.setValue(playerCard.getValue());
                
                if (this.getCurrentPlayer().equals(playerID[1])) {
                    int count = 0;
                    for (UnoCard.Color color : playerCard.colors) {
                        if (playerCard.getColor().equals(playerCard.colors[count])) {
                            nowCardRect.setFill(new ImagePattern(deck.drawCardImage(playerCard, picName[count])));
                        }
                        count++;
                        if (playerCard.getColor().equals(UnoCard.Color.Wild)) {
                            Random random = new Random();
                            int randomColor = random.nextInt(UnoCard.Color.values().length - 1);
                            nowCard.setColor(playerCard.colors[randomColor]);
                        }
                    }
                } else {
                    nowCardRect.setFill(cardRect.getFill());
                }
                
                playerBox.getChildren().remove(cardRect);
                
                System.out.println("====================== after ==================================");
                for (UnoCard card : getPlayerHand(pid)) {
                    System.out.println(card.toString());
                }
                for (Rectangle card : playerHand) {
                    System.out.println(card.toString());
                }
            }
            
            if (hasEmptyHand(this.playerID[currentPlayer])) {
                // winner pop up
            }
            //this.changePlayer(!this.getGameDirection());
            System.out.println("boolean : " + this.getCurrentPlayer().equals(playerID[1]));
            if (pid == playerID[1]) { // bot
                if (nowCard.getValue().equals(UnoCard.Value.Reverse)) {
                    this.changePlayer(!this.getGameDirection());
                    this.canPlay = true;
                    bot.botPlay(playerID[1], nowCard, nowCardRect, this.canPlay);
                }
                if (nowCard.getValue().equals(UnoCard.Value.PlusTwo)) {
                    this.changePlayer(this.getGameDirection());
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.canPlay = true;
                    bot.botPlay(playerID[1], nowCard, nowCardRect, this.canPlay);
                }
                if (nowCard.getColor().equals(UnoCard.Color.Wild)) {
                    Random random = new Random();
                    int RandColor = random.nextInt(UnoCard.Color.values().length - 1);
                    nowColor = nowCard.colors[RandColor];
                    this.changePlayer(this.getGameDirection());
                }
                if (nowCard.getValue().equals(UnoCard.Value.WildFour)) {
                    this.changePlayer(this.getGameDirection());
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.submitDraw(playerID[0], playerHand, this.getDeck().drawCard(), this.playerBox);
                    this.canPlay = true;
                    this.changePlayer(this.getGameDirection());
                    bot.botPlay(playerID[1], nowCard, nowCardRect, this.canPlay);
                }
                if (nowCard.getValue().equals(UnoCard.Value.Skip)) {
                    this.changePlayer(this.getGameDirection());
                    this.canPlay = true;
                    bot.botPlay(playerID[1], nowCard, nowCardRect, this.canPlay);
                    
                    System.out.println("currentPlayer!!!! : " + this.getCurrentPlayer());
                }
                canPlay = false;
                //this.changePlayer(this.gameDirection);
            } else {
                this.canPlay = true;
                if (nowCard.getColor().equals(UnoCard.Color.Wild)&& nowCard.getValue().equals(UnoCard.Value.Wild)) {
                    this.pane.setVisible(true);
                    this.canPlay = true;
                }
                if (nowCard.getValue().equals(UnoCard.Value.Reverse)) {
                    this.changePlayer(!this.getGameDirection());
                }
                if (nowCard.getValue().equals(UnoCard.Value.PlusTwo)) {
                    
                    this.changePlayer(this.getGameDirection());
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.canPlay = false;
                }
                if (nowCard.getValue().equals(UnoCard.Value.WildFour) && nowCard.getColor().equals(UnoCard.Color.Wild)) {
                    
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.submitDraw(playerID[1], BotRect, this.getDeck().drawCard(), botHBox);
                    this.canPlay = false;
                    this.changePlayer(this.getGameDirection());
                }
                if (nowCard.getValue().equals(UnoCard.Value.Skip)) {
                    this.changePlayer(this.getGameDirection());
                    this.canPlay = false;
                    System.out.println("currentPlayer!!!! : " + this.getCurrentPlayer());
                }
                
                System.out.println("isCanPlay : " + this.isCanPlay());
                bot.botPlay(playerID[1], nowCard, nowCardRect, this.canPlay);
            }
            
            if (isPressedEngoButton == false && getPlayerHandSize(pid) == 1) {
                this.submitDraw(pid, playerHand, this.getDeck().drawCard(), playerBox);
                this.submitDraw(pid, playerHand, this.getDeck().drawCard(), playerBox);
            }
//            if (playerCard.getValue().equals(UnoCard.Value.PlusTwo)) {
//                if (pid.equals(playerID[0])) {
//                    this.submitDraw(playerID[1], botRect, this.getDeck().drawCard(),botBox );
//                    getPlayerHand(playerID[1]).add(deck.drawCard());
//                } else {
//                    this.submitDraw(playerID[1], botRect, this.getDeck().drawCard(),playerBox);
//                    getPlayerHand(playerID[1]).add(deck.drawCard());
//                }
//            }
//            if (playerCard.getValue().equals(UnoCard.Value.WildFour)) {
//                get
//            }

        }

////        nowColor = nowCard.getColor();
////        nowValue = nowCard.getValue();
//        stockPile.add(nowCard);
//
////        if (gameDirection == false) {
////            currentPlayer = (currentPlayer + 1) % playerID.length;
////        } else if (gameDirection == true) {
////            currentPlayer = (currentPlayer - 1) % playerID.length;
////            if (currentPlayer == -1) {
////                currentPlayer = playerID.length - 1;
////            }
////        }
//        if (nowCard.getColor() == UnoCard.Color.Wild) {
//            nowColor = playerCard.getColor();// !!!!
//        }
//        if (nowCard.getValue() == UnoCard.Value.PlusTwo) {
//            pid = playerID[currentPlayer];
//            for (int i = 0; i < 2; i++) {
//                getPlayerHand(pid).add(deck.drawCard());
//            }
////            JLabel msgPlusTwo = new JLabel(pid + " draw 2 cards!");
//        }
//
//        if (nowCard.getValue() == UnoCard.Value.WildFour) {
//            pid = playerID[currentPlayer];
//            for (int i = 0; i < 4; i++) {
//                getPlayerHand(pid).add(deck.drawCard());
//            }
////            JLabel msgPlusTwo = new JLabel(pid + " draw 4 cards!");
//        }
//
//        if (nowCard.getValue() == UnoCard.Value.Skip) {
////            JLabel msgSkip = new JLabel(playerID[currentPlayer] + " was Skipped!");
////            msgSkip.setFont(new Font("Tahoma", Font.BOLD, 48));
////            JOptionPane.showMessageDialog(null, msgSkip);
//            
//            if (gameDirection == false) {
//                currentPlayer = (currentPlayer + 1) % playerID.length;
//            } else if (gameDirection == true) {
//                currentPlayer = (currentPlayer - 1) % playerID.length;
//                if (currentPlayer == -1) {
//                    currentPlayer = playerID.length - 1;
//                }
//            }
//        }
//
//        if (nowCard.getValue() == UnoCard.Value.Reverse) {
////            JLabel msgRe = new JLabel(pid + " changed the game direction!");
////            msgRe.setFont(new Font("Tahoma", Font.BOLD, 48));
////            JOptionPane.showMessageDialog(null, msgRe);
//
        System.out.println("PLayer hand : " + this.getPlayerHandSize(playerID[0]));
    }
    
    class InvalidPlayerTurnException extends Exception {
        
        String playerID;
        Label warningMsg;
        
        public InvalidPlayerTurnException(String msg, String pid) {
            super(msg);
            playerID = pid;
        }
        
        public String getPlayerID() {
            return playerID;
        }
        
        public void setPlayerID(String playerID) {
            this.playerID = playerID;
        }
        
    }
    
    class InvalidColorSubmissionException extends Exception {
        
        private UnoCard.Color expected;
        private UnoCard.Color actual;
        
        public InvalidColorSubmissionException(String msg, UnoCard.Color actual, UnoCard.Color expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }
    
    class InvalidValueSubmissionException extends Exception {
        
        private UnoCard.Value expected;
        private UnoCard.Value actual;
        
        public InvalidValueSubmissionException(String msg, UnoCard.Value actual, UnoCard.Value expected) {
            this.actual = actual;
            this.expected = expected;
        }
        
    }
    
    public boolean getGameDirection() {
        return this.gameDirection;
    }
    
    public void setTopCard(UnoCard topCard) {
        
    }
    
    public ImagePattern getTopCardPic(Rectangle topCard) {
        return (ImagePattern) topCard.getFill();
    }

//playerBox
    public void addStockPile(UnoCard card) {
        stockPile.add(card);
    }
    
    public int getCurrentPlayerTurn() {
        return currentPlayer;
    }
    
    public void changePlayer(boolean gameDirection) {
        this.gameDirection = gameDirection;
        if (gameDirection == true) {
            currentPlayer = currentPlayer - 1;
            if (currentPlayer < 0) {
                currentPlayer = playerID.length - 1;
            }
        } else {
            currentPlayer = (currentPlayer + 1) % playerID.length;
        }
        System.out.println("current player : " + currentPlayer);
        
    }
    
    public Image getImageInCardRect() {
        return imageInCardRect;
    }
    
    public boolean isCanPlay() {
        return canPlay;
    }
    
    public ArrayList<Rectangle> botRect() {
        return bot.getCardRect();
    }
    
    public HBox botHBox() {
        return this.botHBox;
    }
    
    public void botPlay(UnoCard nowCard, Rectangle nowCardRect) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
        bot.botPlay(playerID[1], nowCard, nowCardRect, true);
    }
    
    public String getPlayerID(int i) {
        return this.playerID[i];
    }
    
    public void setPlayerBox(HBox playerBox) {
        this.playerBox = playerBox;
    }
    
    public void isPressEngo(boolean state) {
        this.isPressedEngoButton = state;
    }
    
    public void setSelectWild(AnchorPane pane) {
        this.pane = pane;
    }
    
    public boolean getPressEngo() {
        return this.isPressedEngoButton;
    }
//    public void setBotRect(ArrayList<Rectangle> botRect) {
//        this.botRect = botRect;
//    }
//
//    public ArrayList<Rectangle> getBotRect() {
//        return this.botRect;
//    }
//    public HBox getBotBox(){
//        return this.botBox;
//    }
//    
//    public void setHbox(HBox botBox){
//        this.botBox = botBox;
//    }
}
