/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;


import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Guest1
 */
public class CardComparetorTest {
    
    public CardComparetorTest() {
    }


    
    /**
     * Test of compareCard method, check if Number compare work for larger;
     */
    @Test
    public void testCompareEqualSuitLargerNumberCard() {
        System.out.println("compareSameSuitLargerNumber");
        Card card1 = new Card('H',13);
        Card card2 = new Card ('H',12);
        CardComparetor instance = new CardComparetor();
        boolean expResult = true;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }
    /**
     * Test of compareCard method, check if Number compare work for smaller;
     */
    @Test
    public void testCompareEqualSuitSmallerNumberCard() {
        System.out.println("compareSameSuitSmallerNumber");
        Card card1 = new Card('H',12);
        Card card2 = new Card ('H',13);
        CardComparetor instance = new CardComparetor();
        boolean expResult = false;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }
    /**
     * Test of compareCard method, check if suite compare work for larger;
     */
    @Test
    public void testCompareDiffSuitLargerCard() {
        System.out.println("compareLargerSuitSameNumber");
        Card card1 = new Card('H',12);
        Card card2 = new Card ('D',12);
        CardComparetor instance = new CardComparetor();
        boolean expResult = true;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }

    /**
     * Test of compareCard method, check if suite compare work for smaller;
     */
    @Test
   public void testCompareDiffSuitSmallerCard() {
        System.out.println("compareSmallerSuitSameNumber");
        Card card1 = new Card('D',12);
        Card card2 = new Card ('H',12);
        CardComparetor instance = new CardComparetor();
        boolean expResult = false;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }
   /**
     * Test to see if 2 is indeed larger than rest of other numbers
     * (by rule)
     */
   @Test
   public void testUniqueNumberLargerCard() {
        System.out.println("compareSameSuitUniqueNumber");
        Card card1 = new Card('D',2);
        Card card2 = new Card ('D',3);
        CardComparetor instance = new CardComparetor();
        boolean expResult = true;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }
    /**
     * Test to see if 2 is indeed larger than rest of other numbers
     * (by rule)
     */ 
   @Test
   public void testUniqueNumberSmallerCard() {
        System.out.println("compareCard");
        Card card1 = new Card('D',3);
        Card card2 = new Card ('D',2);
        CardComparetor instance = new CardComparetor();
        boolean expResult = false;
        boolean result = instance.compareCard(card1, card2);
        assertEquals(expResult, result);

    }
    
}
