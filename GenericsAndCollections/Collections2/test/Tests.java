import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
  private String[] words;
  private Counter<String> c;

  @Before
  public void setupBefore(){
    String[] p = {"the","cat","in","the","hat"};
    words = p;
    c = new Counter<>(words);
  }
  @Test
  public void testCount() {
    Assert.assertEquals("Are you sure your get count is working correctly?",(Integer)2,c.getCount("the"));
  }

  @Test
  public void testMostFrequent(){
    Assert.assertEquals("Is your most frequent element correctly computed?","the",c.mostFrequent());
  }

  @Test
  public void testUniqueWords(){
    Assert.assertEquals("Are you sure you are counting all the unique words?",4,c.getSize());
  }
}