package test;

import org.junit.Before;
import org.junit.Test;
import Model.Pages.LoginPage;
import org.openqa.selenium.WebDriver;


public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;

    public LoginPageTest(WebDriver driver) {
        super(driver);

    }

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkNegativeLogin(){
        loginPage.login("AlinaSHulha","1243asdsxx");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Test
    public void showCommitMessageTest(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }




}
