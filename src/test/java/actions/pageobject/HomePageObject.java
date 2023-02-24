package actions.pageobject;

import org.openqa.selenium.WebDriver;

public class HomePageObject extends PageNavigationPageObject {
    WebDriver driver;
    ;
    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
