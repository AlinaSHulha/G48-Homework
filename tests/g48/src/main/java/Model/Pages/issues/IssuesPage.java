package Model.Pages.issues;

import Model.BaseProjectPage;
import Model.LoginPages.BaseAuthorizedPage;
import Model.Pages.issues.IssueCreationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends BaseProjectPage {
    private static final String title = "Список задач";


    public IssuesPage(WebDriver driver) {
        super(driver, title);
    }

    private final By newIssueButton = By.xpath("//span[text() = 'New issue']");

    public IssueCreationPage openCreationPage(){
        driver.findElement(newIssueButton).click();
        return new IssueCreationPage(driver);
    }
}


