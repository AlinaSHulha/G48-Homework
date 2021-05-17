package test;

import dbModel.Users;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.javalite.activejdbc.DB;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import Model.LoginPages.LoginPage;

import java.util.Date;

import static helpers.DbHelper.executeQuery;

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

//        @Test
//        public void checkNegativeLogin(){
//            Users user = Users.findById(1);
//            loginPage.login(
//                    user.getString("username"),
//                    user.getString("password"));
//            loginPage.validateErrorMessage("Incorrect username or password.");
//        }


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

    @Ignore("Потому что нет соедения с базой")
    @Test
    public void checkDbTest(){
        new DB("study")
                .open(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://localhost:5432/study",
                        "postgres",
                        "postgres");
        //create
        new Users()
                .set("username", "test")
                .set("password", "test")
                .saveIt();
        //read
        System.out.println(
                Users.findFirst("username = ?", "admin"));
        //update
        Users.findFirst("username = ?", "admin")
                .set("password", String.valueOf(new Date().getTime()))
                .saveIt();

        //delete
        Users.findFirst("username = ?", "test").delete();

        //delete from users where id = 3
        // System.out.println(Users.findById(1));

        new DB("study").close();
    }

    // @Test
    public void checkDbQuery(){
        /*
        String login = executeQueryWithResult(
                "select * from data.users where id = 1",
                "username").get(0).toString();
        String password = executeQueryWithResult(
                "select * from data.users where id = 1",
                "password").get(0).toString();
       System.out.println("Login: "+ login+" Password: " + password);

         */
        executeQuery("delete from data.users where id = 5");
    }

}




