package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constants.Constants;

public class Home {

	public static void clickAbout(WebDriver driver) {
		
		/*WebElement about = driver.findElement(By.xpath(Constants.ABOUT_XPATH));
		Actions a = new Actions(driver);
		a.moveToElement(about);*/
		driver.findElement(By.xpath(Constants.ABOUTBTN_XPATH)).click();
	} 
	
	public static void closeAnnouncement(WebDriver driver) {
		driver.findElement(By.xpath(Constants.CLOSEMSSGBTN_XPATH)).click();
	}
	
	public static void closeCookieMsg(WebDriver driver) {
		driver.findElement(By.xpath(Constants.CLOSECOOKIEMSG_XPATH)).click();
	}
	public static void clickLogin(WebDriver driver) {
		driver.findElement(By.xpath(Constants.LOGINPAGEBTN_XPATH)).click();
	}
}
