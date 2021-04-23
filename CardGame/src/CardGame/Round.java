package CardGame;

import java.util.ArrayList;

public class Round {

    public ArrayList<Card> currentCard = new ArrayList<Card>();
    public Integer winnerIndex;
    public Integer currentPlayerIndex;
    public Integer LastPlayerIndex;
    private final CardComparetor COMPARETOR = new CardComparetor();

    public void play(int firstPlayerIndex, ArrayList<RegPlayer> playerList, TBTgame game) {

        System.out.println("--------------------------------------------------------\n");
        System.out.println("            Decide First Card of This Round!            \n");
        System.out.println("--------------------------------------------------------\n");

        playerList.get(firstPlayerIndex).play(this);
        currentPlayerIndex = firstPlayerIndex;
        if (playerList.get(currentPlayerIndex).getHand().getSize() == 0) {
            game.winner = playerList.get(currentPlayerIndex);
            game.declareWinner();
            return;
        }

        while (winnerIndex == null && currentPlayerIndex < playerList.size()) {

            System.out.println("--------------------------------------------------------\n");
            System.out.println("     Current Card to beat: " + currentCard + "        \n\n");
            System.out.println("Remember:  2 > 1 > Other numbers      Number First          \n");
            System.out.println("           Spade >Heart >Diamond >Club       Suite Second    \n");
            System.out.println("-----------------------------------------------------------\n");
            currentPlayerIndex++;
            if (currentPlayerIndex == playerList.size()) {
                currentPlayerIndex = 0;
            }
            playerList.get(currentPlayerIndex).play(this);
            if (playerList.get(currentPlayerIndex).getHand().getSize() == 0) {
                game.winner = playerList.get(currentPlayerIndex);
                game.declareWinner();
                return;
            }

        }
        System.out.println("Round winner: " + playerList.get(winnerIndex).getName());
        Round round = new Round();
        round.play(winnerIndex, playerList, game);

    }

    Round() {

    }

    public void playerPlayRound() {

    }

    public void displayCurrentCard() {
        System.out.println(currentCard);
    }

    /**
     *  when called, compare card given to the card that is provided by the last user.
     * If it is larger, replace the current card and return true;
     * If it is smaller, return false;
     * @param cardGiven
     * @return if the card is sucessfully replaced
     */

    public boolean setCurrentCardSucess(Card cardGiven) {

        if (currentCard.isEmpty()) {
            currentCard.add(0, cardGiven);
            System.out.println("init");
            return true;
        } else {
            if (COMPARETOR.compareCard(cardGiven, currentCard.get(0))) {
                System.out.println("Compared");
                currentCard.set(0, cardGiven);
                return true;
            } else {
                System.out.println("--------------------------------------------------------\n");
                System.out.println(cardGiven.toString() + " is Smaller than " + currentCard.get(0).toString());
                System.out.println("-----------------------------------------------------------\n");

                return false;

            }

        }
    }

    public ArrayList<Card> getCurrentCard() {
        return currentCard;

    }

}
