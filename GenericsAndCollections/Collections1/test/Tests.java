import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Tests {
  @Test
  public void testCard() {
    Card<Integer,String> c1 = new Card<>(10,"Spades");
    Card<String,String> c2 = new Card<>("10","Spades");
    Assert.assertEquals("Your toString method may be wrong, or you are not initializing a Card correctly",c1.toString(),c2.toString());
    Assert.assertEquals("Your suit getter may not be working correctly","Spades",c1.getSuit());
    Assert.assertEquals("Your value getter may not be correct",(Integer)10,c1.getValue());
  }

  @Test
  public void testDeck(){
    Deck d = new Deck();
    Assert.assertEquals("Are you inserting all possible cards in a Deck?",52,d.size());
    Card c1 = d.dealCard();
    Card c2 = d.dealCard();
    int cardsDealt = 2;
    while(!(c1.getValue() instanceof Integer)) {
      c1 = d.dealCard();
      cardsDealt++;
    }
    while(!(c2.getValue() instanceof Integer)) {
      c2 = d.dealCard();
      cardsDealt++;
    }
    Assert.assertTrue("Are you sure your cards are randomly drawn? This check can come as 'incorrect'. Simply try running this check again. If it never shows as 'correct' then there is a problem",Math.abs((Integer)c1.getValue()-(Integer)c2.getValue())>1);
    Assert.assertEquals("Are you sure you are removing the cards dealt from the deck?",52-cardsDealt,d.size());

    Deck d2 = new Deck();
    int i=d2.size();
    int fc = 0;
    int nc = 0;
    while(i>0){
      if(d2.dealCard().getValue() instanceof Integer)
        nc++;
      else
        fc++;
      i--;
    }

    Assert.assertTrue("Are you sure you have all kinds of cards, like a 3 of hearts or an Ace of Hearts, or a Jack of Diamonds..",fc==16 && nc==36);

  }

  @Test
  public void testDeckIterator(){
    Deck d1 = new Deck();
    DeckIterator it1 = new DeckIterator(d1);

    Assert.assertTrue("Is your deck iterable?",d1 instanceof Iterable);
    Assert.assertTrue("Is your DeckIterator implementing the Iterator interface?",it1 instanceof Iterator);
    Assert.assertEquals("Is your iterator method returning an iterator over the deck?",it1.d,((DeckIterator)d1.iterator()).d);
    int i=0;
    for(Card c:d1){
      i++;
    }
    Assert.assertEquals("Are you sure your next and hasNext work correctly? I could not iterate through all the cards",52,i);
  }

  @Test
  public void testHand(){
    ArrayList<Card> hand = new ArrayList<>();
    hand.add(new Card<String,String>("Ace","Hearts"));
    hand.add(new Card<String,String>("Queen","Spades"));
    hand.add(new Card<String,String>("Jack","Hearts"));
    hand.add(new Card<String,String>("King","Clubs"));
    hand.add(new Card<Integer,String>(4,"Clubs"));
    int val = Task.addCards(hand);
    Assert.assertEquals("Make sure your addCards method works correctly (hint: Capitalize the first letter of the face cards)",41,val);
  }
}