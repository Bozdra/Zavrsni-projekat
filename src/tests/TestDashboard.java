package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.Constants;
import objs.Dashboard;
import objs.Home;
import objs.Login;

public class TestDashboard {
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
	public static void testLogo() {
		Dashboard.clickTimeClock(driver);
		Dashboard.clickLogo(driver);
		Assert.assertEquals(driver.getCurrentUrl(), Constants.DASHBOARD_URL);
	}
	
	@Test (priority = 2)
	public static void testDashboard() {
		Dashboard.clickDashboard(driver);
		Assert.assertEquals(driver.getTitle(), Constants.DASHBOARD_TITLE);
	}
	
	@Test (priority = 3)
	public static void testShiftPlanning() {
		Dashboard.clickShiftPlanning(driver);
		Assert.assertEquals(driver.getTitle(), Constants.SHIFTPLANNING_TITLE);
	}
	
	@Test (priority = 4)
	public static void testTimeClock() {
		Dashboard.clickTimeClock(driver);
		Assert.assertEquals(driver.getTitle(), Constants.TIMECLOCK_TITLE);
	}
	
	@Test (priority = 5)
	public static void testLeave() {
		Dashboard.clickLeave(driver);
		Assert.assertEquals(driver.getTitle(), Constants.LEAVE_TITLE);
	}
	
	@Test (priority = 6)
	public static void testTraining() {
		Dashboard.clickTraining(driver);
		Assert.assertEquals(driver.getTitle(), Constants.TRAINING_TITLE);
	}
	
	@Test (priority = 7)
	public static void testStaff() {
		Dashboard.clickStaff(driver);
		Assert.assertEquals(driver.getTitle(), Constants.STAFF_TITLE);
	}
	
	@Test (priority = 8)
	public static void testAvailability() {
		Dashboard.clickAvailability(driver);
		Assert.assertEquals(driver.getTitle(), Constants.AVAILABILITY_TITLE);
	}
	
	@Test (priority = 9)
	public static void testPayroll() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.PAYROLLBTN_XPATH))));
		Dashboard.clickPayroll(driver);
		Assert.assertEquals(driver.getTitle(), Constants.PAYROLL_TITLE);
	}
	
	@Test (priority = 10)
	public static void testReports() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.REPORTSBTN_XPATH))));
		Dashboard.clickReports(driver);
		Assert.assertEquals(driver.getTitle(), Constants.REPORT_TITLE);
	}
	
	@Test (priority = 11)
	public static void testSettings() {
		Dashboard.clickSettings(driver);
		Assert.assertEquals(driver.getTitle(), Constants.SETTINGS_TITLE);
	}
	
}
