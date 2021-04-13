package Model.LoginPages;

import Model.Pages.issues.IssuesPage;
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

//    public void homeTabs() {
//    }

    public MainPage login(String username, String password){
        LOG.info("Авторизация");
        driver.findElement(loginField).sendKeys("AlinaSHulha");
        driver.findElement(passwordField).sendKeys("Richard123789456");
        driver.findElement(submitButton).click();
        LOG.info("Авторизаци успешна");
        return new MainPage(driver, title);
    }

    public LoginPage validateErrorMessage(String errorMessage){
        waitFor25.until(visibilityOf(driver.findElement(errorMessageText)));
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
        return this;
    }
}

//    public LoginPage profilMenu() {
//        driver.findElement(profileMenu).getText();
//        return new LoginPage(driver) }


//            public void homeTabs() {
//                String codeText = driver.findElement(code).getText();
//                LOG.info(codeText);
//
//                String issuesText = driver.findElement(issues).getText();
//                LOG.info(issuesText);
//
//                String pullRequestText = driver.findElement(pullRequests).getText();
//                LOG.info(pullRequestText);
//
//                String actionsText = driver.findElement(actions).getText();
//                LOG.info(actionsText);
//
//                String projectsText = driver.findElement(projects).getText();
//                LOG.info(projectsText);
//
//                String wikiText = driver.findElement(wiki).getText();
//                LOG.info(wikiText);
//
//                String securityText = driver.findElement(security).getText();
//                LOG.info(securityText);
//
//                String insightsText = driver.findElement(insights).getText();
//                LOG.info(insightsText);
//
//                String settingsText = driver.findElement(settings).getText();
//                LOG.info(securityText);
//            }