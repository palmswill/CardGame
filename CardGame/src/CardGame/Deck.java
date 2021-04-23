package CardGame;



public class Deck extends GroupOfCards{


    /**
     * put card into the current deck used in the game according to how many
     * standard 52-card poker deck used, then shuffle the deck
     * 
     * @param numberofDecks number of standard poker deck setinto the current game
     *                      deck
     */
    Deck(int numberofDecks) {
        char[] cardSuit = { 'C', 'D', 'H', 'S' };

        for (int deckOrder = 0; deckOrder < numberofDecks; deckOrder++) {
            for (int suitOrder = 0; suitOrder < cardSuit.length; suitOrder++) {
                for (int numberOrder = 1; numberOrder < 14; numberOrder++) {
                    this.getCards().add(new Card(cardSuit[suitOrder], numberOrder));

                }
            }
        }
        this.shuffle();
    }


/**
     * Provide the very top (index 0) card from the deck and remove the card;
     * 
     * @return the first card on deck 
     */
    public Card giveFirstCard(){
        Card firstCard=this.getCards().get(0);
        this.getCards().remove(0);
        return firstCard;
    }


}
