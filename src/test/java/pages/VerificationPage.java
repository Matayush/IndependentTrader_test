package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class "VerificationPage {
    WebDriver webDriver;
    WebDriverWait wait;
    public VerificationPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }
    public void userLoggedIn() {
        wait.until(ExpectedConditions.urlContains("trader"));
        wait.until(ExpectedConditions.urlToBe("https://independenttrader.pl/"));
        String expectedText = "MOJE KONTO";
        String currentText = webDriver.findElement(By.xpath("//*[@id=\"loginArea\"]/div[2]/a[1]")).getText();
        Assert.assertTrue(currentText.contains(expectedText));
    }
    public void userNotLoggedIn() {
        String expectedText = "LOGOWANIE";
        String currentText = webDriver.findElement(By.cssSelector("section.defaultBg.borderTop.pt20.pb20:nth-child(5) div.container div.row div.col-md-8 div.row div.col-md-12 div.impPost.row div.col-md-12.postDescription div.additionalBarWithoutBorder div.bigTitle.uppBlue > h1:nth-child(1)")).getText();
        Assert.assertTrue(currentText.contains(expectedText));
    }
}
