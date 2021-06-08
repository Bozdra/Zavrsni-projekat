package tests;
/*a) pocetna strana

Doci do stranice ABOUT US i napraviti screenshot strane
Proveriti da li postojeci user uspesno moze da se loguje
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.Constants;
import objs.Home;
import objs.Login;

public class TestHumanity {
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	

	@Test
	public static void testAboutBtn() throws IOException {
		driver.get(Constants.HOME_URL);
		try {Home.closeAnnouncement(driver);
		Home.closeCookieMsg(driver);
		} catch (ElementNotInteractableException e) {}
		driver.manage().window().maximize();
		
		Home.clickAbout(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("screenshot.png"));
		Assert.assertEquals(driver.getCurrentUrl(), Constants.ABOUT_URL);
		
	}
	@Test (priority = 1)
	public static void testValidLogin() throws IOException {
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.DASHBOARD_XPATH))));
		driver.findElement(By.xpath(Constants.DASHBOARDBTN_XPATH)).click();
		Assert.assertEquals(driver.getCurrentUrl(), Constants.DASHBOARD_URL);
	
		
		
		
	}
}
