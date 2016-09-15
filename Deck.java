import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**************************************************************************************************************
 * @author: Edward Kollar
 * @date: 2016/09/01
 * @description: Draw from a deck of 52 cards until one card of each suit is drawn. Print out the drawn cards!
 *************************************************************************************************************/
public class Deck {

    private ArrayList<Card> newDeck;
    private ArrayList<Card> userHand;
    private int numTurns;

    public enum Suit {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

    public enum Face {
        TWO ("2"),
        THREE ("3"),
        FOUR ("4"),
        FIVE ("5"),
        SIX ("6"),
        SEVEN ("7"),
        EIGHT ("8"),
        NINE ("9"),
        TEN ("10"),
        JACK ("JACK"),
        QUEEN ("QUEEN"),
        KING ("KING"),
        ACE ("ACE");

        /**A variable to hold the strings proper display name*/
        private final String name;

        //A constructor that turns my enums into proper strings.
        Face(String s) {
            name = s;
        }

        //Returns string value
        public String toString() {
            return this.name;
        }
    }

    public Deck(){
        newDeck = new ArrayList<Card>();
        userHand = new ArrayList<Card>();
        numTurns = 0;
    }

    public void makeDeck(){
        //A for each loop that creates the deck
        for (Suit s : Suit.values()) {
            for (Face r : Face.values()) {
                Card c = new Card(s, r);
                newDeck.add(c);
            }
        }
        //A method in collections that randomly sorts my arraylist.
        Collections.shuffle(newDeck);
    }

    public ArrayList<Card> getNewDeck() {
        return newDeck;
    }

    public ArrayList<Card> getUserHand() {
        return userHand;
    }

    public int getNumTurns(){ return numTurns; }

    public void printCardFromDeck(int i){
        System.out.println(this.newDeck.get(i).getCardFace() + " of " +
                this.newDeck.get(i).getCardSuit());
    }

    public void printHand(){
        for (int i = 0; i < userHand.size(); i++) {
            System.out.println(this.userHand.get(i).getCardFace() + " of " +
                    this.userHand.get(i).getCardSuit());
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.newDeck);
    }

    public void draw(int i){
        this.userHand.add(this.newDeck.get(i));
        this.newDeck.remove(i);
    }

    public void playGame(){
        int i = 0;
        this.numTurns = 1;
        while(userHand.size()<4) {
            boolean newSuit=true;
            Card temp = newDeck.get(0);
            for(Card c : userHand) {
                if(c.getCardSuit() == temp.getCardSuit()) {
                    newSuit=false;
                }
            }
            if(newSuit) {
                userHand.add(temp);
            }
            shuffleDeck();
            this.numTurns++;
        }
    }

    public boolean canDraw(){
        boolean weDraw = false;
        for(Card c1 : this.userHand) {
            if (c1.getCardSuit() == this.newDeck.get(0).getCardSuit()) {
                weDraw = false;
            } else {
                weDraw = true;
            }
        }
        return weDraw;
    }

    public void runSim(){
        makeDeck();
        playGame();
        printHand();
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        System.out.println("Drawn Cards:");
        myDeck.makeDeck();
        //myDeck.playGame();
        myDeck.runSim();
        //myDeck.printHand();
        System.out.println("Number of turns: " + myDeck.getNumTurns());
    }

}

