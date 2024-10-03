package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import objectRepository.loginPage;

public class baseclass {
	WebDriver driver;
	loginPage loginPage;
	
	public void login(WebDriver driver, String username, String password) {
		loginPage= new loginPage(driver);
		loginPage.getUsername(username);
		loginPage.getPassword(password);
		loginPage.clickLogin();
	}

}
