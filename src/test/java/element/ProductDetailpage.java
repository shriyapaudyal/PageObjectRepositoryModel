package element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailpage {

    public ProductDetailpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[@id=\"products-details-price-current-01\"]")
    WebElement price_current;

    @FindBy(id="product-details-name")
    WebElement product_name;

    @FindBy(id="prodItemTitleLink0")
    WebElement first_Product_DisplayPrice;

    @FindBy(xpath="//*[@id=\"product-qty\"]/span/span[1]")
    WebElement addquantity;

    @FindBy(id="product-actions-btn-add")
    WebElement addToBasket;

    @FindBy(xpath = "//*[@id=\"small-cart\"]/a[1]")
    WebElement goToBasket;

    public String GetProductName(){
       String gettext= product_name.getText();
       return gettext;
    }
    public String GetPrice(){

        //String newtext= price_current.getText();
        //System.out.println(newtext);

        //For spliting the current price text
       String newtext= price_current.getAttribute("innerHTML");
       String getprice=newtext.split(";")[1];
       return getprice;
    }

    public void AddQuantity(){
       addquantity.click();
    }

    public void AddToBasket(){
        //not working
        // addToBasket.click();

    }

    public void goToCart(){

        goToBasket.click();
    }
}
