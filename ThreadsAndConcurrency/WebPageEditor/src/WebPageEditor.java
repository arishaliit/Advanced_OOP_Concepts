import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebPageEditor {
    public  String temp; // holds the last webpage saved.
    public  WebPage wp; // the webpage you are working on
    public  String filename; // the filename to save this webpage

    public WebPageEditor(String filename){
        this.wp = new WebPage();
        this.filename = filename;
    }

    public void start(){

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()->{
            if (checkSave())
                System.out.println("...Saved");
        },10L,10L, TimeUnit.SECONDS);

        // use a scanner to read every line the user writes
        Scanner kbd  = new Scanner(System.in);
        boolean finish = false;
        while(!finish){
            String text = kbd.nextLine();
            if(text.equals("quit"))
                finish=true;
            else if (text.startsWith("t:"))
                wp.addTitle(text.substring(2));
            else
                wp.addParagraph(text);
        }
        service.shutdownNow(); // when the loop finishes, threads are stopped
    }

    public  boolean checkSave(){
        if(this.wp.toString().equals(this.temp))
            return false;
        else{
            wp.save(filename);
            temp = wp.toString();
            return true;
        }
    }
}
