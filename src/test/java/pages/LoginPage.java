package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver webDriver;
    WebDriverWait wait;
    public LoginPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }
    public void goToLoginPage() {
        webDriver.get("https://independenttrader.pl/login");
    }
    public void typeLogin(String login) {
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]/form/div[1]/div/input")).sendKeys(login);
    }
    public void typePassword(String password) {
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]/form/div[2]/div/input")).sendKeys(password);
    }
    public VerificationPage clickLoginButton() {
        webDriver.findElement(By.cssSelector("#content > div > div > div.col-md-8 > div.col-md-6 > form > div:nth-child(4) > div.pull-right > div > button")).click();
        return new VerificationPage(webDriver, wait);
    }

}
