import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Iterable<Card>{
    private List<Card> deck;
    private String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
    public Deck() {

        deck = new ArrayList<>();
        for (String s: suits) {
            for(int i = 1; i < 14; i++){
                switch (i) {
                    case 1:
                        this.deck.add(new Card<String, String>( "Ace", s));
                        break;
                    case 11:
                        this.deck.add(new Card<String, String>("Jack", s));
                        break;
                    case 12:
                        this.deck.add(new Card<String, String>("Queen", s));
                        break;
                    case 13:
                        this.deck.add(new Card<String, String>("King", s));
                        break;
                    default:
                        this.deck.add(new Card<Integer, String>(i, s));
                        break;
                }
            }
        }
    }

    public Card dealCard(){

        int random = (int) ((Math.random() * (size() - 0)) + 0);
        return deck.remove(random);

    }

    public int size(){
        return deck.size();
    }
    @Override
    public Iterator<Card> iterator() {
       return new DeckIterator(this);
    }
}
