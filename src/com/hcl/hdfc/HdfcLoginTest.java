package com.hcl.hdfc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HdfcLoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/"); //wait until page load happens fldLoginUserId
		driver.switchTo().frame("login_page");
		
		//send username
		driver.findElement(By.name("fldLoginUserId")).sendKeys("test123");
		
		//click on continue
		driver.findElement(By.xpath("//img[contains(@src,'/gif/continue_new1.gif?v=1')]")).click();
		//or here "//img[@alt='continue']")
		
		//switch to main html
		driver.switchTo().defaultContent();
	}

}
