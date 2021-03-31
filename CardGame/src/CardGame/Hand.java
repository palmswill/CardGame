package CardGame;

public class Hand extends GroupOfCards {



    Hand(){

    }

    public void setCard(Card card){
        this.getCards().add(card);
    }

    public void displayHand(){

        for (int i=0;i<this.getCards().size();){
            String CardsInString="";
            int t=0;
            while (t<3&&i<this.getCards().size()){
                CardsInString+="        "+(i+1)+": "+this.getCards().get(i).toString();
                t++;
                i++;
            }
            // CardsInString=(i+1)+": "+this.getCards().get(i).toString();
            System.out.println(CardsInString);
        }


    }







    
}
