package Model;

import Model.LoginPages.BaseAuthorizedPage;
import Model.Pages.CodePages.CodePage;
import Model.Pages.issues.IssuesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public abstract class BaseProjectPage extends BaseAuthorizedPage{

    public BaseProjectPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private final By codeTab = By.xpath("//span[@data-content = 'Code']");
    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");
    private final By settingsTab = By.xpath("//span[@data-content = 'Settings']");

    public CodePage openSourceCode(){
        driver.findElement(codeTab).click();
        return new CodePage(driver);
    }

    @Step("Открываем вкладку \"Isues\"")
    public IssuesPage openIssues(){
        LOG.info("Открыватся вкладка задач проекта");
        driver.findElement(issuesTab).click();
        LOG.info("Успешно");
        return new IssuesPage(driver);
    }


}
