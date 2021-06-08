package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constants;
import objs.Dashboard;
import objs.Home;
import objs.Login;
import objs.Staff;

public class TestStaff {
	static WebDriver driver;
	
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
	public static void testAddEmployee() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Dashboard.clickStaff(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.ADDEMPLOYEEBTNBTN_XPATH))));
		Staff.clickAddEmployee(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.EMAILBARSTAFF_XPATH))));
		
		File f = new File("employees.xlsx");
		InputStream is = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		String name = row.getCell(0).getStringCellValue();
		String lName = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();
		
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.FIRSTNAMEBAR_XPATH)))));
		Staff.inputFirstName(driver, name);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.LASTNAMEBAR_XPATH)))));
		Staff.inputLastName(driver, lName);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.EMAILBARSTAFF_XPATH)))));
		Staff.inputEmail(driver, email);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.id(Constants.SAVEEMPLOYEESBTN_ID)))));

		Staff.saveEmployees(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.SLCTALLSTAFF_XPATH)))));
		driver.get(Constants.ALLSTAFF_URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		List <WebElement> empEmails = driver.findElements(By.id(Constants.EMPLOYEEEMAIL_ID));
		List<String> emailString  = new ArrayList<>();
		for (WebElement emails : empEmails) {
			String s = emails.getText();
			String a = s.toString();
			emailString.add(a);   // dodajem email svih radnika na stranici.
		}
		System.out.println(emailString.size());
		List<String> emailsExcel = new ArrayList<String>();
		emailsExcel.add(email);  // dodajem mejl radnika u drugu listu da bi poredio
		
		File f1 = new File("credentials.xlsx");
		InputStream is1 = new FileInputStream(f1);
		XSSFWorkbook wb1 = new XSSFWorkbook(is1);
		Sheet sheet1 = wb1.getSheetAt(0);
		Row row1 = sheet1.getRow(0);
		String emailOfAccount = row1.getCell(0).getStringCellValue(); 
		
		emailsExcel.add(emailOfAccount);   // dodajem mejl od naloga iz eksela kredencijala jer je program uvek nadje
		Collections.sort(emailString);
		Collections.sort(emailsExcel);
		Assert.assertEquals(emailString, emailsExcel);
		wb.close();
		wb1.close();

	}
	
	@Test (priority = 3)
	public static void testChangeEmpName() {
		String newName = "Boris";
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get(Constants.ALLSTAFF_URL);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)))));
		Staff.clickOnEmployee(driver);
		wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.partialLinkText("Edit Details")))));//(Constants.EMPEDITDETBTN_XPATH)))));
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.partialLinkText("Edit Details")))));
		
		Staff.clickEditDetails(driver);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.id(Constants.CHANGEFNAMEBTN_ID)))));
		Staff.inputFirstNameEdit(driver, newName);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.className(Constants.SAVEEMPLOYEEBTN_NAME)))));
		Staff.clickSaveEmployee(driver);
		
		driver.get(Constants.ALLSTAFF_URL);
		String pom = driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)).getText();
		String pom1 = pom.toString();
		
		Assert.assertTrue(pom1.contains(newName));
	}
	
	@Test (priority = 4)
	public static void testUploadPic()  {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get(Constants.ALLSTAFF_URL);
		wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)))));
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.EMPLOYEENAME_XPATH)))));
		Staff.clickOnEmployee(driver);
		wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(Constants.EMPEDITDETBTN_XPATH)))));
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(Constants.EMPEDITDETBTN_XPATH)))));
		
		Staff.clickEditDetails(driver);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.id("in-btn")))));
	
		boolean b = false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement chooseFile = driver.findElement(By.id(Constants.UPLOADPICBTN_ID));
		chooseFile.sendKeys("C:/Users/bozdr/OneDrive/Desktop/Screenshot_7.png");
		
		WebElement confirm = driver.findElement(By.xpath(Constants.UPLOADCONFIRM_XPATH));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(confirm));

		if (confirm.isDisplayed()) {
			 b = true;
		} else {
			 b = false;
		}
		
		Assert.assertTrue(b);
		driver.close();
	} 
	
	@Test (priority = 2)
	public static void testAddEmployees() throws IOException {
		int numEmp = 5;
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Dashboard.clickStaff(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.ADDEMPLOYEEBTNBTN_XPATH))));
		Staff.clickAddEmployee(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Constants.EMAILBARSTAFF_XPATH))));
		
		List<String> emailsExcel = new ArrayList<String>();
		List<String> emailString =  new ArrayList<String>();
		
		File f = new File("employees.xlsx");
		InputStream is = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		
		List<String> listName = new ArrayList<String>();
		List<String> listLName = new ArrayList<String>();
		List<String> listEmail = new ArrayList<String>();
		
		for (int i = 0; i<numEmp; i++) {
			
			Row row = sheet.getRow(i+1);
			String name = row.getCell(0).getStringCellValue();
			String lName = row.getCell(1).getStringCellValue();
			String email = row.getCell(2).getStringCellValue();
			
			listName.add(name);
			listLName.add(lName);
			listEmail.add(email);
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("_asf" + (i+1)))));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("_asl" + (i+1)))));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("_ase" + (i+1)))));

			WebElement nameBar = driver.findElement(By.id(Constants.FIRSTNAMEBAR_ID + (i+1)));
			WebElement lNameBar = driver.findElement(By.id(Constants.LASTNAMEBAR_ID + (i+1)));
			WebElement emailBar = driver.findElement(By.id(Constants.EMAILBARSTAFF_ID + (i+1)));
			
			nameBar.sendKeys(listName.get(i));
			lNameBar.sendKeys(listLName.get(i));
			emailBar.sendKeys(listEmail.get(i));
			
			emailsExcel.add(email);  // dodajem mejl radnika u drugu listu da bi poredio
			
		}
		driver.findElement(By.id(Constants.SAVEEMPLOYEESBTN_ID)).click();
		driver.navigate().to(Constants.ALLSTAFF_URL);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(Constants.EMPLOYEEEMAIL_ID))));

		List <WebElement> empEmails = driver.findElements(By.id(Constants.EMPLOYEEEMAIL_ID));
		
		for (WebElement emails : empEmails) {
			String s = emails.getText();
			String a = s.toString();
			emailString.add(a);   // uzimam sve email svih radnika na humanity stranici i ubacujem ih u listu.
		}
		
		File f1 = new File("credentials.xlsx");
		InputStream is1 = new FileInputStream(f1);
		XSSFWorkbook wb1 = new XSSFWorkbook(is1);
		Sheet sheet1 = wb1.getSheetAt(0);
		Row rowAcc = sheet1.getRow(0);
		String emailOfAccount = rowAcc.getCell(0).getStringCellValue(); 
		
		Row rowFirst = sheet.getRow(0);
		String firstEmpEmail = rowFirst.getCell(2).toString();
		emailsExcel.add(firstEmpEmail);
		
		emailsExcel.add(emailOfAccount);   // dodajem mejl od naloga iz eksela kredencijala za login
		Collections.sort(emailString);
		Collections.sort(emailsExcel);
		System.out.println(emailString);
		System.out.println(emailsExcel);
		Assert.assertEquals(emailString, emailsExcel);
		
		wb.close();
		wb1.close();
	}
}
		
		
		
			
			
			
			
		

	
	
	
	
	

