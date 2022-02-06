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

Create a method getURLSource that returns a String and gets a URL object as a parameter. It should also throw an exception.
This method should read the open stream of the url and concatenate it in a String. It should then return that String.

    public JsonObject getShowsByName(String name) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"shows?q="+name);
/* TODO 
You have to use the url to retrieve the contents of the website. 
This will be a String, but in JSON format. Use the auxiliary function you created above. */
        return /* TODO 
Remember to return a JSON object.*/;
    }


    public JsonObject getPeopleInShows(String query) throws Exception
    {
        //Getting the things ready to connect to the web
        /* TODO 
Fill in this data type (Object) */ url = new /* TODO
Fill in this datatype (Object) */(baseUrl+"people?q="+query);

       /* TODO
Read the information coming from the web
 */
        return /* TODO 
return the appropriate result.
*/
    }


    public String formatShowAsString(JsonObject doc){
        String results = "";
        /* TODO 
This should return a String with each show in four fields:
Name:the name of the show
Link:the link to the show
rating average:The rating average of teh show, and 
summary, the summary of the show.*/
        return results;
    }

    public void saveShows(String text, String outfile){
        /* TODO
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */
    }

}
