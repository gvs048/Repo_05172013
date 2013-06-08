package com.dealwallet.webdriver.selenium.scraping;


import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jabraat1 {

	private static final int TWO_HUNDRED = 200;
	private static final int THREE_HUNDRED = 300;
	private static final int FOUR_HUNDRED = 400;

	private MultiThreadedHttpConnectionManager connectionManager;
	private HttpClient client;

	/**
	 *
	 */
	public Jabraat1() {
		connectionManager = new MultiThreadedHttpConnectionManager();
		final HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		params.setDefaultMaxConnectionsPerHost(THREE_HUNDRED);
		params.setMaxTotalConnections(FOUR_HUNDRED);
		connectionManager.setParams(params);
		client = new HttpClient(connectionManager);
	}

	public String doLogin(final String url) {

		String respString = null;
		final HttpMethod method = new GetMethod(url);
		try {
			final Header contentHeader = new Header("Content-type",
					"html/json; charset=UTF-8");
			method.addRequestHeader(contentHeader);
			int resp = 0;
			if (client != null) {
				resp = client.executeMethod(method);
			} else {
				client = new HttpClient(connectionManager);
				resp = client.executeMethod(method);
			}
			if (resp == TWO_HUNDRED) {
				final byte[] respStringBytes = method.getResponseBody();
				if (respStringBytes != null && respStringBytes.length > 0) {
					respString = new String(respStringBytes, "UTF-8");

				}
			}

		} catch (final Exception e) {
			System.err.println(e);
		} finally {
			method.releaseConnection();
		}
		return respString;
	}

	private Document fetchPageSoup(final String pageHTML) {

		if (pageHTML.equalsIgnoreCase("")) {
			System.out.println("ddd");
		}

		Document pageSoup = null;
		
			try {
				pageSoup = Jsoup.connect(pageHTML).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return pageSoup;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String htmlString = null;
		String htmlString1 = null;
		String htmlString3 = null;
		Jabraat1 fbz = new Jabraat1();


		int PAGESIZE = 24;
		int pcount = 1;
		boolean t = false;
		do {

			String url ="http://www.jabraat.com/categories/Buy-Titan-Watches-Online/cid-CU00086809.aspx";
			htmlString = fbz.doLogin(url);
			final Document document = fbz.fetchPageSoup(htmlString);
			Elements body = document.select("body");
			Elements products = body.select("div[class=controlcontent_r]");
			boolean s= body.contains("bucket_left");
			System.out.println("contains method "+s);
			int i=4;
			for (Element product : products) {
				System.out.println("product title:" + product.select("a").select("img").attr("title"));
				i++;
			}
		}while(t);
	}

}
