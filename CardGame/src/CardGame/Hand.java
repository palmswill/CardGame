package CardGame;

public class Hand extends GroupOfCards {



    Hand(){

    }

    public void setCard(Card card){
        this.getCards().add(card);
    }

    public void displayHand(){
        String CardsInString="";

        for (int i=0;i<this.getCards().size();i++){
            CardsInString=(i+1)+": "+this.getCards().get(i).toString();
            System.out.println(CardsInString);
        }


    }







    
}
