package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.BeforeMethod;

public class ButtonsTest extends BaseTest {

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
}
