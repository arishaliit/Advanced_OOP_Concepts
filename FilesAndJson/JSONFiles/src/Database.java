import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.math.BigDecimal;

public class Database {
    JsonObject data;

    public Database(JsonObject data){
        this.data = data;
    }

    public JsonObject getRestaurant(String name){
        JsonArray jsonArray = (JsonArray) this.data.get("restaurants");

        for(Object o:jsonArray){
            JsonObject jsonObject = (JsonObject) o;
            String n = (String) jsonObject.get("name");
            if(n.equals(name))
                return jsonObject;
        }

        return null;
    }

    public double getAvgReviews(String name){
        JsonObject restaurant = getRestaurant(name);

        JsonArray jsonArray = (JsonArray) restaurant.get("reviews");

        double sum = 0;
        long total = 0;

        for(Object o:jsonArray){
            JsonObject jsonObject = (JsonObject) o;
            BigDecimal n = (BigDecimal) jsonObject.get("rating");
            sum += n.doubleValue();
            total++;
        }
        return sum/total;
    }
}
