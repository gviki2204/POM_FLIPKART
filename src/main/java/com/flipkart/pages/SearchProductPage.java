package com.flipkart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class SearchProductPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
By searchLoc = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
//By searchbutn = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button");
	
public boolean validateSearchProduct(String productName) {	
	//wait(2000);
	driver.findElement(searchLoc).sendKeys(productName);
	wait(2000);
	driver.findElement(searchLoc).sendKeys(Keys.ENTER);
	
	
	boolean flagResult = true;
	
	try {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")));	
	}catch(TimeoutException te) {
		captureScreenshot("Search Failure");
		flagResult = false;
	}
	
	if(flagResult) {
	String actResult1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")).getText();
	return actResult1.equals("Laptops");
	}
	else 
	return false;
}
}
