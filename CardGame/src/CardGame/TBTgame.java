package CardGame;
import java.util.Scanner;

public class TBTgame extends Game{
    private Scanner in = new Scanner(System.in);
    private int users;
    private Deck deck;
    private String names;
    private int firstPlayerIndex;

    TBTgame(){
        super("The Big Two");

    }
    public void play(){
        System.out.println("Welcome to The Big Two \n");
        System.out.println("The rule is the following: \n");
        System.out.println("The winning condition is whoever can get rid of their hand first win the game\n");
        System.out.println("In each round, you can only get rid of a card that is larger then the previous player\n");
        System.out.println("Each round, the the winner of the last round get to get rid of their card first");
        System.out.println("Player with Club 3 will start the first round");
        System.out.println("Compare Number first, then Suite ");
        System.out.println(" 2 > 1 > Other numbers             \n");
        System.out.println(" Spade >Heart >Diamond >Club       \n");


        initalizeGame();

    }

    public void initalizeGame(){
        setUsers();
        setDeck();
        distributeCards();
        startRounds();
    }

    public void startRounds(){
        Round round= new Round();
        round.play(firstPlayerIndex,this.getPlayers(),this);
    }


    public void setUsers(){
        do{
            System.out.print("How many people are playing?(2-6) ");
            users=in.nextInt();

        }while (users<2 ||users>6);


        for (int i=0; i<users; i++){
            System.out.print("What is the players name? ");
            names=in.next();
            this.setPlayer(names,i);
        }
    }

    public void setDeck(){
        if (users>4){
            deck= new Deck(1);
        }
        else{
            deck= new Deck(1);
        }


    }
    /**
     * distribute card to the players, determine who gets to be the player of the first round by checking 
     * who got club 3
     * 
     */
    public void distributeCards(){
        
        int i=0;
        while (!deck.isEmpty()){
            Card tempHold=deck.giveFirstCard();
            if (tempHold.getSuit()=='C'&&tempHold.getValue()==3){
                firstPlayerIndex=i;

            }  
            this.getPlayers().get(i).getHand().setCard(tempHold);
            i++;
            if (i==users){
                i=0;
            }
        }

    }

    public void declareWinner(){
        System.out.println("\n------------------------------------------------------\n");
        System.out.println("     Player "+this.winner.getName() +" Has Won the Game!");
        System.out.println("\n------------------------------------------------------\n");
    }
    
}
