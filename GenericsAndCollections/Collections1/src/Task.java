import java.util.ArrayList;

public class Task {
    public static void main(String[] args){
        Deck d = new Deck();
        // Draw some random cards:
        System.out.println(d.dealCard());
        System.out.println(d.dealCard());

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(d.dealCard());
        hand.add(d.dealCard());
        hand.add(d.dealCard());

        System.out.println("Hand is:"+hand);
        System.out.println("Cards add:"+addCards(hand));


        for (Card card:d){
            System.out.println(card);
        }

    }

    public static int addCards(ArrayList<Card> hand){

        int sum = 0;
        for(Card d: hand){
            if(d.getValue().equals("Ace")){
                sum += 1;
            }
            else if(d.getValue().equals("Jack")){
                sum += 11;
            }
            else if(d.getValue().equals("Queen")){
                sum += 12;
            }
            else if(d.getValue().equals("King")){
                sum += 13;
            }
            else{
                sum += (Integer) d.getValue();
            }
        }

        return sum;
    }
}