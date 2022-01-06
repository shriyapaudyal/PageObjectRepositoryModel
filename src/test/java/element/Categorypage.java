package element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categorypage {
    public Categorypage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText="Furniture")
    WebElement FurnitureSubcategory;

    @FindBy(id="prodItemPriceCurr0")
    WebElement first_Product_DisplayPrice;

    @FindBy(id="prodItemTitleLink0")
    WebElement first_Product_DisplayTitle;

    @FindBy(id="prodItemImg0")
    WebElement first_product_link;

    public void ClickFurniture(){
        FurnitureSubcategory.click();
    }

    public String Gettext_DisplayTitle(){
      String D_title = first_Product_DisplayTitle.getText();
      return D_title;
    }
    public String Gettext_DisplayPrice(){
        String D_price = first_Product_DisplayPrice.getText();
        return D_price;
    }
    public void GotoFirstProductDetails() throws InterruptedException {
        first_product_link.click();
        Thread.sleep(2000);
    }


}
