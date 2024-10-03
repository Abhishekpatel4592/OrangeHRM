package OrangeHRM.OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import objectRepository.*;
import utils.baseclass;

public class LoginTest extends baseclass{
	
	WebDriver driver;
	loginPage loginPage;
	ChromeOptions options = new ChromeOptions();
	
	@BeforeMethod
	public void setUpBrowser() throws InterruptedException {
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void validLoginTest() throws InterruptedException {
		login(driver,"Admin","admin123");
		Thread.sleep(4000);
		WebElement headerLandingPage = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']"));
		headerLandingPage.isDisplayed();
	}
	
	@Test
	public void inValidLoginTest() throws InterruptedException {
		login(driver,"Test","Test");
		Thread.sleep(4000);
		WebElement incorrectPasswordAlert = driver.findElement(By.xpath("//div[contains(@class,'oxd-alert')][@role='alert']"));
		incorrectPasswordAlert.isDisplayed();
	}
	
	@Test
	public void inValidUsername() throws InterruptedException {
		loginPage = new loginPage(driver);
		loginPage.getUsername(" ");
		loginPage.getUsernameAlertError().isDisplayed();
	}
	
	@Test
	public void inValidPassword() throws InterruptedException {
		loginPage = new loginPage(driver);
		loginPage.getUsername("Admin");
		loginPage.getPassword(" ");
		loginPage.getPasswordAlertError().isDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
