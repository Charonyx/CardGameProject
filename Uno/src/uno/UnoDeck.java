package uno;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * UnoDeck
 */
public class UnoDeck {

    private UnoCard[] cards;
    private int cardInDeck;

    public UnoDeck() {
        cards = new UnoCard[108];
    }

    public void reset() {
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardInDeck = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            UnoCard.Color color = colors[i];
            cards[cardInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
            for (int j = 1; j < 10; j++) {
                cards[cardInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
                cards[cardInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
            }
            UnoCard.Value[] values = new UnoCard.Value[] { UnoCard.Value.PlusTwo, UnoCard.Value.Reverse,
                    UnoCard.Value.Skip };
            for (UnoCard.Value value : values) {
                cards[cardInDeck++] = new UnoCard(color, value);
                cards[cardInDeck++] = new UnoCard(color, value);
            }
        }   
        UnoCard.Value[] values = new UnoCard.Value[] { UnoCard.Value.Wild, UnoCard.Value.WildFour };
        for (UnoCard.Value value : values) {
            for (int i = 0; i < 4; i++) {
                cards[cardInDeck++] = new UnoCard(UnoCard.Color.Wild, value);
            }
        }
    }

    // public void replaceDeck(ArrayList<UnoCard> cards) {
    //     this.cards = cards.toArray(new UnoCard(cards.size())); // ???
    // }

    public void replaceDeck(ArrayList<UnoCard> cards) {
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardInDeck = this.cards.length;
    }

    public boolean isEmpty() {
        return cardInDeck == 0;
    }

    public void shuffle() {
        int n = cards.length;
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randomValue = i + random.nextInt(n - i);
            UnoCard randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    // cards empty -> should edit it to play until can find some winner
    public UnoCard drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cann't draw a card since there are no cards in the deck");
        }
        return cards[--cardInDeck];
    }

    public ImageIcon drawCardImage() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't draw a card since the deck is empty");
        }
        return new ImageIcon(cards[--cardInDeck].toString() + ".png");
    }
    public UnoCard[] drawCard(int n){
        if(n<0){
            throw new IllegalArgumentException("Please draw positive cards but tried to draw "+ n +" cards.");
        }
        if(n>cardInDeck){
            throw new IllegalArgumentException("Can't draw"+n+" cards since there are only "+cardInDeck+" cards");
        }
        UnoCard[] num = new UnoCard[n];
        for (int i = 0; i < n; i++) {
            num[i] = cards[--cardInDeck];
        }
        return num;
    }
}