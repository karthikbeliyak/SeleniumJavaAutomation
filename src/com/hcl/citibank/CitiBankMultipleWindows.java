package com.hcl.citibank;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitiBankMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm"); //wait until page load happens fldLoginUserId
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		Thread.sleep(5000);
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		System.out.println("-------------------------");
		
		
		Set<String> windows = driver.getWindowHandles();
		for (String win: windows)
		{
			System.out.println(win);
			driver.switchTo().window(win);
			
			System.out.println(driver.getTitle());
			if (driver.getTitle().equals("Net Banking - Online Internet Banking in India - Citibank India"))
			{
				break;
			}
			
		}
		//click on travel
		
		driver.close();
		
		// gettitle
	}

}
