package CardGame;

import java.util.Scanner;

public class RegPlayer extends Player {
    RegPlayer(String name) {
        super(name);

    }

    private Scanner in = new Scanner(System.in);

    public void play() {
    }

    public void play(Round round, boolean ifClubThree) {
        System.out.println(this.getName());
        this.getHand().displayHand();
        System.out.println("Enter the index of card you want to give out:");
        int cardIndex = in.nextInt();
        giveCardtoRound(round, cardIndex,ifClubThree);

    }

    public void giveCardtoRound(Round round, int cardIndex, boolean ifClubThree) {
        Card cardGiven = this.getHand().getCards().get(cardIndex + 1);
        if (ifClubThree) {
            round.setCurrentCard(cardGiven);
            this.getHand().getCards().remove(cardIndex + 1);
        } else {
            if (cardGiven.isLargerEqualCompareTo(round.getCurrentCard())) {
                round.setCurrentCard(cardGiven);
                this.getHand().getCards().remove(cardIndex + 1);
            }
        }
    }

}
