package objs;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class Staff {
	
	public static void clickAddEmployee(WebDriver driver) {
		driver.findElement(By.xpath(Constants.ADDEMPLOYEEBTNBTN_XPATH)).click();
	}
	public static void inputFirstName(WebDriver driver, String name) {
		driver.findElement(By.xpath(Constants.FIRSTNAMEBAR_XPATH)).sendKeys(name);
	}
	public static void inputLastName(WebDriver driver, String lName) {
		driver.findElement(By.xpath(Constants.LASTNAMEBAR_XPATH)).sendKeys(lName);
	}
	public static void inputEmail(WebDriver driver, String email) {
		driver.findElement(By.xpath(Constants.EMAILBARSTAFF_XPATH)).sendKeys(email);
	}
	public static void saveEmployees(WebDriver driver) {
		driver.findElement(By.id(Constants.SAVEEMPLOYEESBTN_ID)).click();
	}
	public static void selectAllStaff(WebDriver driver) {
		driver.findElement(By.xpath(Constants.SLCTALLSTAFF_XPATH)).click();
	}
	public static void selectEmployeeName(WebDriver driver) {
		driver.findElement(By.xpath(Constants.SLCTEMP_XPATH)).click();
	}
	public static void clickOnEmployee(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)))));
		driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)).click();
	}
	public static void clickEditDetails(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.partialLinkText("Edit Details")))));
		driver.findElement(By.partialLinkText("Edit Details")).click();
	}
	public static void inputFirstNameEdit(WebDriver driver, String name) {
		driver.findElement(By.id(Constants.CHANGEFNAMEBTN_ID)).clear();
		driver.findElement(By.id(Constants.CHANGEFNAMEBTN_ID)).sendKeys(name);
	}
	public static void clickSaveEmployee(WebDriver driver) {
		driver.findElement(By.className(Constants.SAVEEMPLOYEEBTN_NAME)).click();
	}
	public static void uploadPicture(WebDriver driver) {
		driver.findElement(By.id("in-btn")).click();
	}
	}
