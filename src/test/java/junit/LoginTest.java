package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.VerificationPage;

public class LoginTest {
    WebDriver webDriver;
    WebDriverWait wait;
    LoginPage loginPage;
    VerificationPage verificationPage;

    @Before
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\BDD\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 3);
        webDriver.get("https://independenttrader.pl/login");
        loginPage = new LoginPage(webDriver, wait);
    }
    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @Test
    public void correctCredentialsTest() {
        loginPage.goToLoginPage();
        loginPage.typeLogin("mceniuk@hotmail.com");
        loginPage.typePassword("qwerty@");
        verificationPage = loginPage.clickLoginButton();
        verificationPage.userLoggedIn();
    }
    @Test
    public void incorrectCredentialsTest(){
        loginPage.goToLoginPage();
        loginPage.typeLogin("adfgrf");
        loginPage.typePassword("IncorrectCredentials");
        verificationPage = loginPage.clickLoginButton();
        verificationPage.userNotLoggedIn();
    }
}