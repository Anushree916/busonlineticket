package com.busonlineticket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookTheTicket {
	public void selectDate(WebDriver driver,String month,String date)
	{
		for(int i=1;i<=12;i++) {
			try {
				WebElement day = driver.findElement(By.xpath("//span[text()='"+month+"']/../../..//a[text()='"+date+"']"));
				Actions actions=new Actions(driver);
				actions.scrollToElement(day).perform();
				day.click();
			    break;
				
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		
	}
	}
		
	@Test
	public void bookTicket() {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	//open the browser enter the url
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Select source
	driver.findElement(By.id("txtOriginGeneral")).click();
	driver.findElement(By.xpath("(//div[text()='Cameron Highlands'])[2]")).click();
	
	//Select destination
	driver.findElement(By.id("txtDestinationGeneral")).click();
	driver.findElement(By.xpath("(//div[text()='Kuala Lumpur'])[2]")).click();
	
	//Select date
	driver.findElement(By.id("txtDepartDateBooking")).click();
	selectDate(driver,"August","20");
	
	//Search bus
	driver.findElement(By.id("btnBusSearchNewGeneral")).click();
}
}
