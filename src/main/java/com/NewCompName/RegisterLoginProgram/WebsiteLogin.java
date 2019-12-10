package com.NewCompName.RegisterLoginProgram;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebsiteLogin {

	public static void main(String[] args) throws InterruptedException {
	//setting up the DriverManager	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
	//Navigating to the website		
	driver.get("http://services.smartbear.com/samples/TestComplete14/smartstore/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	
	 //Click event for the login link
	//driver.findElement(By.xpath("//*[@id=\"menubar-my-account\"]/div/a/span")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-user-o menubar-icon']")).click();
	
	//click event for the Register link
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div[2]/div[2]/div[2]/div/div/a")).click();
	driver.findElement(By.xpath("//a[@class='btn btn-warning btn-lg btn-block register-button']")).click();
	
	
	driver.findElement(By.xpath("//input[@value='M']")).click();
	//driver.findElement(By.xpath("//input[@value='F']")).click();
	driver.findElement(By.id("FirstName")).sendKeys("John");
	driver.findElement(By.id("LastName")).sendKeys("Hauge");
	
	WebElement dobd= driver.findElement(By.name("DateOfBirthDay"));
	Select selectdobd=new Select(dobd);
	selectdobd.selectByVisibleText("13");
	
	WebElement dobm= driver.findElement(By.name("DateOfBirthMonth"));
	Select selectdobm=new Select(dobm);
	selectdobm.selectByVisibleText("August");
	
	
	
	//List<WebElement> ddmm=selectdobm.getOptions();
	
	
	String str = "August";
	
	driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[text()='"+str+"']")).click();
	
	
	WebElement doby= driver.findElement(By.name("DateOfBirthYear"));
	Select selectdoby=new Select(doby);
	selectdoby.selectByVisibleText("1989");
	
	driver.findElement(By.id("Email")).sendKeys("john.hauge123@gmail.com");
	driver.findElement(By.name("Username")).sendKeys("Johnn123");
	driver.findElement(By.name("Password")).sendKeys("John@1234");
	driver.findElement(By.name("ConfirmPassword")).sendKeys("John@1234");
	driver.findElement(By.id("Company")).sendKeys("John Corporation Ltd");
	Thread.sleep(300);
	
	driver.findElement(By.id("Newsletter")).click();
	
	
	 
	driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();
	
	Assert.

	
	Thread.sleep(3000);
	driver.close();
	
}
}

