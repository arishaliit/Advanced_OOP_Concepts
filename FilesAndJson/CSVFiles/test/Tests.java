import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    Task t = new Task();
    Database d = t.readCSV("test/iris-data.csv");
    Assert.assertEquals("Data may not be read correctly","4.9",d.getData()[1][0]);
    Assert.assertEquals("getValue is not working correctly.","2.8",d.getValue("s-width",121));
  }

  @Test
  public void testReadingDatabase(){
    Task t = new Task();
    Database d = t.readCSV("test/iris-data.csv");
    Assert.assertEquals("Number of rows not correct",151,d.getNumRows()+1,1);
    Assert.assertEquals("Column headers not matching. Remember the first row contains the columns","species",d.getColNames()[d.getColNames().length-1]);
  }
}