/*


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class FirstScriptTest {

    @Test
    public void eightComponents() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        textBox.sendKeys("Ousseynou");
        WebElement clickGogle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
        clickGogle.click();
        WebElement subbitButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        subbitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }

}
*/

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.Duration;

public class FirstScriptTest {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest logger;

    @Before
    public void setUp() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/test-output/ExtentReport.html"));
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger = extent.createTest("MyTest");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void eightComponents() {
        try {
            WebElement textBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
            textBox.sendKeys("Ousseynou");
            WebElement clickGogle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
            clickGogle.click();
            WebElement subbitButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
            subbitButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            logger.log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        } catch (Exception e) {
            logger.log(Status.FAIL, MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
            logger.fail(e.getMessage());
        }
    }

    @After
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}

