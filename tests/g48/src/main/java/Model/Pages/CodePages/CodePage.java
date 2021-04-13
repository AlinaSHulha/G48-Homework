package Model.Pages.CodePages;

import Model.BaseProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CodePage extends BaseProjectPage {
    private static final String title = "Основной код";


    public CodePage(WebDriver driver) {
        super(driver, title);
    }

    private final By commitMessageText = By.xpath("//a[@data-test-selector = 'commit-tease-commit-message']");

    public CodePage showCommitMessage(){
        LOG.info(driver.findElements(commitMessageText).get(0).getText());
        return this;
    }

}