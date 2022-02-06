import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.LinkedList;

public class Tests {
  @Rule
  public TextFromStandardInputStream txt = TextFromStandardInputStream.emptyStandardInputStream();

  @Test
  public void testWebPage() {
    WebPage wp = new WebPage();
    Assert.assertTrue("Is your dom a LinkedList?",wp.dom instanceof LinkedList);
    wp.addTitle("T1");
    Assert.assertTrue("Is your title adding the right tags in the right place, with no spaces?",wp.dom.get(0).equalsIgnoreCase("<h1>t1</h1>"));
    wp.addParagraph("p1");
    Assert.assertTrue("Are you adding new elements (paragraps and titles as new elements in the dom?",wp.dom.size()==2);
    Assert.assertTrue("Is your addParagraph adding the right tags next to the text (no spaces)?",wp.dom.get(1).equalsIgnoreCase("<p>p1</p>"));
    Assert.assertTrue("Is your toString flattening the dom into one big string?",wp.toString().contains("T1") && wp.toString().contains("p1") && wp.toString().contains("body"));
    wp.save("deleteme.html");
    File f = new File("deleteme.html");
    Assert.assertTrue("Are you saving to a file with an arbitrary given name?",f.exists());
  }

  @Test
  public void testWebPageEditor(){
    WebPageEditor wpe = new WebPageEditor("first.html");
    txt.provideLines("t:t1","first para","second para");
    Thread t = new Thread(wpe::start);
    t.start();
    Assert.assertTrue("Are you spanning at least two threads?",4<Thread.activeCount());
    try {
      t.sleep(11000L);
      txt.provideLines("quit");
      System.out.println(wpe);
    }catch(Exception e){
      Assert.fail("Something is wrong with the threads:"+e.getMessage());
    }


  }


}