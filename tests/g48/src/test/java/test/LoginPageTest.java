package test;

import dbModel.Users;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import Model.LoginPages.LoginPage;

@Feature("Positive authorization")
@Story("Github auth")
@Owner("AlinaSHulha")
@Severity(SeverityLevel.NORMAL)
public class LoginPageTest extends BaseTest {



        private LoginPage loginPage;

        @Before
        public void setUp() {
            loginPage = new LoginPage(driver);
        }

        @Test
        public void checkNegativeLogin() {
            Users user = Users.findById(1);
            loginPage.login(
                    user.getString("username"),
                    user.getString("password"));
            loginPage.validateErrorMessage("Incorrect username or password.");
        }


        @Description("Тест нужен чтобы показать последнее сообщение коммита")
        @TmsLink("MR-25")
        @Issues({
                @Issue("MR-26"),
                @Issue("")}
        )
        @DisplayName("Показать сообщение коммита")
        @Test
        public void showCommitMessageTest() {
            loginPage.login(System.getProperty("username"), System.getProperty("password"))
                    .openProjectG48()
                    .showCommitMessage()
                    .logout();
        }
    }




