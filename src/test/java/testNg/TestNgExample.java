package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by christian.draeger on 30.06.16.
 */
public class TestNgExample {

    @DataProvider(name="firstTestDataSet", parallel = true) // default is parallel false (see testng.xml to set number of threads)
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
        System.out.println("\ni'm a parametrized testNg test that runs in parallel and i'm using data from\"firstTestDataSet\"\nmy parameters now have the value:\n\t"
                + someString + "\n\t" + someNumber + "\n\t" + someBoolean);

        // simulate some time a test could need
        Thread.sleep(5000);
    }


    // not possible with junit
    @Test(dataProvider = "secondTestDataSet")
    public void test2(int someNumber, boolean someBoolean, String someString, String someExtraString) throws InterruptedException {
        System.out.println("\ni'm a parametrized testNg test, but using data from\"secondTestDataSet\"\nmy parameters now have the value:\n\t"
                            + someString + "\n\t" + someExtraString + "\n\t" + someNumber + "\n\t" + someBoolean);

        // simulate some time a test could need
        Thread.sleep(5000);
    }


    // not possible with junit
    @Test
    public void test3(){
        System.out.println("\n i'm a non parametrized testNg test in the same class !");
    }

}
