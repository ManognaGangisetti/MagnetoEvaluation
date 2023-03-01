package MagnetoLogin;

import com.CommonMethod.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetoLogindetail {
      private WebDriver driver;
SeleniumActions seleniumActions;
    public MagnetoLogindetail(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        seleniumActions=new SeleniumActions(driver);
    }
    @FindBy (css="#email")

    WebElement mail;
    @FindBy(xpath = "//div[@class=\"field password required\"]/div/input[@title=\"Password\"]")
    WebElement password;
    @FindBy(xpath="//div[@class=\"primary\"]/button[@class='action login primary']")
    WebElement signin;

    public void enteringdetails() throws InterruptedException {
        seleniumActions.EnterValueOnTextfield(mail,"manogna.gangisetti@gmail.com");
       Thread.sleep(2000);
        seleniumActions.EnterValueOnTextfield(password,"manu321@");
        Thread.sleep(2000);
    }
    public void login(){
       seleniumActions.clickOnElement(signin);
    }
}
