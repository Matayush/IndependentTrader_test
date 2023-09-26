import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginSteps {

    WebDriver webDriver;
    WebDriverWait wait;


    @Before
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\BDD\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 3);
    }
    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @And("I go to login page")
    public void iGoToLoginPage() {

        webDriver.get("https://independenttrader.pl/login");
        //Robot robot = new Robot();
        //robot.mouseMove(1750, 1000);
        //robot.mousePress(InputEvent.BUTTON1_MASK);
        //robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @When("I type {string} as login")
    public void iTypeAsLogin(String login) {
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]/form/div[1]/div/input")).sendKeys(login);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String password) {
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]/form/div[2]/div/input")).sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]/form/div[3]/div[2]/div/button")).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        wait.until(ExpectedConditions.urlContains("trader"));
        wait.until(ExpectedConditions.urlToBe("https://independenttrader.pl/"));
        String expectedText = "MOJE KONTO";
        String currentText = webDriver.findElement(By.xpath("//*[@id=\"loginArea\"]/div[2]/a[1]")).getText();
        Assert.assertTrue(currentText.contains(expectedText));
    }

    @Then("I am NOT logged in")
    public void iAmNOTLoggedIn() {
        String expectedText = "LOGOWANIE";
        String currentText = webDriver.findElement(By.cssSelector("section.defaultBg.borderTop.pt20.pb20:nth-child(5) div.container div.row div.col-md-8 div.row div.col-md-12 div.impPost.row div.col-md-12.postDescription div.additionalBarWithoutBorder div.bigTitle.uppBlue > h1:nth-child(1)")).getText();
        Assert.assertTrue(currentText.contains(expectedText));
    }

    @When("I type {string} as login and {string} as password")
    public void iTypeAsLoginAndAsPassword(String login, String password) {
        iTypeAsLogin(login);
        iTypeAsPassword(password);
        iClickLoginButton();
    }
}
