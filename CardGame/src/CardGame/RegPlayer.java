package CardGame;

import java.util.Scanner;

public class RegPlayer extends Player {
    public boolean hasClubThree = false;
    public int indexInGame;

    RegPlayer(String name, int index) {
        super(name);
        this.indexInGame = index;

    }

    private Scanner in = new Scanner(System.in);

    public void play() {
    }

    public void play(Round round) {


        if (round.LastPlayerIndex==null || round.LastPlayerIndex != this.indexInGame) {

            System.out.println("Current Player: " + this.getName()+"\n\n");
            this.getHand().displayHand();
            if (round.getCurrentCard() == null || possibletoGiveRound(round)) {
                System.out.println("\nEnter the index of card you want to give out,Or press 99 to pass:");
                int cardIndex = in.nextInt();
                if (cardIndex==99&&round.currentCard==null){
                    System.out.println("\n---------------------------------------------------------\n");
                    System.out.println("    You can not not skip as the first Player of the round! ");
                    System.out.println("\n---------------------------------------------------------\n");
                    play(round);

                }
                if (cardIndex != 99) {
                    if (!giveCardtoRoundSucess(round, cardIndex)) {
                        play(round);
                    }
                }
            } else {
                System.out.println("Impossible to Give Card!");

            }
        } else {
            round.winnerIndex = round.LastPlayerIndex;

        }
    }

    public boolean possibletoGiveRound(Round round) {
        for (int i = 0; i < this.getHand().getCards().size(); i++) {
            if (this.getHand().getCards().get(i).isLargerEqualCompareTo(round.currentCard)) {

                return true;
            }
        }
        return false;
    }

    public boolean giveCardtoRoundSucess(Round round, int cardIndex) {
        Card cardGiven = this.getHand().getCards().get(cardIndex - 1);
        if (round.setCurrentCardSucess(cardGiven)) {
            round.LastPlayerIndex = this.indexInGame;
            this.getHand().getCards().remove(cardIndex - 1);
            return true;
        }
        return false;
    }

}
