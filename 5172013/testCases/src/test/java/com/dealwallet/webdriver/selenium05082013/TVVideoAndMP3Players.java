package com.dealwallet.webdriver.selenium05082013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dealwallet.webdriver.selenium.Common.Merchants;

/**
 * The class "TVVideoAndMP3Players" is for comparing the prices from TVVideoAndMP3Players category products in Dealwallet 
 * and corresponding merchant site products.
 * @author Tsss-Pc1
 */
public class TVVideoAndMP3Players
{
	/**
	 * "d" is an object of a WebDriver interface
	 */
	public WebDriver d;
	
	/**
	 * The Method before() is used for initializing the browser to WebDriver object.
	 */
	@BeforeMethod
	public void before()
	{
		d=new FirefoxDriver();
	}
	
	/**
	 * The Method after() is used to close the browser.
	 */
	@AfterMethod
	public  void after()
	{
		d.quit();
	}
		
	/**
	 * The actual logic implemented in testTVVideoMp3Player() method
	 * we are identifying the price in our site and by hitting the shop now button
	 * we are identifying the price in merchant site price.
	 * Then we comparing the both price and whether it is equal or not.
	 */
	@Test
	public void testTVVideoMp3Player() {
		Merchants m=new Merchants();
		String pcode = m.productLink(d);
		//for TV, Video & MP3 Player link in DealWallet Categories..
		d.findElement(By.xpath("//ul[22]/li/a")).click();
		for(int i=1;i<=3;i++)
		{
			for(int k=1;k<=10;k++)
			{
				String ammount = m.dwPrice(k,d);
				String[] sitename = m.sitename(d);
				
				switch(sitename[0])
				{
				
				case "jabong":
					m.jabong(ammount,d);
					break;
					
				case "snapdeal":
					m.snapdeal(ammount, d);
					break;
					
				case "naaptol":
					m.naaptol(ammount, d);
					break;
									
				default:
					System.out.println("sight name is not matched");
				}
				d.close();
				System.out.println("++++++++++++++++++++++");
				d.switchTo().window(pcode);
			}
			System.out.println(i+" page is completed");
			//for Next page link in DealWallet
			d.findElement(By.linkText("Next")).click();
		}
	}
	
	
	

}