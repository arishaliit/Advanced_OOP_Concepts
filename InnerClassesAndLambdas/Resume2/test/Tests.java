import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.Period;

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
    Assert.assertEquals("Is your inner class private?", Modifier.PRIVATE,inners[0].getModifiers());
  }

  @Test
  public void testPerson(){
    int age = -1*Period.between(LocalDate.now(),(LocalDate.parse("2001-05-23"))).getYears();
    Person p1 = new Person("John Doe","2001-05-23");
    p1.setPosition("Associate",45000);
    Assert.assertEquals("You may not be parsing the date correctly in the Person constructor.",age,p1.getAge());
    Assert.assertTrue("Is your toString() correct?",p1.toString().contains("John Doe") && p1.toString().contains(""+age)&& p1.toString().contains("Associate"));
  }

  @Test
  public void testInners(){
    Resume r = new Resume (new Person("Jane Doe","1992-05-23"));
    String classes = Resume.class.getDeclaredClasses()[0].getName()+Resume.class.getDeclaredClasses()[1].getName();
    int modifiers=0;
    for (Class c:Resume.class.getDeclaredClasses()) {
      System.out.println(c.getName()+":"+c.getModifiers());
      modifiers += c.getModifiers();
    }
    Assert.assertTrue("Do you have an Experience class?",classes.contains("Experience"));
    Assert.assertTrue("Do you have an Education class?",classes.contains("Education"));
    Assert.assertEquals("Do your classes have the right modifiers? (public, private, static)",10,modifiers);
    Resume.Experience ex = new Resume.Experience("CEO",2015,2021);
    Resume.Education ed = r.new Education("NEIU","Computer Sicence");
    Assert.assertTrue("Your Experience does not seem to set variables correctly.Check the specs.",ex.toString().contains("CEO") & ex.toYear==2021);
    Assert.assertTrue("Your Education object may not be initializing variables correctly. Check the specs.",ed.toString().contains("NEIU") & ed.school.equals("NEIU"));
  }

  @Test
  public void testResume() {
    Person p = new Person("Kim Possible", "2000-01-01");
    p.setPosition("Associate", 34000);
    Resume r = new Resume(p);
    Resume.Education ed = r.new Education("NEIU", "Computer Science");
    r.addEducation(ed);
    Resume.Experience ex = new Resume.Experience("Barista", 2017, 2018);
    r.addExperience(ex);
    r.addExperience(new Resume.Experience("Cashier", 2021, 2022));
    r.addExperience(new Resume.Experience("Associate", 2019, 2020));
    Assert.assertTrue("Are you sure the most recent (aka the largest value in the end year) is being polled from the queue? Check your comparator", r.getExperience().poll().toString().contains("2022"));
  }
}