/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package CardGame;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Megha Patel
 * @author Che-Wei Liu
 * @year 2021
 */
public class Card {
    // default modifier for child classes

    char[] cardSuit = { 'C', 'D', 'H', 'S' };
    private char suit;
    private int value;

    public Card() {
        suit = ' ';
        value = 0;

    }

    public Card(char nSuit, int nValue) {
        if (!(nValue > 13 || nValue < 1)) {
            this.value = nValue;
        }
        if ((nSuit == 'H' || nSuit == 'S' || nSuit == 'D' || nSuit == 'C')) {
            this.suit = nSuit;
        }
    }

    public String getSuitName() {
        switch (this.suit) {
        case 'H':
            return "Hearts";
        case 'S':
            return "Spades";
        case 'C':
            return "Club";
        case 'D':
            return "Diamond";
        default:
            return "unknown";
        }
    }

    public char getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String getValueName() {
        switch (this.value) {
        case (1):
            return "Ace";

        case (2):
            return "Two";

        case (3):
            return "Three";

        case (4):
            return "Four";

        case (5):
            return "Five";

        case (6):
            return "Six";

        case (7):
            return "Seven";

        case (8):
            return "Eight";

        case (9):

            return "Nine";

        case (10):

            return "Ten";

        case (11):

            return "Jack";

        case (12):

            return "Queen";

        case (13):

            return "King";

        default:
            return "unknown";

        }
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular
     *         playing card etc.
     */
    @Override
    public String toString() {
        return getSuitName() + " " + getValue();
    };

    
}
