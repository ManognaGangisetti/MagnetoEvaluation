package MagnetoLogin;

//import JsonFile.ReadData;
import com.CommonMethod.SeleniumActions;
import com.ReaddatafromFile.ReadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.text.ParseException;



import com.CommonMethod.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class ShippingAddressPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    ReadData readfromfile;

    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
        readfromfile = new ReadData();
    }

    @FindBy(xpath = "//input[@ name='street[0]']")
    WebElement addressline1;
    @FindBy(xpath = "//input[@ name='street[1]']")
    WebElement addressline2;
    @FindBy(xpath = "//input[@ name='street[2]']")
    WebElement addressline3;
    @FindBy(xpath = "//input[@ name='city']")
    WebElement citytextfield;
    @FindBy(xpath = "//select[@ name='region_id']")
    WebElement statedropdown;
    @FindBy(xpath = "//input[@ name='postcode']")
    WebElement postcodetextfield;
    @FindBy(xpath = "//select[@ name='country_id']")
    WebElement countrydropdown;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumbertextfield;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//button[@title='Place Order']/span")
    WebElement placeorder;

    @FindBy(xpath = "//a[@class='order-number']")
    WebElement orderid;

    @FindBy(xpath = "//h1[@class='page-title']/span[@class='base']")
    WebElement verifyorderid;

    public void fillShippingAddress() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        seleniumActions.EnterValueOnTextfield(addressline1, readfromfile.readFile("address1"));
        seleniumActions.EnterValueOnTextfield(addressline2, readfromfile.readFile("address2"));
        seleniumActions.EnterValueOnTextfield(addressline3, readfromfile.readFile("address3"));
        seleniumActions.EnterValueOnTextfield(citytextfield, readfromfile.readFile("city"));
        // Thread.sleep(1000);
        seleniumActions.selectValueFromDropDown(countrydropdown, readfromfile.readFile("countryvalue"), "value");
        seleniumActions.selectValueFromDropDown(statedropdown, readfromfile.readFile("statevalue"), "value");
        seleniumActions.EnterValueOnTextfield(postcodetextfield, readfromfile.readFile("postcode"));
        seleniumActions.EnterValueOnTextfield(phonenumbertextfield, readfromfile.readFile("phone"));
    }

    public void clickONNext() throws InterruptedException {
        Thread.sleep(5000);
        seleniumActions.clickOnElement(nextButton);
    }

    public void clickONPlaceorder() throws InterruptedException {
        Thread.sleep(3000);
        seleniumActions.javascriptExcecutorClick(placeorder);
    }

    public void orderID() throws InterruptedException {
        Assert.assertTrue(orderid.isDisplayed());
        System.out.println(orderid.getText());
        Thread.sleep(2000);
        seleniumActions.clickOnElement((orderid));
    }

    public void orderidVerify()
    {
        Assert.assertTrue(verifyorderid.isDisplayed());
        System.out.println("My order id is verified");
    }
}


