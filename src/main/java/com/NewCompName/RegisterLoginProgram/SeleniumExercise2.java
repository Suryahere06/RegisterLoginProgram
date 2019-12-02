package com.NewCompName.RegisterLoginProgram;



 
 import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExercise2 {
private static void getTitle1(String Title,WebDriver D )
{
    //verify page title

    String expectedtitle=Title;
	String currenttitle=D.getTitle();
	if(currenttitle.equals(expectedtitle))
	{System.out.println("Page title is matching");
	}
	else {
		System.out.println("Page title is not matching");
	}
}
	public static void main(String[] args) throws InterruptedException {
	//setting up the DriverManager	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
	//Navigating to the website		
	driver.get("http://demo.automationtalks.com/index.html");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//Entering vehicle data
	
	
	driver.findElement(By.xpath("//select[@name='Make']//option[text()='BMW']")).click();
	driver.findElement(By.id("engineperformance")).sendKeys("100");
	
	  driver.findElement(By.id("opendateofmanufacturecalender")).click();
	  List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		

		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d/yyyy");
		String dt = simpleDateFormat.format(d);
		System.out.println(dt);
		String []sp= dt.split("/");	  //02
	 
	 
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText(); //2
			
		
			
			if( date.equals(sp[1]))
			{
				ele.click();
				break;
			}
			
		}
		
 	driver.findElement(By.xpath("//select[@id='numberofseats']//option[text()='4']")).click();
 	
	driver.findElement(By.xpath("//select[@id='fuel']//option[text()='Electric Power']")).click();	
	driver.findElement(By.id("payload")).sendKeys("12344");
	driver.findElement(By.id("listprice")).sendKeys("50000");	
	driver.findElement(By.id("totalweight")).sendKeys("50000");	

	driver.findElement(By.id("annualmileage")).sendKeys("45678");
	driver.findElement(By.name("Next (Enter Insurant Data)")).click();
    //verify page title
	SeleniumExercise2.getTitle1("Fill Insurant Data", driver);
	
 
	
	//Entering Insurant data
	
	driver.findElement(By.name("First Name")).sendKeys("Steffy");
	driver.findElement(By.name("Last Name")).sendKeys("Sampras");

	
	
	String str = "06/15/1982";
	
	driver.findElement(By.id("birthdate")).sendKeys(str);
	
	driver.findElement(By.xpath("//input[@id='genderfemale']/following-sibling::span")).click();
	
 	
 	
	WebElement cc=driver.findElement(By.xpath("//select[@id='country']"));
	Select cc1=new Select(cc);
	cc1.selectByVisibleText("India");
	
	driver.findElement(By.id("zipcode")).sendKeys("641045");
	driver.findElement(By.xpath("//select[@id='occupation']//option[text()='Public Official']")).click();
	
	//check box driver.findElement(By.xpath("//input[@id='speeding']")).click();	

	//driver.findElement(By.xpath("//input[@id='speeding']/preceding-sibling::span")).click();
	driver.findElement(By.name("Next (Enter Product Data)")).click();
	
    //verify page title
	SeleniumExercise2.getTitle1("Fill Product Data",driver);
	
	
	//Entering Product data
	
	
 
	driver.findElement(By.xpath("//select[@id='insurancesum']//option[@value='10000000']")).click();
	driver.findElement(By.xpath("//select[@id='damageinsurance']//option[text()='Full Coverage']")).click();
	
	//Product checkbox
	driver.findElement(By.id("nextselectpriceoption")).click();

	
	
    Thread.sleep(30000);
    driver.close();
    
    
  
    
}
}

