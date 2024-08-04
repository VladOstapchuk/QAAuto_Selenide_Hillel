package HomeWorks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.com.hillel_lms.setup.Setup.browserQuit;
import static org.com.hillel_lms.setup.Setup.setUp;

    public class BaseTest {

    @BeforeClass
    public static void setUpBeforeClass(){
        setUp();
    }

    @AfterMethod
    public static void setUpAfterMethod(){
        browserQuit();
    }
}
