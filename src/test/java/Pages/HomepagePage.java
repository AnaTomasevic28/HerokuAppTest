package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePage extends BaseTest {

    public HomepagePage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(linkText = "Form Authentication")
    public WebElement authenticationLink;

    //---------------------------------------------

    public void goOnLoginPage(){
        authenticationLink.click ();
    }



}
