package test;
import Model.LoginPages.LoginPage;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.getProperty;

public class issueCreationTest extends BaseTest{

    private String titleOnPage;
    private String body;
    private List<String> labels;

    private  LoginPage page;
//    private  List<String> labels = new ArrayList<>();

    @Before
    public void prepareData(){
        this.page = new LoginPage(this.driver);
        labels.add("bug");
        labels.add("question");
        labels.add("documentation");
    }

        @Test
        public void checkIssueCreation(){
            this.page.login(getProperty("AlinaSHulha"), getProperty("Richard123789456"))
                    .openProjectG48()
                    .openIssues()
                    .openCreationPage()
                    .createNewIssue(
                            "Automated Issue Title",
                            "Test body. Please ignore me!", labels)
                    .validateIssue("Automated Issue Title",
                            "Test body. Please ignore me!", labels)
                    .logout();

        }

    }
