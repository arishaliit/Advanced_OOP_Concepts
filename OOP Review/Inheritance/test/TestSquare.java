import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestSquare {
  @Test
  public void testInheritance(){
    Square s = new Square(3,"john");
    Assert.assertTrue("Square does not inherit from Shape",s instanceof Shape);
  }

  @Test
  public void testConstructor() throws
          NoSuchMethodException {
    Class[] params = {Double.TYPE,String.class};
    Constructor sc = Square.class.getConstructor(params);
    Assert.assertNotNull("Constructor with a double and a String not present",sc);
    Assert.assertTrue("You only need to implement one constructor",Shape.class.getConstructors().length==1);
  }

  @Test
  public void testAreaAndPerimeter(){
    Square s = new Square(3.2,"room 1");
    try{
      Assert.assertEquals("Your area is not being calculated correctly",s.getArea(),10.24,0.001);
      Assert.assertEquals("Your perimeter is not being calculated correctly",s.getPerimeter(),12.8,0.001);
    } catch(Exception e){
      Assert.fail("Are you sure you overrode the correct methods?");
    }
  }

  @Test
  public void testEquals(){
    Square s = new Square(3,"juan");
    Square s1 = new Square(3,"juan");
    Assert.assertEquals("Your constructor does not seem to be setting the name correctly",s,s1);
    s1.setName("john");
    Assert.assertNotEquals("Did you inherit the variables from Shape? you should not create a new name variable, nor modify or add getters and setters",s,s1);
    Shape o = new Square(3,"juan");
    Assert.assertEquals("Did you check to see if both objects are of the same class?",s,o);
    Assert.assertNotEquals("Did you check that the object was null?",s,null);
  }

  @Test
  public void testToString(){
    Square s = new Square(3,"juan");
    Assert.assertEquals("Your toString method is not returning the correct string.","juan:3.0",s.toString());
  }
}
