
import org.openqa.selenium.WebDriver;

public class DriverConfig {

    private static final String BASE_URL = System.getProperty("base.url",
            "https://the-internet.herokuapp.com");

    private WebDriver driver;


}