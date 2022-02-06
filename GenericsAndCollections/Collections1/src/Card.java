public class Card <V,S>{
    private V value;
    private S suit;
    public Card(V value, S suit){
        this.value = value;
        this.suit = suit;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public S getSuit() {
        return suit;
    }

    public void setSuit(S suit) {
        this.suit = suit;
    }

    public String toString(){
        return value+" of "+suit;
    }
}
