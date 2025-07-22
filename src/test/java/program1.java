import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class program1
{
        @Test
        public void openbrowser() throws InterruptedException {
                System.out.println("Setting up ChromeDriver...");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");
                // Ensure headless is NOT enabled
                // options.addArguments("--headless");  // Do NOT use this

                WebDriver driver = new ChromeDriver(options);
                System.out.println("ChromeDriver initialized.");

                driver.get("https://www.facebook.com");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                System.out.println("Title: " + driver.getTitle());

                Thread.sleep(10000);  // Keep browser open for 10 seconds
                driver.quit();
        }
}
