package MagnetoLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MagnetoWishlist {
    WebDriver driver;
    public MagnetoWishlist(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[text()='Add to Wish List']")
    WebElement wishlist;
    @FindBy(xpath = "//span[text()='Impulse Duffle']/../../following-sibling::div/following-sibling::div/div/button[@type='button']")
    WebElement wishlis;

@FindBy(xpath="//div/div[@data-block='minicart']")
WebElement selectcart;
@FindBy(xpath="//div/div[@class='primary']/button[text()='Proceed to Checkout']")
WebElement checkout;
public void clickonwishlist() throws InterruptedException {
    Thread.sleep(3000);
    wishlist.click();
    Thread.sleep(3000);
    wishlis.click();

   //WebElement msg;
   Assert.assertTrue(driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']")).isDisplayed());
   //System.out.println(msg.getText());

}
public void clickingoncart() throws InterruptedException {
    Thread.sleep(2000);
    selectcart.click();
    Thread.sleep(2000);
    checkout.click();

}
}
