package week5.Day2;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClassAssignment {
	public RemoteWebDriver driver;
	public String filename;
	
	@Parameters({"browser","url","username","password" })
	
	@BeforeMethod
	public void preCondition(String browser1,String url1,String user1, String pass1 )
	{
		if(browser1.equalsIgnoreCase("Chrome"))
		{
	driver  = new ChromeDriver();
		}
		else if(browser1.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.get(url1);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys(user1);
	driver.findElement(By.id("password")).sendKeys(pass1);
	}
	
	
	@AfterMethod
	public void postCondtion()
	{
		driver.close();
	}
	
	
	@DataProvider(name="DataProvAnnotation")
	public String[][] fetchExceldata() throws IOException
	{
		String[][] s = ExcelFetchClass.readExcel(filename);
		return s;
		
	}
}
