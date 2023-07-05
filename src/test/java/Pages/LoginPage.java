package Pages;

import Base.BaseTest;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(className = "radius")
    public WebElement logInButton;

    //-----------------------------------

    public void enterUsername(String username){
        usernameField.clear ();
        usernameField.sendKeys (username);
    }

    public void enterPassword(String password){
        passwordField.clear ();
        passwordField.sendKeys (password);
    }

    public void clickOnLoginButton(){
        logInButton.click ();
    }
}
