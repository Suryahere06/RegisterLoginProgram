package com.NewCompName.RegisterLoginProgram;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) throws InterruptedException {
	//setting up the DriverManager	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
	//Navigating to the website		
    driver.get("http://demo.automationtalks.com/index.html");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//Tables practise
	
	String silverprice=driver.findElement(By.xpath("table[@id='priceTable']/tbody/tr[1]/td[2)")).getText();
    String goldprice=driver.findElement(By.xpath("table[@id='priceTable']/tbody/tr[1]/td[3)")).getText();
    String platinumprice=driver.findElement(By.xpath("table[@id='priceTable']/tbody/tr[1]/td[4)")).getText();
    String ultimateprice=driver.findElement(By.xpath("table[@id='priceTable']/tbody/tr[1]/td[5)")).getText();
			
	
    
	driver.close();
	
	
	
	
	}
}