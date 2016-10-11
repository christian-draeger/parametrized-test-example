package jUnit4.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.googlecode.junittoolbox.ParallelRunner;

/**
 * Created by christian.draeger on 30.06.16.
 */
@RunWith(ParallelRunner.class) // <----- parallel runner
public class TheoriesParallel {

    @DataPoint public static Object[] TEST1 = { "idealo.de", 111, true};
    @DataPoint public static Object[] TEST2 = { "idealo.in", 222, false};
    @DataPoint public static Object[] TEST3 = { "idealo.es", 333, true};

    @Theory
    public void test(Object[] testData) throws InterruptedException {
        System.out.println("someString= " + testData[0] + " | someNumber= " + testData[1] + " | someBoolean= " + testData[2]);

        // simulate some time a test could need to demonstrate advantage of parallelization
        Thread.sleep(5000);
    }
}