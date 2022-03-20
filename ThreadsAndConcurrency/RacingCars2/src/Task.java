import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
    static ExecutorService service;
    public static void main(String[] args){
        Car c1 = new Car("Kona",250);
        Car c2 = new Car("Ioniq",220);

        Runnable racer1 = new Racer(c1);
        Runnable racer2 = new Racer(c2);

        initExecutorService();

        service.submit(racer1);
        service.submit(racer2);
        service.shutdown();
    }

    public static void initExecutorService(){
        service = Executors.newFixedThreadPool(3);
    }
}