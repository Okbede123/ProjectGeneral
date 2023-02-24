package testcase;

import actions.pageobject.HomePageObject;
import actions.pageobject.PageGeneralManager;
import actions.pageobject.RegisterPageObject;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.DataHelper;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class RegisterFail extends BaseTest {
    WebDriver driver;
    HomePageObject homePageObject;
    RegisterPageObject registerPageObject;
    String password = "123123";
    String email = new DataHelper().getEmail();

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        homePageObject = PageGeneralManager.openHomePage(driver);
    }

    @Test
    public void TC_01_AssertErrorMessage(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_AssertErrorMessage");
        ExtentManager.getTest().log(Status.INFO,"VerifyMessageError");
        registerPageObject = homePageObject.clickToRegister();
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("First name is required."),"First name is required.");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("Last name is required."),"Last name is required.");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("Email is required."),"Email is required.");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("Password is required."),"Password is required.");
    }

    @Test
    public void TC_02_AssertWrongEmail(Method method){
        ExtentManager.startTest(method.getName(),"TC_02_AssertWrongEmail");
        ExtentManager.getTest().log(Status.INFO,"VerifyMessageErrorWrongEmail");
        registerPageObject.inputToTextBox("Email","okbede");
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("Wrong email"),"Wrong email");
    }

    @Test
    public void TC_03_SuccessfullyRegister(Method method){
        ExtentManager.startTest(method.getName(),"TC_03_SuccessfullyRegister");
        ExtentManager.getTest().log(Status.INFO,"SuccessfullyRegister");
        registerPageObject.inputToTextBox("FirstName",new DataHelper().getFirstName());
        registerPageObject.inputToTextBox("LastName",new DataHelper().getLastName());
        registerPageObject.selectWithText("DateOfBirthDay","22");
        registerPageObject.selectWithText("DateOfBirthMonth","May");
        registerPageObject.selectWithText("DateOfBirthYear","1995");
        registerPageObject.inputToTextBox("Email",email);
        registerPageObject.inputToTextBox("Password",password);
        registerPageObject.inputToTextBox("ConfirmPassword",password);
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextCompleteRegister(),"Your registration completed");
    }

    @Test
    public void TC_04_EmailAlreadyExists(Method method){
        ExtentManager.startTest(method.getName(),"TC_04_EmailAlreadyExists");
        ExtentManager.getTest().log(Status.INFO,"VerifyMessageAlreadyExists");
        registerPageObject.inputToTextBox("FirstName",new DataHelper().getFirstName());
        registerPageObject.inputToTextBox("LastName",new DataHelper().getLastName());
        registerPageObject.selectWithText("DateOfBirthDay","22");
        registerPageObject.selectWithText("DateOfBirthMonth","May");
        registerPageObject.selectWithText("DateOfBirthYear","1995");
        registerPageObject.inputToTextBox("Email",email);
        registerPageObject.inputToTextBox("Password",password);
        registerPageObject.inputToTextBox("ConfirmPassword",password);
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextEmailExists(),"The specified email already exists");

    }

    @Test
    public void TC_05_RegisterWithPasswordLeastThan6Characters(Method method){
        ExtentManager.startTest(method.getName(),"TC_05_RegisterWithPasswordLeastThan6Characters");
        ExtentManager.getTest().log(Status.INFO,"Check password less than 6 character");
        registerPageObject.inputToTextBox("FirstName",new DataHelper().getFirstName());
        registerPageObject.inputToTextBox("LastName",new DataHelper().getLastName());
        registerPageObject.selectWithText("DateOfBirthDay","22");
        registerPageObject.selectWithText("DateOfBirthMonth","May");
        registerPageObject.selectWithText("DateOfBirthYear","1995");
        registerPageObject.inputToTextBox("Email",email);
        registerPageObject.inputToTextBox("Password","123");
        registerPageObject.inputToTextBox("ConfirmPassword","123");
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("Password must meet the following rules:"),"Password must meet the following rules:");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("must have at least 6 characters"),"mus t have at least 6 characters");
    }

    @Test
    public void TC_06_RegisterWithPasswordAndConfirmPassNotMatch(Method method){
        ExtentManager.startTest(method.getName(),"TC_06_RegisterWithPasswordAndConfirmPassNotMatch");
        ExtentManager.getTest().log(Status.INFO,"Password and confirm pass not match");
        registerPageObject.inputToTextBox("FirstName",new DataHelper().getFirstName());
        registerPageObject.inputToTextBox("LastName",new DataHelper().getLastName());
        registerPageObject.selectWithText("DateOfBirthDay","22");
        registerPageObject.selectWithText("DateOfBirthMonth","May");
        registerPageObject.selectWithText("DateOfBirthYear","1995");
        registerPageObject.inputToTextBox("Email",email);
        registerPageObject.inputToTextBox("Password","1234567");
        registerPageObject.inputToTextBox("ConfirmPassword","12345677");
        registerPageObject.clickToButton("Register");
        Assert.assertEquals(registerPageObject.getTextErrorMessage("The password and confirmation password do not match."),"The password and confirmation password do not match.");
    }

    @AfterMethod
    public void afterMethod(){
        registerPageObject.clickToRegister();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
        //closeBrowserDriver();
    }
}
