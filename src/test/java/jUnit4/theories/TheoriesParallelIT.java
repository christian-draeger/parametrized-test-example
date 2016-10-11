package jUnit4.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.googlecode.junittoolbox.ParallelRunner;

/**
 * Created by christian.draeger on 30.06.16.
 */
@RunWith(ParallelRunner.class) // <----- parallel runner
public class TheoriesParallelIT {

    @DataPoint public static Object[] TEST1 = { "idealo.de", 111, true};
    @DataPoint public static Object[] TEST2 = { "idealo.in", 222, false};
    @DataPoint public static Object[] TEST3 = { "idealo.es", 333, true};

    @Theory
    public void test(Object[] testData) throws InterruptedException {
        System.out.println("\ni'm a parametrized jUnit test (with theories) that runs in parallel\nmy parameters now have the value:\n\t"
                + testData[0] + "\n\t" + testData[1] + "\n\t" + testData[2]);

        // simulate some time a test could need to demonstrate advantage of parallelization
        Thread.sleep(5000);
    }
}