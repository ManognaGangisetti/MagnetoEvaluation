package MagnetoLogin;

import com.CommonMethod.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagnetoHomepage {
    private WebDriver driver;
    SeleniumActions seleniumActions;

    public MagnetoHomepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gear;
@FindBy(xpath = "//span[text()='Bags']")
WebElement bags;
    public void getprice() {

        String price = "74.00";
    }
//@FindBy(xpath="//ol[@class=\"products list items product-items\"]/li[@class=\"item product product-item\"]/div/a/following::div/strong/a[@class=\"product-item-link\"]/../following::div[@class=\"price-box price-final_price\"]/span/span/span[text()='$74.00']/../../../../../div[@class=\"product details product-item-details\"]/parent::div[@data-container=\"product-grid\"]")
WebElement price1;
    public void clickongear() {
        Actions actions = new Actions(driver);
        actions.moveToElement(gear);
         actions.perform();
        actions.moveToElement(bags).click().perform();
    }


    public void pricelist(){


            List<WebElement> listofallprices = new ArrayList<WebElement>();
              listofallprices = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li[8]/div/a/following-sibling::div/strong/following-sibling::div[2]/span/span/span[text()='$74.00']"));
              List<Double> allproductsamount = new ArrayList<>();
              for (WebElement webElement : listofallprices)
              {
                  allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
              }
              System.out.println(Collections.max(allproductsamount));
              Double maxproductamount = Collections.max(allproductsamount);
              System.out.println("max amount" + maxproductamount);
              WebElement maxprodamountprice = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+maxproductamount+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
              System.out.println(maxprodamountprice.getText());
              maxprodamountprice.click();
              //  Thread.sleep(2000);
         }
        public void addToWishList()
        {

            seleniumActions.clickOnElement(bags);
    }

}

