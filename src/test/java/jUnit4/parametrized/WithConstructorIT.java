package jUnit4.parametrized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by christian.draeger on 30.06.16.
 */
@RunWith(Parameterized.class)
public class WithConstructorIT {

    @Parameterized.Parameters
    public static Collection<Object[]> blabla() {
        return Arrays.asList(new Object[][] { {"first String", 111, true}, {"second String", 222, false}, {"third String", 333, true}
        });
    }

    private String someString;
    private int someNumber;
    private boolean someBoolean;

    public WithConstructorIT(String testString, int testNumber, boolean testBoolean) {
        someString = testString;
        someNumber = testNumber;
        someBoolean = testBoolean;
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("\ni'm a parametrized jUnit test (using constructor),\nmy parameters now have the value:\n\t"
                + someString + "\n\t" + someNumber + "\n\t" + someBoolean);

        // simulate some time a test could need
        Thread.sleep(5000);
    }
}
