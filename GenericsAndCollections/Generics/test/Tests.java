import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {
  @Test
  public void testBagBasics() {
    Bag<Integer> b = new Bag<>();
    Assert.assertTrue("You have to initialize the array list in the constructor of Bag",b.objects!=null);
    try{
      b.add(5);
      Assert.assertEquals("You may not be adding correctly to a bag",(Integer)5,b.drawOne());
    }catch(BagException e){
      Assert.fail("You are not adding elements correctly and you do not seem to be managing your exceptions correctly");
    }
    try{
      b.add(null);
      Assert.fail("Null values are not allowed in thee add method of Bag");
    }catch(BagException e){

    }catch(Exception e){
      Assert.fail("you must throw a BagException, not any other exceptions when nulls are inserted in the Bag.");
    }

  }

  @Test
  public void testBagSpecifics(){
    try{
      Bag<String> b = new Bag<>();
      b.add("hello");
      b.add("hello");
      b.add("world");
      b.add("world");
      String e = b.drawOne();

      Assert.assertTrue("You may not be retrieving elements of Bag in drawOne",e.equals("hello")||e.equals("world"));
      b.add("hello",0.75);
      System.out.println(b.objects);
      Assert.assertEquals("Are you correctly inserting with probabilities?",7,b.objects.size(),1);
    } catch(BagException e){
      Assert.fail("You may not be throwing exceptions correctly in Bag");
    }

  }

  @Test
  public void testCorrectUseOfException(){
    try{
      Bag<String> b = new Bag<>();
      b.add("hello");
      ArrayList<String> l = b.drawMany(5);
      int h = 0;
      for(String s:l)
        if(s.equals("hello"))
          h++;
      Assert.assertTrue("Somehow your draw many may not be working properly.",(l.size()-h)<h);
      b.add("hello",1.2);
      Assert.fail("You are not throwing exceptions when probability is out of range.");
    }catch(BagException e){

    }catch(Exception e){
      Assert.fail("You are not throwing a BagException when appropriate. Perhaps you are throwin a different Exception?:"+e.getMessage());
    }
  }

  @Test
  public void testBingoChip(){
    BingoChip<String,Integer> b1 = new BingoChip<>("N",3);
    BingoChip<Integer,String> b2 = new BingoChip<>(3,"N");
    Assert.assertEquals("Your bingo chip toString may not be working properly or you are not initializing things correctly",b1.toString().length(),b1.toString().length());
  }

}