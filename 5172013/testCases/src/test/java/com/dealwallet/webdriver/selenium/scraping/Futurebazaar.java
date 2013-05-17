package com.dealwallet.webdriver.selenium.scraping;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Futurebazaar 
{

	WebDriver d;
	@BeforeMethod
	public void startup()
	{
		d=new FirefoxDriver();
	}
	@AfterMethod
	public void stop()
	{
		d.quit();
	}
	@Test
	public void testFB()
	{
		

		d.get("http://www.futurebazaar.com/categories/Home--Living-Luggage--Travel-Airbags--Duffel-bags/cid-CU00089575.aspx");
		d.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		Document doc = Jsoup.parse(d.getPageSource());
		Elements body = doc.select("body").select("loadmore.bucketgroup");
		//doc.select("body").select("div.catSearchDiv").select("div.subMenuList").select("li")
		System.out.println(body);
	}

}
