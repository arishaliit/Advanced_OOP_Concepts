import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
    /* TODO
Declare a static ExecutorService named service */
    public static void main(String[] args){
        Car c1 = new Car("Kona",250);
        Car c2 = new Car("Ioniq",220);

        Runnable racer1 = /* TODO 
Create a Runnable with c1*/
        Runnable racer2 = /* TODO 
Create a Runnable with c2*/;

        initExecutorService();

        /* TODO
Submit both runnables to the ExecutorService and then request the ExecutorService to shutdown */
    }

/* TODO
Implement the initExecutorService method. This has to initialize service to a new FixedThreadPool with a minimum of 3 threads */
    }
}