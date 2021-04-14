package uno;

import java.util.ArrayList;

/**
 * game
 */
public class Game {

    private int currentPlayer;
    private String[] playerID;

    private UnoDeck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    private ArrayList<UnoCard> stockPile;

    private UnoCard.Color nowColor;
    private UnoCard.Value nowValue;

    boolean gameDirect; // QAQ

    public Game(String[] pid) {
        deck = new UnoDeck();
        deck.shuffle();
        stockPile = new ArrayList<UnoCard>();

        playerID = pid;
        currentPlayer = 0;
        gameDirect = false;

        playerHand = new ArrayList<ArrayList<UnoCard>>();

        for (int i = 0; i < pid.length; i++) {
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(ArrayList.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }

    }

    public void start(Game game) {
        UnoCard card = deck.drawCard();
        nowColor = card.getColor();
        nowValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild) {
            start(game);
        }
        if (card.getValue == UnoCard.Value.WildFour || card.getValue == UnoCard.Value.PlusTwo) {
            start(game);
        }
        if (card.getValue == UnoCard.Value.Skip) {
             JLabel msgSkip = new JLabel(playerID[currentPlayer] + " was skipped!");
            // msgSkip.setfont(new Font("Tahoma", Font.BOLD, 48));
            // JOptionPane.showMessageDialog(null, msgSkip);

            if (gameDirect == false) {
                currentPlayer = (currentPlayer + 1) % playerID.length;
            }
            else if (gameDirect == true) {
                currentPlayer = (currentPlayer - 1) % playerID.length;
                if(currentPlayer == -1){
                    currentPlayer = playerID.length - 1;
                }
            }
        }
        if(card.getValue == UnoCard.Value.Reverse){
            // JLabel msgSkip = new JLabel(playerID[currentPlayer] + "The game direction changed!");
            // msgSkip.setfont(new Font("Tahoma", Font.BOLD, 48));
            // JOptionPane.showMessageDialog(null, msgSkip);
            gameDirect = true;
            currentPlayer = playerID.length - 1;
        }
    }
}