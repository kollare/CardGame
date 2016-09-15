/**************************************************************************************************************
 * @author: Edward Kollar
 * @date: 2016/09/01
 * @description: Draw from a deck of 52 cards until one card of each suit is drawn. Print out the drawn cards!
 *************************************************************************************************************/
public class Card {
    private Deck.Suit cardSuit;
    private Deck.Face cardFace;

    public Card(Deck.Suit cardSuit, Deck.Face cardFace) {
        this.cardSuit = cardSuit;
        this.cardFace = cardFace;
    }

    public Deck.Suit getCardSuit() {
        return cardSuit;
    }

    public Deck.Face getCardFace() {
        return cardFace;
    }
}

