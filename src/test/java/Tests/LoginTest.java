package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public String validUsername;
    public String validPassword;



    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        loginPage = new LoginPage ();
        profilePage = new ProfilePage ();
        validUsername = excelReader.getStringData ("Credentials", 1, 0);
        validPassword = excelReader.getStringData ("Credentials", 1, 1);
        driver.get (homeURL);

    }

    @Test(priority = 10)
    public void userCanLogIn(){
        homepagePage.goOnLoginPage ();
        loginPage.enterUsername (validUsername);
        loginPage.enterPassword (validPassword);
        loginPage.clickOnLoginButton ();
        Assert.assertTrue (profilePage.message.isDisplayed ());
        Assert.assertTrue (profilePage.logoutButton.isDisplayed ());
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername(){
        driver.manage ().deleteAllCookies ();
        homepagePage.goOnLoginPage ();
        for (int i = 1; i <= excelReader.getLastRow ("Credentials"); i++) {
            loginPage.enterUsername (excelReader.getStringData ("Credentials", i, 2));
            loginPage.enterPassword (validPassword);
            loginPage.clickOnLoginButton ();
            Assert.assertTrue (profilePage.message.isDisplayed ());
            Assert.assertEquals (driver.getCurrentUrl (), loginUrl);
        }
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword(){
        driver.manage ().deleteAllCookies ();
        homepagePage.goOnLoginPage ();
        loginPage.enterUsername (validUsername);
        for (int i = 1; i <= excelReader.getLastRow ("Credentials"); i++) {
            loginPage.enterPassword (excelReader.getStringData ("Credentials", i, 3));
            loginPage.clickOnLoginButton ();
            Assert.assertTrue (profilePage.message.isDisplayed ());
            Assert.assertEquals (driver.getCurrentUrl (), loginUrl);
        }
    }



}
