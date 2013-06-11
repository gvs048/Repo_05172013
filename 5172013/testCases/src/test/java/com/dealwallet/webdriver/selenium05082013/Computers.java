package com.dealwallet.webdriver.selenium05082013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dealwallet.webdriver.selenium.Common.Merchants;
public class Computers
{
	WebDriver d;
	@BeforeMethod
	public void before()
	{
		d=new FirefoxDriver();
	}
	@AfterMethod
	public  void after()
	{
		d.quit();
	}
	
	
	@Test
	public void testAandP() {
		Merchants m=new Merchants();
		String pcode = m.productLink(d);
		//for Audio & Video link in categories..
		d.findElement(By.xpath("//ul[7]/li/a")).click();
		for(int i=1;i<=3;i++)
		{
			for(int k=1;k<=10;k++)
			{
				String ammount = m.dwPrice(k,d);
				String[] sitename = m.sitename(d);
				
				switch(sitename[0])
				{
				case "clik2pick":
					m.clik2pick(ammount, d);
					break;
					
				case "edabba":
					m.edabba(ammount, d);
					break;
				
				case "naaptol":
					m.naaptol(ammount,d);
					break;
					
									
				default:
					System.out.println("sight name is not matched");
				}
				d.close();
				System.out.println("++++++++++++++++++++++");
				d.switchTo().window(pcode);
				//d.navigate().back();
			}
			System.out.println(i+" page is completed");
			d.findElement(By.linkText("Next")).click();
		}
	}
	

}