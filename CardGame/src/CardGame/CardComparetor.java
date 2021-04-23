package CardGame;



public class CardComparetor {

     char[] cardSuit = { 'C', 'D', 'H', 'S' };


     /**
      * Compare if the first card is larger than the second card
      * @param card1
      * @param card2
      * @return true if the first card is larger than the second card
      */


     public boolean compareCard (Card card1,Card card2){
          int selfIndex = 0;
        int otherIndex = 0;
        int selfValue=card1.getValue();
        int otherValue=card2.getValue();

        for (int i = 0; i < cardSuit.length; i++) {
            if (cardSuit[i] == card2.getSuit()) {
                otherIndex = i;
            }
            if (cardSuit[i] == card1.getSuit()) {
                selfIndex = i;
            }
        }
        if (selfValue==2||(selfValue==1&& otherValue!=2)) {
            return true;
        } 
        if(otherValue!=2&&otherValue!=1&&selfValue>otherValue){
            return true;
        }
        if (selfValue==otherValue){
            return (selfIndex >= otherIndex);

        }else {
            return false;
        }




         
     }
    
}
