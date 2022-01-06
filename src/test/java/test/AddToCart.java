package test;

import element.CartPage;
import element.Categorypage;
import element.Landingpage;
import element.ProductDetailpage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart extends SetupAndTeardown {

    String get_display_price,get_display_title,detail_price,detail_title;


  @Test
    public void Goto_Home_Page() throws InterruptedException {
        Categorypage categorypageobj=new Categorypage(driver);
        Landingpage landingpageobj = new Landingpage(driver);
        landingpageobj.clickHomepage();
        categorypageobj.ClickFurniture();

    }

    @Test
    public void Goto_Category_Furniture_Page() throws InterruptedException {
        Categorypage categorypageobj=new Categorypage(driver);
       get_display_price = categorypageobj.Gettext_DisplayPrice();
       get_display_title= categorypageobj.Gettext_DisplayTitle();
       categorypageobj.GotoFirstProductDetails();


    }

    @Test
    public void Goto_Product_Details_Page() throws InterruptedException {
        ProductDetailpage productDetailpageobj=new ProductDetailpage(driver);
        detail_price= productDetailpageobj.GetPrice();
        detail_title=productDetailpageobj.GetProductName();
        //Add Quantity
        productDetailpageobj.AddQuantity();
        //Compare
        Assert.assertEquals(get_display_title,detail_title);
        Assert.assertEquals(get_display_price,detail_price);

        //Used javascript executer to click on add to basket -- element not interactable exception

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"product-actions-btn-add\").click()");
        Thread.sleep(1000);
        productDetailpageobj.goToCart();

    }

    @Test
    public void Goto_Cart_Page() throws InterruptedException {
    CartPage cartPageobj=new CartPage(driver);
    cartPageobj.RemoveFromCart();
    cartPageobj.StartShopping();
}

}
