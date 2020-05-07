package com.hcl.magento;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagentoTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/"); //wait until page load happens
		
		WebElement myAccEle = driver.findElement(By.linkText("My Account"));
		myAccEle.click();		
		
		WebElement emailEle = driver.findElement(By.id("email"));
		emailEle.sendKeys("balaji0017@gmail.com");
		
		WebElement passEle = driver.findElement(By.id("pass"));
		passEle.sendKeys("welcome@123");
		
		WebElement loginClick = driver.findElement(By.id("send2"));
		loginClick.click();
		
		//before getting the title, need to verify the login
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Out")));
		
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		
		if (actualTitle.equals(expectedTitle)){
			System.out.println("Test passed");
		}
		else {
			System.out.println("Failed!!");
		}
		
		driver.findElement(By.partialLinkText("Out")).click();
		
		
	}

}
