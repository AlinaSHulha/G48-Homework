package Model.LoginPages;

import Model.Pages.issues.IssuesPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {
    private static final String title = "Основная страница";

    private final static Logger LOG = LogManager.getLogger();

    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");
    private final By errorMessageText = By.xpath("//div[@class = 'flash flash-full flash-error ']/div");
    private final By profileMenu = By.xpath("//summary[@aria-label = 'View profile and more' ]");
    private static final By code = By.xpath("//span[@data-content = 'Code']");
    private static final By issues = By.xpath("//span[@data-content = 'Issues']");
    private static final By pullRequests = By.xpath("//span[@data-content = 'Pull requests']");
    private static final By actions = By.xpath("//span[@data-content = 'Actions']");
    private static final By projects = By.xpath("//span[@data-content = 'Projects']");
    private static final By wiki = By.xpath("//span[@data-content = 'Wiki']");
    private static final By security = By.xpath("//span[@data-content = 'Security']");
    private static final By insights = By.xpath("//span[@data-content = 'Insights']");
    private static final By settings = By.xpath("//span[@data-content = 'Settings']");


    public LoginPage(WebDriver driver) {
        super(driver, title);
    }

    @Step("Производится авторизация")
    public MainPage login(String username, String password) {
        LOG.info("Авторизация");
        driver.findElement(loginField).sendKeys("AlinaSHulha");
        driver.findElement(passwordField).sendKeys("Richard123789456");
        driver.findElement(submitButton).click();
        LOG.info("Авторизаци успешна");
        return new MainPage(driver, title);
    }

    @Step("Валидируем сообщение об ошибке")
    public LoginPage validateErrorMessage(String errorMessage) {
        waitFor25.until(visibilityOf(driver.findElement(errorMessageText)));
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
        return this;
    }
}