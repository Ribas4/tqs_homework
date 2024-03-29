package tqs_hw;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Before
  public void setUp() throws Exception {
    // TODO: fix webdriver
    System.setProperty("webdriver.chrome.driver", "/home/hjmmanso/cmd/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCurrentTestCase() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("location")).click();
    driver.findElement(By.name("location")).clear();
    driver.findElement(By.name("location")).sendKeys("Aveiro");
    driver.findElement(By.xpath("//button[@value='current']")).click();
  }

  @Test
  public void testForecastTestCase() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("location")).click();
    driver.findElement(By.name("location")).clear();
    driver.findElement(By.name("location")).sendKeys("Aveiro");
    driver.findElement(By.xpath("//button[@value='forecast']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
