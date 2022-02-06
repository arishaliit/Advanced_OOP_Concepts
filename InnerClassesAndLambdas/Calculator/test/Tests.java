import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class Tests {
  @Test
  public void testDoMath() {
    Method[] m = DoMath.class.getDeclaredMethods();
    Assert.assertTrue("DoMath should only have one method.",m.length==1);
    Assert.assertEquals("DoMath's method should be called compute","compute",m[0].getName());
    for (int i=0; i<m[0].getParameterTypes().length;i++)
      Assert.assertEquals("The parameter "+i+" of DoMath's compute should be Double","java.lang.Double",m[0].getParameterTypes()[i].getName());
    Assert.assertEquals("The return type of DoMath's compute should be Double","java.lang.Double",m[0].getReturnType().getName());
  }

  @Test
  public void testCalculator(){
    Calculator c = new Calculator();
    DoMath div = c.toOperation("/");
    DoMath mult = c.toOperation("*");
    DoMath sum = c.toOperation("+");
    DoMath minus = c.toOperation("-");
    DoMath mod = c.toOperation("%");

    Assert.assertEquals("Is your toOperation returning the right function for + ?",12.4,sum.compute(11.2,1.2),0.001);
    Assert.assertEquals("Is your toOperation returning the right function for - ?",10.2,minus.compute(11.2,1.0),0.001);
    Assert.assertEquals("Is your toOperation returning the right function for * ?",2.5,mult.compute(0.5,5.0),0.001);
    Assert.assertEquals("Is your toOperation returning the right function for / (by zero)?",Double.POSITIVE_INFINITY,div.compute(1.0,0.0),0.001);
    Assert.assertEquals("Is your toOperation returning the right function for / ?",5.0,div.compute(15.0,3.0),0.001);
    Assert.assertEquals("Is your toOperation returning the right function for unknown operations ?",Double.MIN_VALUE,mod.compute(11.2,1.2),0.001);

    Assert.assertEquals("Is your compute method of the Calculator object working correctly for additions?",12.4,c.compute(11.2,1.2,"+"),0.001);
    Assert.assertEquals("Is your compute method of the Calculator object working correctly for subtraction?",10.2,c.compute(11.2,1.0,"-"),0.001);
    Assert.assertEquals("Is your compute method of the Calculator object working correctly for multiplication?",1.2,c.compute(3.0,0.4,"*"),0.001);
    Assert.assertEquals("Is your compute method of the Calculator object working correctly for division by zero?",Double.POSITIVE_INFINITY,c.compute(11.2,0.0,"/"),0.001);
    Assert.assertEquals("Is your compute method of the Calculator object working correctly for division?",4.0,c.compute(12.0,3.0,"/"),0.001);
    Assert.assertEquals("Is your compute method of the Calculator object working correctly for unknown operations?",Double.MIN_VALUE,c.compute(11.2,1.2,"%"),0.001);
  }

  @Test
  public void testTask(){
    Task t = new Task();
    t.main(null);
    Assert.assertTrue("Are you sure you are putting the elements of the triplets correctly? or that you are implementing the correct function for forEach?",Task.result.contains("Infinity") && Task.result.contains("24.3"));
  }
}