package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SetupAndTeardown {


    public WebDriver driver;

    @BeforeSuite
    public void setup(){
        String browser_name = "Chrome"; //firefox, chrome, edge
        if(browser_name.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browser_name.equals("Chrome")){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
          openURL();
    }

    public void openURL()
    {
        String appURL = "https://www.centrepointstores.com/ae/en/department/cross";
        driver.get(appURL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
