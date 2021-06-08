package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Constants;
import objs.Dashboard;
import objs.Home;
import objs.Login;
import objs.Settings;
import objs.Staff;

public class TestSettings {
private static WebDriver driver;
	
	@BeforeClass
	public void loginAndDriver() throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constants.HOME_URL);
		try {Home.closeAnnouncement(driver);
		Home.closeCookieMsg(driver);
		} catch (ElementNotInteractableException e) {}
		driver.manage().window().maximize();
		Home.clickLogin(driver);
		File f = new File("credentials.xlsx");
		InputStream is = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		String email = row.getCell(0).getStringCellValue();
		String pass = row.getCell(1).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.inputEmail(driver, email);
		Login.inputPass(driver, pass);
		Login.clickLoginBtn(driver);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		wb.close();
	}

	
	@Test (priority = 1)
	public static void testChangeLanguage() {
		boolean b = false;
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.SETTINGSBTN_XPATH))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Constants.SETTINGSBTN_XPATH))));
		Dashboard.clickSettings(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.CHOOSELANGBAR_XPATH))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Constants.CHOOSELANGBAR_XPATH))));
		Settings.changeLanguage(driver);
		WebElement confirmMsg = driver.findElement(By.xpath(Constants.CHANGELANGCONFIRMMSG_XPATH));
		wait.until(ExpectedConditions.visibilityOf(confirmMsg));

		if (confirmMsg.isDisplayed()) {
			 b = true;
		} else {
			 b = false;
		}
		Assert.assertTrue(b);
	}
	@Test  (priority = 2)
	public static void testDisableNotifs() {
		boolean b = false;

		Settings.disableNotifications(driver);
		WebElement checkbox = driver.findElement(By.xpath(Constants.EMAILCHECKBOX_XPATH));
		WebElement checkbox1 = driver.findElement(By.xpath(Constants.SMSCHECKBOX_XPATH));
		WebElement checkbox2 = driver.findElement(By.xpath(Constants.MOBILEPUSHCHECKBOX_XPATH));
 
		if (checkbox.isSelected() && checkbox1.isSelected() && checkbox2.isSelected()) {
			 b = true;
		} else {
			 b = false;
		}
	}
	
	@Test  (priority = 3)
	public static void testChangeAccount() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean a = false;
		String workId = "123";
		String num1 = "123";
		String num2 = "456";
		String num3 = "789";
		Settings.changeTwoAccSettings(driver, workId, num1, num2, num3);
		//WebElement parent = driver.findElement(By.xpath(Constants.CHECKEMPLOYEE_XPATH));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(Constants.SAVEEMPLOYEEBTN_NAME))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(Constants.SAVEEMPLOYEEBTN_NAME))));
		js.executeScript("window.scrollBy(2000,0)");
		Staff.clickSaveEmployee(driver);
	
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.CHECKEMPLOYEE_XPATH))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Constants.CHECKEMPLOYEE_XPATH))));
		WebElement check = driver.findElement(By.xpath(Constants.CHECKEMPLOYEE_XPATH));
		check.click();
		
		WebElement homeNum = driver.findElement(By.xpath(Constants.CHECKHOMENUM_XPATH));
		WebElement workId1 = driver.findElement(By.xpath(Constants.CHECKACCWORKID_XPATH));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (homeNum.isDisplayed()&&workId1.isDisplayed()) {
			 a = true;
		} else {
			 a = false;
		}
		
		Assert.assertTrue(a);
		
	}
}
