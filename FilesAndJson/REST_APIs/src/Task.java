import com.github.cliftonlabs.json_simple.JsonObject;

public class Task {
    public static void main(String[] args){
        TVShowsDatabase ord = new TVShowsDatabase();
        try {
            JsonObject shows = ord.getShowsByName("simpsons");
            String simpsons = ord.formatShowAsString(shows);
            JsonObject kk = ord.getPeopleInShows("Ralph%20Maccio");
            System.out.println(simpsons);
            System.out.println(kk.get("result"));
            ord.saveShows(simpsons,"simpsons.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}