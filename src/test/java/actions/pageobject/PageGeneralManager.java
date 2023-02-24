package actions.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {

    public static HomePageObject openHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static RegisterPageObject openRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject openMyAccount(WebDriver driver){
        return new MyAccountPageObject(driver);
    }
}
