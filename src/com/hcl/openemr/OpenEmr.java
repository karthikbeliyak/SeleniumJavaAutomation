package com.hcl.openemr;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenEmr {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.openemr.io/b/openemr/index.php"); //wait until page load happens
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		WebElement langEle =  driver.findElement(By.name("languageChoice"));
		
		Select selectlanguage = new Select(langEle);
		selectlanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement newPatientEle = driver.findElement(By.xpath("//div[text()='Patient/Client']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(newPatientEle).build().perform();
		driver.findElement(By.xpath("//div[text()='New/Search']")).click();
		
		
		Set<String> windows = driver.getWindowHandles();
		for (String win: windows)
		{
			System.out.println(win);
			driver.switchTo().window(win);
			
			System.out.println(driver.getTitle());
			
			
		}
		
		Thread.sleep(5000);
		//switch to other iframe
		driver.switchTo().frame("pat");
				
		driver.findElement(By.id("form_fname")).sendKeys("karthik");
		driver.findElement(By.id("form_lname")).sendKeys("BK");
		driver.findElement(By.id("form_DOB")).sendKeys("2020-05-06 ");
		
		
		WebElement ddSexEle =  driver.findElement(By.name("form_sex"));
		Select sexDd = new Select(ddSexEle);
		sexDd.selectByVisibleText("Male");
		
		
		WebElement statusEle =  driver.findElement(By.name("form_status"));
		Select statusMarital = new Select(statusEle);
		statusMarital.selectByVisibleText("Single");
		
		driver.findElement(By.id("create")).click();
		//It will go to main html
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("modalframe");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alerText = alert.getText();
		System.out.println(alerText);
		
		alert.accept();
		
		driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		
		
		
		
//		WebElement billyEle = driver.findElement(By.xpath("//span[text()='Billy']"));
//		
//		actions.moveToElement(billyEle).build().perform();
//		
//		
//		driver.findElement(By.xpath("//li[text()='Logout']")).click();
		
		//driver.switchTo().defaultContent();
		
		
		
	
	}

}
