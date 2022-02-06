import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class Tests {
  @Test
  public void testComputingReviews() {
    Task t = new Task();
    JsonObject doc = t.readJson("./test/restaurant-data.json");
    Database db = new Database(doc);
    JsonArray restaurants = (JsonArray)doc.get("restaurants");
    JsonObject obj = db.getRestaurant("Kang Ho Dong Baekjeong");
    JsonObject kang = (JsonObject)restaurants.get(2);
    Assert.assertEquals("You are not computing the average review score correctly. Check 'Superiority Burger' for example.",4.3,db.getAvgReviews("Superiority Burger"),0.05);
      }

  @Test
  public void testReadingFile(){
    Task t = new Task();
    String contents = t.readFile("./test/restaurant-data.json");
    Assert.assertEquals("Your readFile method is not reading the file correctly.",20423,contents.length(),300);
  }

  @Test
  public void testJsonDoc(){
    Task t = new Task();
    JsonObject doc = t.readJson("./test/restaurant-data.json");
    Database db = new Database(doc);
    String contents = t.readFile("./test/restaurant-data.json");
    Assert.assertTrue("Are you sure you loaded a JsonObject?",doc.containsKey("restaurants"));
  }

  @Test
  public void testJSONStructureInDB(){
    Task t = new Task();
    JsonObject doc = t.readJson("./test/restaurant-data.json");
    Database db = new Database(doc);
    String contents = t.readFile("./test/restaurant-data.json");
    JsonArray restaurants = (JsonArray)doc.get("restaurants");
    Assert.assertEquals("Loaded wrong number of restaurants",10,restaurants.size());
  }

  @Test
  public void testOtherJSONViaDB(){
    Task t = new Task();
    JsonObject doc = t.readJson("./test/restaurant-data.json");
    Database db = new Database(doc);
    JsonArray restaurants = (JsonArray)doc.get("restaurants");
    JsonObject obj = db.getRestaurant("Kang Ho Dong Baekjeong");
    JsonObject kang = (JsonObject)restaurants.get(2);
    Assert.assertEquals("Your Get Restaurant method is not working correctly. Try printing out the outputs",kang,obj);
    Assert.assertEquals("Maybe the key value pairs are not quite correct. Check Kang Ho Dong Baekjeong",new BigDecimal("3"),(BigDecimal) obj.get("id"));
    Assert.assertEquals("It seems the number of fields for some restaurants is wrong. Check how you are reading/converting the file to Json and check Kang Ho Dong Baekjeong",9,db.getRestaurant("Kang Ho Dong Baekjeong").size());
  }
}