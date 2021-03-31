package CardGame;

import java.util.ArrayList;

public class Round {
    public Card currentCard;
    public Integer winnerIndex;
    public Integer currentPlayerIndex;
    public Integer LastPlayerIndex;

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
            System.out.println("     Current Card to beat: " + currentCard + "        \n");
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



    public void displayCurrentCard() {
        System.out.println(currentCard);
    }

    public boolean setCurrentCardSucess(Card cardGiven) {
        if (currentCard == null) {
            currentCard = cardGiven;
            return true;
        } else {
            if (cardGiven.isLargerEqualCompareTo(currentCard)) {
                currentCard = cardGiven;
                return true;
            }

            System.out.println("--------------------------------------------------------\n");
            System.out.println(cardGiven.toString() + " is Smaller than " + currentCard.toString());
            System.out.println("-----------------------------------------------------------\n");

            return false;

        }
    }

    public Card getCurrentCard() {
        return currentCard;

    }

}
