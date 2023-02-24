package testcase;

import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

public class Testcase extends BaseTest {

    WebDriver driver;

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){

        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
    }

    @Test
    public void TC_01(Method method){
        ExtentManager.startTest(method.getName(),"TC_01");
        ExtentManager.getTest().log(Status.INFO,"start test");
        System.out.println("test");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
