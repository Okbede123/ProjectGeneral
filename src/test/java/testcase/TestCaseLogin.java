package testcase;

import actions.pageobject.HomePageObject;
import actions.pageobject.LoginPageObject;
import actions.pageobject.MyAccountPageObject;
import actions.pageobject.PageGeneralManager;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestCaseLogin extends BaseTest {

    WebDriver driver;
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        homePageObject = PageGeneralManager.openHomePage(driver);

    }

    @Test
    public void TC_01_LoginWithEmptyEmail(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_LoginWithEmptyEmail");
        ExtentManager.getTest().log(Status.INFO,"Login with empty email");
        loginPageObject = homePageObject.clickToLogin();
        loginPageObject.clickToButton("Log in");
        Assert.assertEquals(loginPageObject.getTextErrorMessage("Please enter your email"),"Please enter your email");
    }

    @Test
    public void TC_02_LoginWithWrongEmail(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_LoginWithEmptyEmail");
        ExtentManager.getTest().log(Status.INFO,"Login with wrong email");
        loginPageObject.inputToTextBox("Email","asdasd");
        loginPageObject.clickToButton("Log in");
        Assert.assertEquals(loginPageObject.getTextErrorMessage("Wrong email"),"Wrong email");
    }

    @Test
    public void TC_03_LoginWithEmailUnsuccessful(Method method){
        ExtentManager.startTest(method.getName(),"TC_03_LoginWithEmailUnsuccessful");
        ExtentManager.getTest().log(Status.INFO,"Login with unsuccessful email");
        loginPageObject.inputToTextBox("Email","asdasd@gmail.com");
        loginPageObject.clickToButton("Log in");
        Assert.assertEquals(loginPageObject.getTextEmailUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void TC_04_LoginWithEmailAndEmptyPass(Method method){
        ExtentManager.startTest(method.getName(),"TC_04_LoginWithEmailAndEmptyPass");
        ExtentManager.getTest().log(Status.INFO,"Login with email correct and empty password");
        loginPageObject.inputToTextBox("Email","okbede123@gmail.com");
        loginPageObject.clickToButton("Log in");
        Assert.assertEquals(loginPageObject.getTextEmailUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_05_LoginWithEmailAndWrongPass(Method method){
        ExtentManager.startTest(method.getName(),"TC_05_LoginWithEmailAndWrongPass");
        ExtentManager.getTest().log(Status.INFO,"Login with email correct and wrong password");
        loginPageObject.inputToTextBox("Email","okbede123@gmail.com");
        loginPageObject.clickToButton("Log in");
        Assert.assertEquals(loginPageObject.getTextEmailUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_06_LoginSuccessful(Method method){
        ExtentManager.startTest(method.getName(),"TC_05_LoginWithEmailAndWrongPass");
        ExtentManager.getTest().log(Status.INFO,"Login with email correct and wrong password");
        loginPageObject.inputToTextBox("Email","okbede123@gmail.com");
        loginPageObject.inputToTextBox("Password","123123");
        loginPageObject.clickToButton("Log in");
        Assert.assertTrue(loginPageObject.isElementTagA_Display("My account"));
    }

    @AfterMethod
    public void afterMethod(){

        if(!loginPageObject.isElementNotDisplay("My account")){
            myAccountPageObject = loginPageObject.clickToMyAccount();
        }
        else {
            loginPageObject.clickToLogin();
        }

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
