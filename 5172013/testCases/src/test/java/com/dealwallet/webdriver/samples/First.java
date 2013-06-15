package com.dealwallet.webdriver.samples;



	import com.thoughtworks.selenium.*;
	import java.util.regex.Pattern;

	public class First extends SeleneseTestCase {
	    public void setUp() throws Exception {
	        setUp("http://localhost:8080/", "*firefox");
	    }
	    public void testTempscript() throws Exception {
	        selenium.open("http://www.google.co.in/");
	        selenium.click("xpath=//li[8]/a/span[2]");
	        selenium.waitForPageToLoad("30000");
	        selenium.type("id=Email", "bert");
	        selenium.type("id=Passwd", "biz");
	        selenium.click("id=signIn");
	        selenium.waitForPageToLoad("30000");
	    }
	}


