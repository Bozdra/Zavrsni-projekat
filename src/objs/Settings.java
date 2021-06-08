package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.Constants;

public class Settings {
	
	public static void changeLanguage(WebDriver driver) {
		driver.findElement(By.xpath(Constants.CHOOSELANGBAR_XPATH)).click();
		driver.findElement(By.xpath(Constants.CHOOSESERBIAN_XPATH)).click();
		driver.findElement(By.xpath(Constants.SAVECHANGESBTN_XPATH)).click();
	}
	
	public static void disableNotifications(WebDriver driver) {
		driver.findElement(By.xpath(Constants.EMAILCHECKBOX_XPATH)).click();
		driver.findElement(By.xpath(Constants.SMSCHECKBOX_XPATH)).click();
		driver.findElement(By.xpath(Constants.MOBILEPUSHCHECKBOX_XPATH)).click();
	}
	
	public static void changeTwoAccSettings(WebDriver driver, String workId, String number1, String number2, String number3) { 
		driver.findElement(By.xpath(Constants.ACCOUNTARROW_XPATH)).click();
		driver.findElement(By.xpath(Constants.ACCOUNTSETTINGS_XPATH)).click();
		driver.findElement(By.id(Constants.ACCOUNTWORKID_ID)).sendKeys(workId);
		driver.findElement(By.id(Constants.ACCOUNTPHONE1_ID)).sendKeys(number1);
		driver.findElement(By.id(Constants.ACCOUNTPHONE2_ID)).sendKeys(number2);
		driver.findElement(By.id(Constants.ACCOUNTPHONE3_ID)).sendKeys(number3);
	}
}