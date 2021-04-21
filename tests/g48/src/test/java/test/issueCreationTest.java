package test;

import Model.LoginPages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class issueCreationTest extends BaseTest {

    private final String titleOnPage;
    private final String body;
    private final List<String> labels;

    private LoginPage page;

    public issueCreationTest(List<Object> object) {
        this.body = object.get(1).toString();
        this.titleOnPage = object.get(0).toString();
        this.labels = (List<String>) object.get(2);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        List<String> data = readFile(
                "/Users/alina/Documents/Homework/G48-Homework/tests/g48/src/main/resources/testData/Document");
        Object[][] result = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] temp = line.split(";");
            result[i] = new Object[]{Arrays.asList(temp[0], temp[1],
                    Arrays.stream(temp[2].split(",")).flatMap(Stream::of).collect(Collectors.toList()))};
        }
        return result;
    }

    @Before
    public void prepareData() {
        this.page = new LoginPage(this.driver);
    }


    @Test
    public void checkIssueCreation() {
        this.page.login(getProperty("AlinaSHulha"), getProperty("Richard123789456"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        this.titleOnPage,
                        this.body,
                        this.labels)
                .validateIssue(
                        this.titleOnPage,
                        this.body,
                        this.labels)
                .logout();

    }
}
