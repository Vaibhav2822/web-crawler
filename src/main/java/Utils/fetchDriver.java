package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchDriver {

    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }
    public static WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }


}
