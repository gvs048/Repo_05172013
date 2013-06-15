package com.dealwallet.webdriver.samples;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alert {

	WebDriver d;
	@BeforeMethod
	public void initilaization()
	{
		System.setProperty("webdriver.ie.driver", "E:\\Subbu\\MyJars\\IEDriverServer.exe");
		d=new InternetExplorerDriver();
	}
	@AfterMethod
	public void stopDriver()
	{
		d.quit();
	}
	@Test void testalert() throws Exception
	{

		d.get("https://irctc.co.in/");
		d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		assertEquals("IRCTC Online Passenger Reservation System",d.getTitle());
		d.findElement(By.id("button")).click();
		org.openqa.selenium.Alert al=d.switchTo().alert();
		al.accept();
		d.findElement(By.name("userName")).sendKeys("bpradeep.p");
		d.findElement(By.id("button")).click();
		al.accept();
		d.findElement(By.name("password")).sendKeys("273382");
		d.findElement(By.id("button")).click();
		assertEquals(":: IRCTC :: - Plan My Travel",d.getTitle());
		d.findElement(By.name("stationFrom")).sendKeys("sc");
		d.findElement(By.name("stationTo")).sendKeys("tel");
		d.findElement(By.id("calendar_icon1")).click();
		d.findElement(By.linkText("27")).click();


		//d.findElement(By.linkText("//td[3]/a")).click();
		d.findElement(By.name("Submit")).click();
		d.findElement(By.xpath("//td[10]/input")).click();
		d.findElement(By.id("submitButton0")).click();
		assertEquals(":: IRCTC :: - Ticket Reservation",d.getTitle());

		d.findElement(By.xpath("//tr[@id='passenger0']/td[2]/input")).clear();
		d.findElement(By.xpath("//tr[@id='passenger0']/td[2]/input")).sendKeys("pradeep");

		d.findElement(By.name("passengers[0].passengerAge")).clear();
		d.findElement(By.name("passengers[0].passengerAge")).sendKeys("24");
		new Select(d.findElement(By.name("passengers[0].passengerSex"))).selectByIndex(1);
		new Select(d.findElement(By.name("passengers[0].berthPreffer"))).selectByIndex(1);
		d.findElement(By.name("passengers[0].seniorCitizen")).click();
		d.findElement(By.name("upgradeCh")).click();
		d.findElement(By.xpath("//td[4]/table/tbody/tr/td/input")).click();

		Thread.sleep(10000);
	}

}
