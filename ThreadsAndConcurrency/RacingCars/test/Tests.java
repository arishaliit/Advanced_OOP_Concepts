import org.junit.Assert;
import org.junit.Test;


public class Tests {
  @Test
  public void testCar() {
    // put your test here
    Car c = new Car("Max",40);
    c.move(30.5);
    c.move(0.5);
    Assert.assertEquals("Your odometer may not be correct",31.0,c.odometer,0.01);
  }

  @Test
  public void testRacer(){
    Racer r = new Racer(new Car("Tesla",260));
    Assert.assertTrue(r instanceof Runnable);
    long t1 = System.currentTimeMillis();
    r.run();
    long t2 = System.currentTimeMillis();
    long totalTime = t2-t1;
    Assert.assertEquals("Are you sure your racer is going all the way to 1000 miles?",1000,r.c.odometer,1);
    Assert.assertTrue("Is your thread sleeping while charging?",totalTime>=750);
  }
}