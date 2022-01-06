package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

    public Landingpage(WebDriver mDriver){
        PageFactory.initElements(mDriver,this);
    }

    @FindBy(xpath = "//span[text()='Home']")
    WebElement homepage;


    public void clickHomepage() throws InterruptedException {
        Thread.sleep(500);
        homepage.click();

    }



}
