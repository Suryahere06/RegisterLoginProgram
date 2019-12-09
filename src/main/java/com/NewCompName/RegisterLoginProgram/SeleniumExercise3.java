package com.NewCompName.RegisterLoginProgram;
 

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExercise3 {

	public static void main(String[] args) throws InterruptedException, AWTException {
	//setting up the DriverManager	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
 	//Navigating to the website		
	driver.get("http://qdpm.net/demo/v9/index.php");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//Login with the administrator
	driver.findElement(By.name("login[email]")).sendKeys("administrator@localhost.com");
	driver.findElement(By.name("login[password]")).sendKeys("administrator");
	driver.findElement(By.xpath("//button[@class='btn btn-info pull-right']")).click();
	//To verify dashboard title after logging in
	String currenttitle=driver.getTitle();
	if(currenttitle.equals("qdPM | Dashboard") )
	{
	System.out.println("Title matches");
	
	}else
	{
		System.out.println("Title mismatch");
		
	}
	//Verify that all options are present on dashboard page
	
	
	//Click on “Add Task” button 
	driver.findElement(By.xpath("//button[text()='Add Task']")).click();
	Select ste= new Select(driver.findElement(By.id("form_projects_id")));
	ste.selectByVisibleText("Test Project 1");
	WebElement element = (new WebDriverWait(driver, 200))
			   .until(ExpectedConditions.elementToBeClickable(By.linkText("General")));
   
	//Enter data Under General tab
	driver.findElement(By.linkText("General")).click();
	driver.findElement(By.xpath("//select[@id='tasks_tasks_type_id']//option[text()='Defects (Hourly rate $0.00)']")).click();
	driver.findElement(By.name("tasks[name]")).sendKeys("Surya");
	driver.findElement(By.xpath("//select[@id='tasks_tasks_status_id']//option[text()='Lost']")).click();
	driver.findElement(By.xpath("//select[@id='tasks_tasks_priority_id']//option[text()='Low']")).click();
	driver.findElement(By.xpath("//select[@id='tasks_tasks_label_id']//option[text()='Issue']")).click();
	driver.findElement(By.id("tasks_assigned_to_2")).click();
	driver.findElement(By.id("tasks_assigned_to_4")).click();
	Select man=new Select(driver.findElement(By.xpath("//select[@id='tasks_created_by']")));
	man.selectByVisibleText("manager");
	//Thread.sleep(2000);
	//Switch to time tab and enter below data
	driver.findElement(By.linkText("Time")).click();
	driver.findElement(By.name("tasks[estimated_time]")).sendKeys("11");
	String startdate="2019-12-27";
	driver.findElement(By.id("tasks_start_date")).sendKeys(startdate);
	String duedate="2019-12-31";
	driver.findElement(By.id("tasks_due_date")).sendKeys(duedate);
	//Thread.sleep(3000);
	//Switch to attachment tab 
	driver.findElement(By.linkText("Attachments")).click();
	driver.findElement(By.xpath("//div[@id='uploadifive-uploadify_file_upload']")).click();
	File f = new File("/Users/Surya/Desktop/abc.docx");
	StringSelection ss = new StringSelection(f.getAbsolutePath());
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_TAB);
	 
	robot.delay(500);
	//Open Goto window
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_SHIFT);	 
	robot.keyPress(KeyEvent.VK_G);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_SHIFT);	 
	robot.keyRelease(KeyEvent.VK_G);	 
	//Paste the clipboard value	 
	robot.keyPress(KeyEvent.VK_META);	 
	robot.keyPress(KeyEvent.VK_V);	 
	robot.keyRelease(KeyEvent.VK_META);	 
	robot.keyRelease(KeyEvent.VK_V);	 
	//Press Enter key to close the Goto window and Upload window	 
	robot.keyPress(KeyEvent.VK_ENTER);	 
	robot.keyRelease(KeyEvent.VK_ENTER);	 
	robot.delay(500);	 
	robot.keyPress(KeyEvent.VK_ENTER);	 
	robot.keyRelease(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//button[text()='Save']")).click();	
	//Logout using the admin button
	driver.findElement(By.xpath("//li[@class='dropdown user']//a[@href='#']")).click(); 
	driver.findElement(By.linkText("Logoff")).click();
	
	//To login again 
	driver.findElement(By.name("login[email]")).sendKeys("administrator@localhost.com");
	driver.findElement(By.name("login[password]")).sendKeys("administrator");
	driver.findElement(By.xpath("//button[@class='btn btn-info pull-right']")).click();
	//To click on task and selct View all option
	driver.findElement(By.linkText("Tasks")).click();
	driver.findElement(By.linkText("View All")).click();
	//To do mousehover on searchfield and enter the name in the field
	Actions actions = new Actions(driver);
	WebElement sear = driver.findElement(By.xpath("//div[@id='search_menu']"));
	actions.moveToElement(sear).build().perform();
	driver.findElement(By.id("search_keywords")).sendKeys("Surya");
	driver.findElement(By.xpath("//input[@class='btn btn-default']")).click();
	
	List <WebElement> baseTable = driver.findElements(By.xpath("//table[@class='table table-striped table-bordered table-hover tasks-table dataTable']//td"));
  	int count =0;
  	WebElement deleteicon = null;
	for (WebElement ele:baseTable)
 	{   count++;
 	if (count ==11) deleteicon = ele.findElement(By.xpath("//a[@class='btn btn-default btn-xs purple']"));
 		System.out.println(ele.getText());
 	
 	}
	if (deleteicon!=null) 
		{deleteicon.click();
	Alert a1 =driver.switchTo().alert();
	a1.accept();
		}
	else {System.out.println("No results,All records deleted");}
	//Logout using the admin button
	driver.findElement(By.xpath("//li[@class='dropdown user']//a[@href='#']")).click(); 
	driver.findElement(By.linkText("Logoff")).click();
	
    driver.close();
    
    
  
    
}

}

