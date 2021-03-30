package CardGame;

import java.util.ArrayList;

public class Round {
    public Card currentCard;

    public void play ( int firstPlayerIndex, ArrayList<RegPlayer> playerList){
        

        playerList.get(firstPlayerIndex).play(this,true);
        int currentIndex=firstPlayerIndex;

        while (currentIndex<playerList.size()){
            currentIndex++;
            if (currentIndex==playerList.size()){
                currentIndex=0;
            }
            playerList.get(currentIndex).play(this,false);

        }

        // for (int i=currentIndex;i<playerList.size();i++){
        //     playerList.get(i).play(this,false);
        //     if (i==playerList.size()){
        //         i=0;
        //     }
        // }
    }


    Round(){

    }

    public void setCurrentCard(Card card){
        currentCard=card;
    }

    public Card getCurrentCard(){
        return currentCard;

    }

    
}
