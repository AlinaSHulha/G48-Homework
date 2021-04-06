package test;

import Model.Pages.issues.IssuesPage;
import org.junit.Before;
import org.junit.Test;
import Model.LoginPages.LoginPage;

public class LoginPageTest extends BaseTest{


    private LoginPage loginPage;

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
        loginPage.login(System.getProperty("AlinaSHulha"), System.getProperty("Richard123789456"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }
}
//    @Test
//    public void readTab(){
//        loginPage.login("AlinaSHulha","Richard123789456")
//                .openProjectG48();
//        LoginPage.homeTabs();
//    }




