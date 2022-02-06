import org.junit.Assert;
import org.junit.Test;

public class Tests {

  @Test
  public void testTempSetters(){
    ChildPatient b = new ChildPatient();
    b.setTemperature(100.5);
    Assert.assertTrue("Has fever should check the temperature of the patient.",b.hasFever());
  }

  @Test
  public void testEmployableSettersGetters(){
    AdultPatient homer = new AdultPatient();
    homer.addJob("Nuclear Engineer");
    homer.addJob("Major");
    homer.addJob("Bar Owner");
    Assert.assertEquals("Get previous jobs is not returning all the jobs",3,homer.getPreviousJobs().size());
  }

  @Test
  public void testArrayOfPeople() {
    // put your test here
    Task t = new Task();
    t.run();
    Assert.assertTrue("Did you assign bart to the first position?",t.patients[0] instanceof ChildPatient);
    Assert.assertTrue("Did you assign bart to the first position?",t.patients[0] instanceof Diagnosable);
    Assert.assertTrue("Is bart a child patient?", t.patients[0] instanceof ChildPatient);
    Assert.assertTrue("Temp. Setters working?",((ChildPatient)(t.patients[0])).hasFever());
    Assert.assertEquals("Employable setters working?", 3, ((Employable) t.patients[3]).getPreviousJobs().size());
  }

  @Test
  public void testAdultPatient(){
    Task t = new Task();
    t.run();
    Assert.assertTrue("An adult patient also an Employable?", t.patients[4] instanceof Employable);
    Assert.assertTrue("Is an adult patient a diagnosable?", t.patients[4] instanceof Diagnosable);
    Assert.assertTrue("Is Marge an adult patient?", t.patients[4] instanceof AdultPatient);
  }
}