package actions.pageobject;

import org.openqa.selenium.WebDriver;

public class MyAccountPageObject extends PageNavigationPageObject {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
