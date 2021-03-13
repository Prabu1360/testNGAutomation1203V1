package in.testNGautomation.in.testNGAutomation1203;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class FirstTestNGClass {

	WebDriver driver ;

	
	@Test
	public void startApp() throws InterruptedException 
	{
		
		System.out.println("this is my 1st testNG class");
	//	System.setProperty("webdriver.chrome.driver","D:\\Documents Data\\Driver_Browser\\chromedriver.exe");
	//	driver =new ChromeDriver();
		
		  System.setProperty("webdriver.gecko.driver","D:\\Documents Data\\Driver_Browser\\geckodriver.exe");
		  driver = new FirefoxDriver();
		
		driver.manage().window().maximize() ;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(5000);
		String currURL= driver.getCurrentUrl();
		Assert.assertTrue(currURL.contains("/auth/login"));
		
		
	//	WebDriver wait wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void xloginApp() throws InterruptedException 
	{
		System.out.println("before sleep");
		Thread.sleep(12000);
		System.out.println("After sleep");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(6000);
		
		System.out.println("this is my 2nd testNG class");
	}
	
	@Test(dependsOnMethods ="startApp")
	public void zlogoutApp() throws InterruptedException 
	{
		System.out.println("this is my 3rd testNG class");
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(6000);
		driver.quit();
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
}
