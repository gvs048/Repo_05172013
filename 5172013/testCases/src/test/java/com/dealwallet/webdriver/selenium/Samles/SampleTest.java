package com.dealwallet.webdriver.selenium.Samles;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dealwallet.webdriver.samples.alert;

public class SampleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver d;
		String price;
		d=new FirefoxDriver();
		d.get("file:///C:/Users/Tsss-Pc1/Desktop/t2.html");
		try
		{
		d.findElement(By.id("btnNewNamelessWindow")).click();
		Alert a=d.switchTo().alert();
		a.accept();
		}
		catch(Exception e)
		{
			System.out.println("Alert not present");
		}
		d.quit();
	}

}
