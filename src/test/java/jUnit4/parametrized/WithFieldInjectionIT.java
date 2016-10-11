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
public class WithFieldInjectionIT {

    @Parameterized.Parameters (name = "test number {index}: someString= {0} | someNumber= {1} | someBoolean= {2}") // <--- naming tests for better identification
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"idealo.de", 111, true},
                {"idealo.in", 222, false},
                {"idealo.es", 333, true}
        });
    }

    @Parameterized.Parameter(value = 0) // <--- default
    public String someString;

    @Parameterized.Parameter(value = 1)
    public int someNumber;

    @Parameterized.Parameter(value = 2)
    public boolean someBoolean;

    @Test
    public void test() throws InterruptedException {
        System.out.println("\ni'm a parametrized jUnit test (using field injection),\nmy parameters now have the value:\n\t"
                + someString + "\n\t" + someNumber + "\n\t" + someBoolean);


        // simulate some time a test could need
        Thread.sleep(5000);
    }
}
