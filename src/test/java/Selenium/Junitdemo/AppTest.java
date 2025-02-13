package Selenium.Junitdemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
@FixMethodOrder(MethodSorters.DEFAULT)//exicuting methods in alphabetical order
public class AppTest
{
	static WebDriver driver;
	@BeforeClass
	public static void beforeclass()
	{
		System.out.println("chromedriver started");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//orange hrm application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterClass
	public static void afterclass()
	{
		driver.close();
	}
    @Before
    public void before()
    {
    	System.out.println("before class");
    }
    @After
    public void after()
    {
    	System.out.println("after class");
    }
    
    @Test
    public void login() throws Exception
    {
    	System.out.println(driver.getTitle());
    	System.out.println(driver.getCurrentUrl());
    	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(10000);
//    	File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    	
//    	FileUtils.copyFile(ts, "/");
    	
    	
//    	Username : Admin
//
//    	Password : admin123
    	
    }
}