package Model.LoginPages;
import Model.Pages.CodePages.CodePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage extends BaseAuthorizedPage{

    private static final String title = "Основная страница приложения";

    public MainPage(WebDriver driver, String title) {
        super(driver, title);
    }


    private final By search = By.xpath("//input[@name = 'q']");
    private final By repositoryLink = By.xpath("//div[@aria-label = 'AlinaSHulha/G48-Homework']");

    @Step("Открываем проект G48Automation")
    public CodePage openProjectG48(){
        LOG.info("Открывается страница проекта G48Automation");
       waitFor10.until(elementToBeClickable(search)).click(); ;
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        LOG.info("Успешно");
        return new CodePage(driver);
    }
}

