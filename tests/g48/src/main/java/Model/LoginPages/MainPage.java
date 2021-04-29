package Model.LoginPages;

import Model.Pages.CodePages.CodePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage extends BaseAuthorizedPage{

    private static final String title = "Основная страница";
    public MainPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private By search = By.xpath("//input[@name = 'q']");
    private By repositoryLink = By.xpath("//div[@aria-label = 'AlinaSHulha/G48-Homework']");

    @Step("Открываем проект G48Automation")
    public CodePage openProjectG48(){
        driver.findElement(search).click();
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        LOG.info("Успешно");
        return new CodePage(driver);
    }


}
