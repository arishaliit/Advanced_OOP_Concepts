import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Iterable<Card>{
    private List<Card> deck;
    private String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
    public Deck() {
/* TODO 
This constructor initializes the deck variable with
all the cards of a deck, except a joker.
The suits array may help you.*/        }
    }

    public Card dealCard(){
/* TODO
Code this. It is almost EXACTLY as the  method to draw one object
from the bag in the previous task. The difference is that this method
REMOVES the card from the deck */
    }

    public int size(){/* TODO: Return the size of the deck (number of cards left in it)*/
    }
    @Override
    public Iterator<Card> iterator() {
       /* TODO 
Return a new DeckIterator with this instance in the constructor.*/
    }
}
