public class Task {
    public static void main(String[] args){
        Car c1 = new Car("Kona",250);
        Car c2 = new Car("Ioniq",220);

        Runnable rcr1 = new Racer(c1);
        Racer rcr2 = new Racer(c2);
        
        new Thread(rcr1).start();
        new Thread(rcr2).start();;
    }
}