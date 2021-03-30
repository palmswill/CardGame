package CardGame;
import java.util.ArrayList;
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
        initalizeGame();

    }

    public void initalizeGame(){
        setUsers();
        setDeck();
        distributeCards();
        startRound();
        // System.out.println(this.getPlayers().get(0).getHand().getSize());
        // this.getPlayers().get(0).getHand().displayHand();
    }

    public void startRound(){
        Round round= new Round();
        round.play(firstPlayerIndex,this.getPlayers());
    }


    public void setUsers(){
        do{
            System.out.print("How many people are playing?");
            users=in.nextInt();

        }while (users<0 ||users>6);


        for (int i=0; i<users; i++){
            System.out.print("What is the players name?");
            names=in.next();
            this.setPlayer(names);
        }
    }

    public void setDeck(){
        if (users>4){
            deck= new Deck(2);
        }
        else{
            deck= new Deck(1);
        }


    }
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
        System.out.println(deck.isEmpty());

    }

    public void declareWinner(){
        System.out.println(this.winner.getName() +"Won");
    }
    
}
