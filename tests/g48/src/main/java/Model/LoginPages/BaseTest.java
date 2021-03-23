package Model.LoginPages;

import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    public BaseTest(WebDriver driver){
        this.driver = driver;
    }

}
