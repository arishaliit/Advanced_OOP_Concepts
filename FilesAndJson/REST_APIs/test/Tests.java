import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class Tests {
  private TVShowsDatabase ord;
  private JsonObject obj1,obj2;
  private JsonArray arr1,arr2;

  @Before
  public void setEnv(){
    ord = new TVShowsDatabase();
    try {
      obj1 = ord.getShowsByName("simpsons");
      obj2 = ord.getPeopleInShows("Ralph Maccio");
    }catch(Exception e){
      Assert.fail("Your Methods for getShowByName or getPeopleInShows... are throwing an exception when they shouldn't:\n"+e.getMessage());
    }

    arr1 = (JsonArray) obj1.get("result");
    arr2 = (JsonArray) obj2.get("result");

  }

  @Test
  public void testRetrieval() {
    // put your test here
    String list=null;
    int elems = arr1.size();
    String name = (String)((JsonObject)arr1.get(0)).get("name");
    String dob = (String)((JsonObject)((JsonObject)arr2.get(0)).get("person")).get("birthday");
    list = ord.formatShowAsString(obj1);
    Assert.assertEquals("Are you reading/converting the full JSON document?",10,elems);
  }

  @Test
  public void testReturningJsonDocs(){
    Assert.assertTrue("Are your shows coming as a JsonArray?",arr1.size()>2 && arr1.size()<11);
    Assert.assertTrue("Are your people searches coming as a JsonArray?",arr2.size()>0 && arr2.size()<5);
  }

  @Test
  public void testContent(){
    String person = ""+((JsonObject)arr2.get(0)).get("person");
    System.out.println(person);
    Assert.assertTrue("Are you sure you are querying the right thing on getPeopleInShows method?", person.contains("69979"));
  }
  @Test
  public void testJSONStructure(){
    //System.out.println(((JsonObject)arr1.get(0)));
    JsonObject obj11=((JsonObject)arr1.get(0));
    JsonObject obj21=((JsonObject)arr2.get(0));
    String site = (String)((JsonObject)obj11.get("show")).get("url");
    String kk = (String)((JsonObject)obj21.get("person")).get("birthday");
    String list = ord.formatShowAsString(obj1);
    Assert.assertTrue("Are you returning the full JsonObject for the show search?",site.contains("tvmaze.com"));
    Assert.assertTrue("Are you returning the correct JSON for the people search?",kk.equals("1961-11-04"));
    Assert.assertTrue("Are you formatting the Json as String correctly?",list.contains("Jessica"));
  }

  @Test
  public void testWriteDoc(){
    String list = ord.formatShowAsString(obj1);
    ord.saveShows(list,"test.txt");
    try{
      File f = new File("test.txt");
      Assert.assertTrue("Are you sure you are saving a file with the name that comes in the parameter?",f.exists());
      Assert.assertEquals("Are you writing the file as directed?",f.length(),list.length());
    }catch(SecurityException e){
      Assert.fail("Are you saving the file with ANY filename that is passed?");
    }
  }
}