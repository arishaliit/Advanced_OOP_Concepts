import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Tests {
  @Test
  public void testPosition() {
    Person p1 = new Person("John Doe","2001-05-23");
    p1.setPosition("Associate",45000);
    String p = ""+p1.getPosition();
    Assert.assertTrue("Your position is not saving  the title as passed in setPosition.",p.contains("Associate"));
    Assert.assertTrue("Your position is not saving the salary as it should, or you overriding of the toString() method is not printing it.",p.contains("45000")||p.contains("45,000"));
    Class[] inners = Person.class.getDeclaredClasses();
    Assert.assertEquals("Is your inner class named Position","Person$Position",inners[0].getName());
    Assert.assertEquals("Is your inner class private?",Modifier.PRIVATE,inners[0].getModifiers());
  }

  @Test
  public void testPerson(){
    int age = -1*Period.between(LocalDate.now(),(LocalDate.parse("2001-05-23"))).getYears();
    Person p1 = new Person("John Doe","2001-05-23");
    p1.setPosition("Associate",45000);
    Assert.assertEquals("You may not be parsing the date correctly in the Person constructor.",age,p1.getAge());
    Assert.assertTrue("Is your toString() correct?",p1.toString().contains("John Doe") && p1.toString().contains(""+age)&& p1.toString().contains("Associate"));
  }
}