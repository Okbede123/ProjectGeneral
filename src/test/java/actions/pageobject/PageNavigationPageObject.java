package actions.pageobject;

import cores.commons.BasePage;
import interfaceUI.BaseUI;
import org.openqa.selenium.WebDriver;

public class PageNavigationPageObject extends BasePage {
    WebDriver driver;
    String Register = "Register";
    String Login = "Log in";
    String MyAccount = "My account";
    public PageNavigationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject clickToRegister(){
        clickToElements(BaseUI.HEADER_HOMEPAGE,Register);
        return PageGeneralManager.openRegisterPage(driver);
    }

    public void inputToTextBox(String nameTextBox,String value){
        sendKeys(BaseUI.INPUT_WITH_ATTRIBUTE_NAME,value,nameTextBox);
    }

    public void clickToButton(String nameButton){
        clickToElements(BaseUI.BUTTON,nameButton);
    }

    public LoginPageObject clickToLogin(){
        clickToElements(BaseUI.HEADER_HOMEPAGE,Login);
        return PageGeneralManager.openLoginPage(driver);
    }

    public MyAccountPageObject clickToMyAccount(){
        clickToElements(BaseUI.HEADER_HOMEPAGE,MyAccount);
        return PageGeneralManager.openMyAccount(driver);
    }

    public boolean isElementTagA_Display(String nameElement){
       return isElementDisplay(BaseUI.HEADER_HOMEPAGE,nameElement);
    }

    public boolean isElementNotDisplay(String nameElement){
        return isElementNotDisplay(BaseUI.HEADER_HOMEPAGE,nameElement);
    }


}
