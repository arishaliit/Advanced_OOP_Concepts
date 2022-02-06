import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestShape {

    @Test
    public void testShapeConstructor() throws NoSuchMethodException {
        Class[] params = {String.class};
        Constructor sc = Shape.class.getConstructor(params);
        Assert.assertNotNull("Constructor with String not present",sc);
        Assert.assertTrue("You only need to implement one constructor",Shape.class.getConstructors().length==1);
    }

    @Test
    public void testShapeConstructorFunctionality() {
        Shape s = new Shape("mick");
        Assert.assertEquals("Name variable is not functioning correctly. Check your constructor",s.getName(),"mick");
    }
}