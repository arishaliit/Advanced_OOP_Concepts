import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Task {
    public static void main(String[] args){
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public String readFile(String filename){

        String text = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String s = "";
            while((s = reader.readLine()) != null){

                text += s;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return text;
    }

    public JsonObject readJson(String filename){

        JsonObject content = null;

        try {
            content = (JsonObject) Jsoner.deserialize(readFile(filename));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        return content;
    }
}