package com.dealwallet.webdriver.selenium.Samles;

//import org.apache.jasper.compiler.Node.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class IeDriverExample {

	

	//some code
@Test
public void testIe()
{
	System.setProperty("webdriver.ie.driver","E:\\Subbu\\MyJars\\IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.get("https://irctc.co.in/");
	
	String winHandleBefore = driver.getWindowHandle();  //store the current window handle

	driver.findElement(By.xpath("//a[2]/img")).click();  //opens a new window

	//code to find the new window handle
for(String NewWindowHandle:driver.getWindowHandles())
{
	driver.switchTo().window(NewWindowHandle);   //switch to new window 
}
	String url = driver.getCurrentUrl();    //returns me the URL of the newly opened window

	//driver.findElement(By.name("element2")).click();  //click on element in new window
	System.out.println(url);
}
}
