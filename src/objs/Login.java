package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.Constants;

public class Login {
	
	public static void inputEmail(WebDriver driver, String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public static void inputPass(WebDriver driver, String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public static void clickLoginBtn(WebDriver driver) {
		driver.findElement(By.xpath(Constants.LOGINBTN_XPATH)).click();
	}
}
