package Model.LoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage extends BaseAuthorizedPage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By search = By.xpath("//input[@name = 'q']");
    private By repositoryLink = By.xpath("//div[@aria-label = 'AlinaSHulha/G48-Homework']");

    public ProjectPage openProjectG48(){
        driver.findElement(search).click();
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        return new ProjectPage(driver);
    }


}
