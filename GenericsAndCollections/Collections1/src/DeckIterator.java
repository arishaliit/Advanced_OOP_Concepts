import java.util.Iterator;

public class DeckIterator<E> implements Iterator<E> {
    Deck d;
    public DeckIterator(Deck d){
        this.d = d;
    }

    @Override
    public boolean hasNext() {
       return d.size() > 0 ? true : false;
    }

    @Override
    public E next() {
        return (E) d.dealCard();
    }
}
