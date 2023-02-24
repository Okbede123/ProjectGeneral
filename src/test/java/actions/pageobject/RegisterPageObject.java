package actions.pageobject;

import interfaceUI.BaseUI;
import interfaceUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends PageNavigationPageObject {
    WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public String getTextErrorMessage(String text){
        if(text.contains("Password must meet the following rules:")){
            return getText(RegisterPageUI.ERROR_MESSAGE_PASS_LESS);
        } else if (text.contains("must have at least 6 characters")) {
            return getText(RegisterPageUI.LESS_THAN_6_CHARACTER);
        }
        return getText(RegisterPageUI.ERROR_MESSAGE,text);
    }

    public String getTextCompleteRegister(){
        return getText(RegisterPageUI.TEXT_REGISTRATION_COMPLETED);
    }

    public String getTextEmailExists(){
        return getText(RegisterPageUI.EMAIL_REGISTER_ALREADY_EXISTS);
    }

    public void selectWithText(String typeOfSelect,String text){
        selectValueWithText(RegisterPageUI.SELECT_ITEMS,text,typeOfSelect);
    }
}
