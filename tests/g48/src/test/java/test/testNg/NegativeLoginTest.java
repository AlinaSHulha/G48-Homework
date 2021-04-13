package test.testNg;

import Model.LoginPages.LoginPage;
import Model.Pages.issues.IssueCreationPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class NegativeLoginTest extends BaseTest {

    private LoginPage loginPage;
    private final String username;
    private final String password;
    private Object IssueCreationPage;

    public NegativeLoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Before
    public void setUp() {
        loginPage = new LoginPage(driver);
    }


    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> result = new ArrayList<>();
        List<String> dataFromExcel =
                readFile(getProperty("user.dir") + "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/testData/Document");
        for (String line : dataFromExcel) {
            String[] temp = line.split(";");
            result.add(new Object[]{Arrays.asList(temp[0], temp[1].split(";"))});
        }
        return result;
    }

    @Test
    public void checkNegativeLogin() {
        loginPage.login(this.username, this.password);
        loginPage.validateErrorMessage("Incorrect username or password.");
    }
}

