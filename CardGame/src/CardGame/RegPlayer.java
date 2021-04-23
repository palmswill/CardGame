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
                System.out.println("\nEnter the index of card you want to give out,Or press 99 to pass:");
                int cardIndex = in.nextInt();
                if (cardIndex==99&&round.getCurrentCard().isEmpty()){
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
            round.winnerIndex = round.LastPlayerIndex;

        }
    }

    /**
     * give the provided card to the round, check if success, if yes, get rid of the card and return true , if no, return false;
     * @param round
     * @param cardIndex
     * @returnif yes, get rid of the card , if no, return false;
     */

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
