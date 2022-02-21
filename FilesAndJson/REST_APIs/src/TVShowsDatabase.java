import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

public class TVShowsDatabase {

    String baseUrl = "http://api.tvmaze.com/search/";

    public String getURLSource(URL url) throws IOException{
        // reading from url using scanner
        Scanner scan = new Scanner(url.openStream());
        String result="";
        while (scan.hasNext()) {
            result += scan.nextLine();
        }
        scan.close();
        return "{\"result\":"+result+"}";
    }

    public JsonObject getShowsByName(String name) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"shows?q="+name);
        String result = getURLSource(url);
        return Jsoner.deserialize(result, new JsonObject());
    }


    public JsonObject getPeopleInShows(String query) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"people?q="+query);

        String result = getURLSource(url);
        return Jsoner.deserialize(result, new JsonObject());
    }


    public String formatShowAsString(JsonObject doc){
        String results = "";

        JsonArray shows = (JsonArray) doc.get("result");
        for(Object r : shows){
            JsonObject obj = (JsonObject) ((JsonObject) r).get("show");
            results += "Name:"+obj.get("name")+"\n"
                    +"Link:"+obj.get("url")+"\n"
                    +"Premiered:"+obj.get("premiered")+"\n"
                    + "Rating average:"+((JsonObject)obj.get("rating")).get("average")+"\n"
                    + "Summary:"+obj.get("summary")+"\n";
        }

        return results;
    }

    public void saveShows(String text, String outfile){
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(outfile))){
            out.writeBytes(text);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
