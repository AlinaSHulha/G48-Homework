package test;

import org.junit.Before;
import org.junit.Test;
import Model.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;
    private Object log;


    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkNegativeLogin(){
        loginPage.login("AlinaSHulha","Richard123789456");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }
    @Test
    public void showCommitMessageTest(){
        loginPage.login("AlinaSHulha","Richard123789456")
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }
    @Test
    public void readTab(){
        loginPage.login("AlinaSHulha","Richard123789456")
                .openProjectG48();
        LoginPage.homeTabs();
    }




}
