import driver.DriverManager;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    @BeforeMethod
    public void beforeTest() throws Exception {
        DriverManager.driver.androidDriver = DriverManager.driver.createDriver();
    }
}
