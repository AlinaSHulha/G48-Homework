package Model.Pages;

import Model.LoginPages.BasePage;
import Model.LoginPages.MainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {

    private static WebDriver driver
            ;
    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");
    private final By errorMessageText = By.xpath("//div[@class = 'flash flash-full flash-error ']/div");
    private  final By profileMenu = By.xpath("//summary[@aria-label = 'View profile and more' ]");
    private  final By code = By.xpath("//span[@data-content = 'Code']");
    private  final By issues = By.xpath("//span[@data-content = 'Issues']");
    private  final By pullRequests = By.xpath("//span[@data-content = 'Pull requests']");
    private  final By actions = By.xpath("//span[@data-content = 'Actions']");
    private  final By projects = By.xpath("//span[@data-content = 'Projects']");
    private  final By wiki = By.xpath("//span[@data-content = 'Wiki']");
    private  final By security = By.xpath("//span[@data-content = 'Security']");
    private  final By insights = By.xpath("//span[@data-content = 'Insights']");
    private  final By settings = By.xpath("//span[@data-content = 'Settings']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String username, String password){
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }

    public LoginPage validateErrorMessage(String errorMessage){
        waitFor25.until(visibilityOf(driver.findElement(errorMessageText)));
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
        return this;
    }

    public LoginPage profilMenu() {
        driver.findElement(profileMenu).getText();
        return new LoginPage(driver);
    }

    public LoginPage codeTabs() {
        driver.findElement(code).getText();
        return new LoginPage(driver);
    }

    public LoginPage issuesTabs() {
        driver.findElement(issues).getText();
        return new LoginPage(driver);
    }

    public LoginPage pullRequestsTabs() {
        driver.findElement(pullRequests).getText();
        return new LoginPage(driver);
    }

    public LoginPage actionsTabs() {
        driver.findElement(actions).getText();
        return new LoginPage(driver);
    }

    public LoginPage projectsTabs() {
        driver.findElement(projects).getText();
        return new LoginPage(driver);
    }

    public LoginPage wikiTabs() {
        driver.findElement(wiki).getText();
        return new LoginPage(driver);
    }

    public LoginPage securityTabs() {
        driver.findElement(security).getText();
        return new LoginPage(driver);
    }

    public LoginPage insightsTabs() {
        driver.findElement(insights).getText();
        return new LoginPage(driver);
    }

    public LoginPage settingsTabs() {
        driver.findElement(settings).getText();
        return new LoginPage(driver);
    }
}


