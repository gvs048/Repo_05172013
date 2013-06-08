package com.dealwallet.webdriver.selenium.scraping;


import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jabraat2 {
	public static void main(String[] args) throws IOException {

		boolean t = false;
		do {

			//URL url =new URL("http://www.jabraat.com/categories/Buy-Titan-Watches-Online/cid-CU00086809.aspx");

			/*Document doc = Jsoup.connect(url).get();
			Response s =Jsoup.connect(url).execute();
			System.out.println(s.statusCode());
			Elements links = doc.select("div");
			Elements links2 = links.select("img");

			for(Element e:links2)
			{
				//System.out.println(e);
			}*/
			
			/*Document d=Jsoup.parse(url,3000);
			Elements ele=d.select("div");
			for(Element e:ele)
			{
				System.out.println(e);
			}
			System.out.println(ele);*/

			final String url = "http://www.jabraat.com/categories/Buy-Digital-Cameras-Online/cid-CU00084377.aspx";
			Document doc = Jsoup.connect(url).get();

			for( Element element : doc.select("div.controlcontent_r") )
			{
			    System.out.println(element);
			    System.out.println();
			}
		}while(t);
	}

}
