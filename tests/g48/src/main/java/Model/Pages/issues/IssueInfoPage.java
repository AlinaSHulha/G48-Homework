package Model.Pages.issues;


import Model.BaseProjectPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class IssueInfoPage extends BaseProjectPage {
    private static final String title = "Страница задачи";


    public IssueInfoPage(WebDriver driver) {
        super(driver, title);
    }

    private final By titleOnPage = By.xpath("//span[@class = 'js-issue-title markdown-title']");
    private final By body = By.xpath("//td[@class = 'd-block comment-body markdown-body  js-comment-body']");

    private final By labels = By.xpath("//a[@class = 'IssueLabel hx_IssueLabel d-inline-block v-align-middle']");

    public IssueInfoPage validateIssue(String expectedTitle, String expectedBody, List<String> expectedLabels) {
        assertEquals(expectedTitle, waitFor10.until(visibilityOf(driver.findElement(titleOnPage))).getText());
        assertEquals(expectedBody, driver.findElement(body).getText());

        List<WebElement> labelsOnPage = driver.findElements(labels);
        List<String> labelsTitles = new ArrayList<>();
        labelsOnPage.forEach(label -> {
            assertTrue(expectedLabels.contains(label.getText()));
            labelsTitles.add(label.getText());
        });
        Assert.assertEquals(expectedLabels, labelsTitles);
        return this;
    }
}