package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.Constants;

public class Dashboard {

	public static void clickDashboard(WebDriver driver) {
		driver.findElement(By.xpath(Constants.DASHBOARDBTN_XPATH)).click();
	}
	
	public static void clickShiftPlanning(WebDriver driver) {
		driver.findElement(By.xpath(Constants.SHIFTPLANNINGBTN_XPATH)).click();
	}
	
	public static void clickTimeClock(WebDriver driver) {
		driver.findElement(By.xpath(Constants.TIMECLOCKBTN_XPATH)).click();
	}
	
	public static void clickLeave(WebDriver driver) {
		driver.findElement(By.xpath(Constants.LEAVEBTN_XPATH)).click();
	}
	
	public static void clickTraining(WebDriver driver) {
		driver.findElement(By.xpath(Constants.TRAININGBTN_XPATH)).click();
	}
	
	public static void clickStaff(WebDriver driver) {
		driver.findElement(By.xpath(Constants.STAFFBTN_XPATH)).click();
	}
	
	public static void clickAvailability(WebDriver driver) {
		driver.findElement(By.id(Constants.AVAILABILITYBTN_ID)).click();
	}
	
	public static void clickPayroll(WebDriver driver) {
		driver.findElement(By.xpath(Constants.PAYROLLBTN_XPATH)).click();
	}
	
	public static void clickReports(WebDriver driver) {
		driver.findElement(By.xpath(Constants.REPORTSBTN_XPATH)).click();
	}
	
	public static void clickSettings(WebDriver driver) {
		driver.findElement(By.xpath(Constants.SETTINGSBTN_XPATH)).click();
	}
	public static void clickLogo(WebDriver driver) {
		driver.findElement(By.xpath(Constants.LOGO_XPATH)).click();
	}
	
}
