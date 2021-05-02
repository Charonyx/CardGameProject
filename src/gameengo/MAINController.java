package gameengo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MAINController implements Initializable {

    //private RectanglenowCardRect;
    @FXML
    private Button drawBtn;

    Random rand = new Random();

    int r1, nub = 0;

    int[] randDeck = new int[108];

    private Image[] imagecards = new Image[108];

//    private int[] card = new int[108];
    private final String[] nameImages = new String[108];
//    private final int[] temp = new int[108];
//    private int Maxnum = 108;
//    private final Random r = new Random();
//    private int ran2;

    private Image[] imageRand;

    private String[] playerName = {"p1"};
    private Game game;

    private UnoDeck deck = new UnoDeck();

    char[] picName = {'A', 'B', 'C', 'D', 'E'};

    @FXML
    private Rectangle card7;
    @FXML
    private Rectangle card6;
    @FXML
    private Rectangle card5;
    @FXML
    private Rectangle card4;
    @FXML
    private Rectangle card3;
    @FXML
    private Rectangle card2;
    @FXML
    private Rectangle card1;
    @FXML
    private Rectangle nowCardRect;

    ArrayList<Rectangle> playerHand;
    @FXML
    private HBox playerBox;
    @FXML
    private Rectangle selectRed;
    @FXML
    private Rectangle selectBlue;
    @FXML
    private Rectangle selectYellow;
    @FXML
    private Rectangle selectGreen;
    @FXML
    private AnchorPane selectWildScene;
    @FXML
    private Rectangle botCard;
    @FXML
    private Rectangle botCard2;
    @FXML
    private Rectangle botCard3;
    @FXML
    private Rectangle botCard4;
    @FXML
    private Rectangle botCard5;
    @FXML
    private Rectangle botCard6;
    @FXML
    private Rectangle botCard7;
    @FXML
    private AnchorPane state;

    private ArrayList<Rectangle> botRect = new ArrayList<Rectangle>();
    private Rectangle[] tempBotRect = {botCard, botCard2, botCard3, botCard4, botCard5, botCard6, botCard7};
    @FXML
    private HBox botHbox;
    @FXML
    private Button engoButton;
    @FXML
    private AnchorPane playOrSkipState;
    @FXML
    private Button skip;
    @FXML
    private Button playButton;
    @FXML
    private Rectangle instatntRect;

    @FXML
    private void engoButtonState(ActionEvent event) {
    }
    Bot bot;

    public enum Value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine,
        PlusTwo, Reverse, Skip, Wild, WildFour;

    }
    String[] forClone;
    UnoCard nowCardPlay;

    Image[] imageCardInit = new Image[7];
    ArrayList<String> name = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //nowCardRect.setFill(new ImagePattern(imageBlue1));
        //this.addTexture();
        bot = new Bot(botHbox, engoButton);
        name.add(playerName[0]);
        int n = 1;
        name.add(bot.randomBotName());
        botRect.add(botCard);
        botRect.add(botCard2);
        botRect.add(botCard3);
        botRect.add(botCard4);
        botRect.add(botCard5);
        botRect.add(botCard6);
        botRect.add(botCard7);

        playerName = new String[name.size()];
        for (String name : name) {
            playerName[this.name.indexOf(name)] = name;
        }
        game = new Game(playerName);
        bot.BotgetGame(game);
        //game.start(game);
//        for (int i = 0; i < game.getPlayerHandSize(playerName[0]); i--) {
        int i = 0;
        int k = 0;
        for (UnoCard card : game.getPlayerHand(playerName[0])) {
            //System.out.println("cardDeck[i]"+ game.getPlayerHand(playerName[0]).get(i).toString());
            for (UnoCard.Color card3 : game.getPlayerHand(playerName[0]).get(i).colors) {
                if (game.getPlayerHand(playerName[0]).get(i).getColor().equals(card.getColor(k++))) {
                    int j = 0;
                    char collectAlphabet = picName[k - 1];
                    for (UnoCard.Value card2 : game.getPlayerHand(playerName[0]).get(i).values) {

                        if (game.getPlayerHand(playerName[0]).get(i).getValue().equals(card.getValue(j++))) {
//                            System.out.println(game.getPlayerHand(playerName[0]).get(i).toString());
//                            System.out.println("/pics/" + card.getValueToInt(j - 1) + collectAlphabet + ".png");
                            imageCardInit[i] = new Image("/pics/" + card.getValueToInt(j - 1) + collectAlphabet + ".png");
                        }
                    }
                }
            }

            k = 0;
            i++;
        }
        bot.setBotCard(game.getPlayerHand(playerName[1]));
        bot.setBotRect(botRect);

        Rectangle[] startHand = {card1, card2, card3, card4, card5, card6, card7};
        playerHand = new ArrayList<Rectangle>(Arrays.asList(startHand));

        addImageToCard(imageCardInit);
        nowCardPlay = game.getDeck().drawCard();

        if (nowCardPlay.getColor().equals(UnoCard.Color.Wild) || nowCardPlay.getValue().equals(UnoCard.Value.Skip) || nowCardPlay.getValue().equals(UnoCard.Value.PlusTwo) || nowCardPlay.getValue().equals(UnoCard.Value.Reverse)) {
            int temp = 0;
            UnoCard tempCard = new UnoCard();
            for (UnoCard card : game.getDeck().getAllCardInDeck()) {
                if (!card.getColor().equals(UnoCard.Color.Wild)) {
                    tempCard = nowCardPlay;
                    nowCardPlay = card;
                    card = nowCardPlay;
                }
            }

        }

        game.addStockPile(nowCardPlay);

        int temp = 0;
        for (UnoCard.Color color : nowCardPlay.colors) {

            if (nowCardPlay.getColor().equals(nowCardPlay.colors[temp])) {
                nowCardRect.setFill(new ImagePattern(deck.drawCardImage(nowCardPlay, picName[temp])));
            }
            temp++;
        }
        i = 0;
        if (game.getCurrentPlayer().equals(playerName[1])) {
            try {
                bot.botPlay(game.getCurrentPlayer(), nowCardPlay, nowCardRect);
            } catch (Game.InvalidColorSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidValueSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

         for (Rectangle rect : playerHand) {
            
                 playerHand.get(playerHand.indexOf(rect)).setOnMouseClicked(new EventHandler<MouseEvent>(){
                     
                @Override
                public void handle(MouseEvent t) {
                try { 
                    
                if(game.getCurrentPlayer().equals(playerName[0])){
                     game.submitPlayerCard(playerName[0], nowCardPlay, game.getPlayerHand(playerName[0]).get(playerHand.indexOf(rect)),playerHand.get(playerHand.indexOf(rect)), nowCardRect, playerBox, playerHand);
                     if(nowCardPlay.getColor().equals(UnoCard.Color.Wild)){
                        selectWildScene.setVisible(true);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.Reverse)){
                        //game.changePlayer(!game.getGameDirection());
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.PlusTwo)){
                         System.out.println("Bot + 2");
                            //game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);  
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);  
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.WildFour)){
                         System.out.println("Bot + 4");
                            //game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);
                            game.submitDraw(playerName[1],bot.getCardRect(),game.getDeck().drawCard(), botHbox);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.Skip)){ 
                         game.changePlayer(game.getGameDirection());
                     }
                }
            System.out.println("Current player : " + game.getCurrentPlayer());
        if (game.getCurrentPlayer().equals(playerName[1])) {
            try {
                System.out.println("BOT card : " + bot.getCards().toString());
                bot.botPlay(game.getCurrentPlayer(), nowCardPlay, nowCardRect);
                     if(nowCardPlay.getValue().equals(UnoCard.Value.Reverse)){
                        game.changePlayer(!game.getGameDirection());
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.PlusTwo)){
                         game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.WildFour)){
                         game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.Skip)){ 
                         game.changePlayer(game.getGameDirection());
                         System.out.println("currentPlayer!!!! : " + game.getCurrentPlayer());
                     }

            } catch (Game.InvalidColorSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidValueSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    } catch (Game.InvalidColorSubmissionException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Game.InvalidValueSubmissionException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Game.InvalidPlayerTurnException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                });
            }
    }

    @FXML
    private void drawMethod(MouseEvent event) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!draw!!!!!!!!!!!!!!!!!!!");
        if (game.getCurrentPlayer().equals(playerName[0])) {
            r1 = rand.nextInt(2) + 1;
            UnoCard CardDraw;
            boolean isFilledImage = false;
            CardDraw = game.getDeck().drawCard();

        for (Rectangle rect : playerHand) {
                 playerHand.get(playerHand.indexOf(rect)).setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
            public void handle(MouseEvent t) {
            try { 
                    
                if(game.getCurrentPlayer().equals(playerName[0])){
                     game.submitPlayerCard(playerName[0], nowCardPlay, game.getPlayerHand(playerName[0]).get(playerHand.indexOf(rect)),playerHand.get(playerHand.indexOf(rect)), nowCardRect, playerBox, playerHand);
                     if(nowCardPlay.getColor().equals(UnoCard.Color.Wild)){
                        selectWildScene.setVisible(true);
                    }
                }
            System.out.println("now card left : " + playerHand.size());
            
                    } catch (Game.InvalidColorSubmissionException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Game.InvalidValueSubmissionException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Game.InvalidPlayerTurnException ex) {
                        Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
         }
        System.out.println("boolean[] : " + game.getCurrentPlayer().equals(playerName[1]));
        if (game.getCurrentPlayer().equals(playerName[1])) {
            try {
                System.out.println("BOT card : " + bot.getCards().toString());
                bot.botPlay(game.getCurrentPlayer(), nowCardPlay, nowCardRect);
                if(nowCardPlay.getValue().equals(UnoCard.Value.Reverse)){
                        //game.changePlayer(!game.getGameDirection());
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.PlusTwo)){
                         //game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.WildFour)){
                         //game.changePlayer(game.getGameDirection());
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                            game.submitDraw(playerName[0],playerHand,game.getDeck().drawCard(), playerBox);
                     }
                     if(nowCardPlay.getValue().equals(UnoCard.Value.Skip)){ 
                         //game.changePlayer(game.getGameDirection());
                         System.out.println("currentPlayer!!!! : " + game.getCurrentPlayer());
                     }
            } catch (Game.InvalidColorSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidValueSubmissionException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("Current player : " + game.getCurrentPlayer());
            if (nowCardPlay.getColor().equals(CardDraw.getColor()) || nowCardPlay.getValue().equals(CardDraw.getValue()) || CardDraw.getColor().equals(UnoCard.Color.Wild)) {
                playOrSkipState.setVisible(true);
                instatntRect.setFill(new ImagePattern(game.getImageInCardRect()));
            }
            else{
                game.submitDraw(playerName[0], playerHand, CardDraw, playerBox);
            }
                //game.changePlayer(game.getGameDirection());
        }
        //game.changePlayer(game.getGameDirection());
    }

    

    private void addImageToCard(Image[] image) {
        card1.setFill(new ImagePattern(image[0]));
        card2.setFill(new ImagePattern(image[1]));
        card3.setFill(new ImagePattern(image[2]));
        card4.setFill(new ImagePattern(image[3]));
        card5.setFill(new ImagePattern(image[4]));
        card6.setFill(new ImagePattern(image[5]));
        card7.setFill(new ImagePattern(image[6]));

        botCard.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard2.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard3.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard4.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard5.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard6.setFill(new ImagePattern(new Image("/pic/back.png")));
        botCard7.setFill(new ImagePattern(new Image("/pic/back.png")));
//        for(Rectangle rect : botRect){
//            rect.setFill(new ImagePattern(new Image("/pic/back.png")));
//        }
    }

    @FXML
    private void selectColor(MouseEvent event) {
        if (event.getSource() == selectRed) {
            nowCardPlay.setColor(UnoCard.Color.Red);
        } else if (event.getSource() == selectBlue) {
            nowCardPlay.setColor(UnoCard.Color.Blue);
        } else if (event.getSource() == selectYellow) {
            nowCardPlay.setColor(UnoCard.Color.Yellow);
        } else {
            nowCardPlay.setColor(UnoCard.Color.Green);
        }
        selectWildScene.setVisible(false);
    }

    @FXML
    private void skipButton(MouseEvent event) {
        if (event.getSource() == skip) {
            game.changePlayer(game.getGameDirection());
            playOrSkipState.setVisible(false);
            instatntRect.setFill(Color.TRANSPARENT);
        }
    }

    @FXML
    private void playButton(MouseEvent event) throws Game.InvalidColorSubmissionException, Game.InvalidValueSubmissionException {
        if (event.getSource() == playButton) {
            UnoCard tempCard = game.getPlayerHand(playerName[0]).get(game.getPlayerHandSize(playerName[0]) - 1);
            nowCardRect.setFill(new ImagePattern(game.getImageInCardRect()));
            try {
                game.submitPlayerCard(playerName[0], nowCardPlay, tempCard, nowCardRect, playerHand.get(playerHand.size() - 1), playerBox, playerHand);
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(MAINController.class.getName()).log(Level.SEVERE, null, ex);
            }
            instatntRect.setFill(Color.TRANSPARENT);
        }
        playOrSkipState.setVisible(false);
        playerHand.remove(playerHand.get(playerHand.size() - 1));
    }
}
