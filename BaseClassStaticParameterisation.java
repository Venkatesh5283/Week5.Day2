package week5.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseClassStaticParameterisation {
public RemoteWebDriver driver;

@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void PreCond(String browser1, String url1,String name1, String pass1)
	{
	if(browser1.equalsIgnoreCase("chrome"))
	{
	driver  = new ChromeDriver();
	}
	else if(browser1.equalsIgnoreCase("edge"))
	{
		driver =new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(url1);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys(name1);
	driver.findElement(By.id("password")).sendKeys(pass1);
	}
	
	@AfterMethod
	public void postCond()
	{
		driver.close();
	}
}
