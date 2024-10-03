package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By usernameText = By.xpath("//input[@name='username']");
	public By passwordText = By.xpath("//input[@name='password']");
	public By loginButton = By.xpath("//button[@type='submit']");
	
	public By usernameAlertError = By.xpath("//input[@name='username']/../following-sibling::span");
	public By passwordAlertError = By.xpath("//input[@name='password']/../following-sibling::span");
	
	public void getUsername(String username) {
		driver.findElement(usernameText).sendKeys(username);
	}
	
	public void getPassword(String password) {
		driver.findElement(passwordText).sendKeys(password);
	}
	
	public WebElement getUsernameAlertError() {
		return driver.findElement(usernameAlertError);
	}
	
	public WebElement getPasswordAlertError() {
		return driver.findElement(passwordAlertError);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

}
