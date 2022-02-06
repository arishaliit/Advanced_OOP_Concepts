import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Tests {
  @Test
  public void testExecutors() {
    Task.initExecutorService();
    Assert.assertTrue("Are you instantiating a FixedThreadPool?",Task.service instanceof ThreadPoolExecutor);
    Task.main(null);
    try {
      Task.service.awaitTermination(3, TimeUnit.SECONDS);
    }catch(Exception e){
      Assert.fail("Your thread pool is throwing an exception.");
    }
  }
}