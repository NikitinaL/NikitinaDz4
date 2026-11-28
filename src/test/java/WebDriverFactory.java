import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class WebDriverFactory {

    public static WebDriver createDriver(String... arguments) {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                for (String argument : arguments) {
                    options.addArguments(argument);
                }
                return new FirefoxDriver(options);
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                for (String argument : arguments) {
                    options.addArguments(argument);
                }
                return new ChromeDriver(options);
            }
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser
                        + ". Допустимые значения: chrome, firefox");
        }
    }
}
