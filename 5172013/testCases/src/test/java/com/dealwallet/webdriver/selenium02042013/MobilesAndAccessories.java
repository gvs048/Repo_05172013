package com.dealwallet.webdriver.selenium02042013;

import java.util.concurrent.TimeUnit;
import com.dealwallet.webdriver.selenium.Common.Merchants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobilesAndAccessories {
	WebDriver d;

	@BeforeMethod
	public void start() {
		d = new FirefoxDriver();

	}

	@AfterMethod
	public void end() {
		d.quit();
	}

	@Test
	public void testAandP() {
		Merchants m = new Merchants();
		d.get("http://www.dealwallet.com");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String pcode = d.getWindowHandle();
		d.findElement(By.linkText("Products")).click();
		for(int j=17;j<=17;j++)
		{
			d.findElement(By.xpath("//ul["+j+"]/li/a")).click();
			for (int i = 1; i <= 2; i++)
			{
				for (int k = 1; k <= 10; k++)
				{
					System.out.println("item number::"+k+",,,page number::"+i+",,,category list number::"+j);
					d.findElement(By.xpath("//div[" + k + "]/div/div[2]/p/a")).click();
					String ammount = d.findElement(By.cssSelector("span.price")).getText();
					ammount = ammount.replace(",", "").substring(1).trim();
					d.findElement(By.xpath("//a/span")).click();
					for (String ccode : d.getWindowHandles())
					{
						d.switchTo().window(ccode);
					}
					if (d.getTitle().equalsIgnoreCase("Page Not Found"))
					{
						System.out.println("Page Not Found Error");
					}
					else
					{
						//String s = d.getCurrentUrl();
						//System.out.println("site name is::" + m.sitename(d));
						int size = 0;
						String price = "";
						String[] sitename = m.sitename(d);
						
						switch(sitename[0])
						{
						case "www.homeshop18.com":
							size = d.findElements(By.id("hs18Price")).size();
							if (size != 0)
							{
								price = d.findElement(By.id("hs18Price")).getText();
								m.homeshop18(ammount, price);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;

						case "www.yebhi.com":
							size = d.findElements(By.xpath("//div[5]/div[2]/div/div[2]/p")).size();
							if (size != 0)
							{
								price = d.findElement(By.xpath("//div[5]/div[2]/div/div[2]/p")).getText();
								m.yebhi(ammount, d);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;

						case "www.naaptol.com":
							size = d.findElements(By.xpath("//li/strong")).size();
							if (size != 0)
							{
								price = d.findElement(By.xpath("//li/strong")).getText();
								m.naaptol(ammount, d);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;

						case "www.snapdeal.com":
							size = d.findElements(By.xpath("//strong/span")).size();
							if (size != 0)
							{
								price = d.findElement(By.xpath("//strong/span")).getText();
								m.snapdeal(ammount,d);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;

						case "letsshop.in":

							size = d.findElements(By.xpath("//span/span")).size();
							if (size != 0)
							{
								price = d.findElement(By.xpath("//span/span")).getText();
								m.letsshop(ammount,price);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;
						case "www.healthkart.com":
							size=d.findElements(By.cssSelector("div.hk > span.num")).size();
							if(size!=0)
							{
								price=d.findElement(By.cssSelector("div.hk > span.num")).getText();
								m.healthkart(ammount,price);
							}
							else
							{
								System.out.println("NO PRICE TO BE DISPLAYED");
							}
							break;
						default:
							System.out.println("Site not found");
						}
					}
					d.close();
					System.out.println("++++++++++++++++++++++");
					d.switchTo().window(pcode);
					d.navigate().back();
				}
				d.findElement(By.linkText("Next")).click();
			}
		}
	}
}
