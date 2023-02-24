package actions.pageobject;

import cores.commons.BasePage;
import cores.commons.BaseTest;
import interfaceUI.LoginPageUI;
import interfaceUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends PageNavigationPageObject {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTextErrorMessage(String text){
        return getText(RegisterPageUI.ERROR_MESSAGE,text);
    }


    public String getTextEmailUnsuccessful(){
        return getText(LoginPageUI.LOGIN_WITH_UNSUCCESSFUL);
    }

}
