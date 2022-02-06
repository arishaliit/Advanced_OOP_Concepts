import java.io.*;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris-data.csv");
    }

    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = /* TODO.
Change what needs to go here to start reading "filename" */){
            byte[] buffer = /* TODO 
Create a byte array of about 1024 bytes or however many bytes you want. */;
            int lengthRead;
            /* TODO 
Create a while loop to read the contents of the file and put them in the variable "contents" declared at the beginning of the method. */
        } catch (/* TODO 
Put the correct Exception here. */) {
            e.printStackTrace();
            System.exit(-1);
        }
        return/* TODO 
Return a Databse object initialized with the contents read. */);
    }
}
