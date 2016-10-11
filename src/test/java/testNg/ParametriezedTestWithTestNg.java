package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by christian.draeger on 30.06.16.
 */
public class ParametriezedTestWithTestNg {

    @DataProvider(name="firstTestDataSet")
    public Object[][] testData1(){
        return new Object[][]{
                {"first String", 111, true},
                {"second String", 222, false},
                {"third String", 333, true}
        };
    }


    @DataProvider(name="secondTestDataSet")
    public Object[][] testData2(){
        return new Object[][]{
                {111, true, "first String", "lol"},
                {222, true, "second String", "wtf"},
                {333, true, "third String", "omg"}
        };
    }

    @Test(dataProvider = "firstTestDataSet")
    public void test1(String someString, int someNumber, boolean someBoolean) throws InterruptedException {
        System.out.println("someString= " + someString + " | someNumber= " + someNumber + " | someBoolean= " + someBoolean);

        // simulate some time a test could need
        Thread.sleep(5000);
    }


    // not possible with junit
    @Test(dataProvider = "secondTestDataSet")
    public void test2(int someNumber, boolean someBoolean, String someString, String someExtraString) throws InterruptedException {
        System.out.println("someString= " + someString + " | someExtraString= " + someExtraString + " | someNumber= " + someNumber + " | someBoolean= " + someBoolean);

        // simulate some time a test could need
        Thread.sleep(5000);
    }


    // not possible with junit
    @Test
    public void test3(){
        System.out.println("\n i'm a non parametrized test in the same class !");
    }

}
