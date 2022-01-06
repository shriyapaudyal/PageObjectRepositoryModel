package element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(WebDriver driver)
    {

        PageFactory.initElements(driver,this);
    }
    //WebElement
    @FindBy(id="RemoveProduct_00")
    WebElement removeFirstProduct;
    @FindBy(id="start-shopping-btn")
    WebElement startShopping;



    public void RemoveFromCart() throws InterruptedException {
        removeFirstProduct.click();
        Thread.sleep(1000);
    }

    public void StartShopping() {
        startShopping.click();
    }
}
