package Com.Ecommerce.TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.io.BufferedReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_BrokenLinks extends Ecommerce_BaseClass {
	
	@Test
	public void Broken_Links() throws MalformedURLException, IOException {
		
		List<WebElement> Linkslist = driver.findElements(By.tagName("a"));
		
		Linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total links ==" + Linkslist.size());
		int brokenlinks = 0;
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0; i< Linkslist.size(); i++) {
			if(Linkslist.get(i).getAttribute("href") !=null && (!Linkslist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(Linkslist.get(i));
			}
		}
		
		System.out.println("Active links=="+activelinks.size());
		
		for(int j=0; j< activelinks.size(); j++) {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			
			int Statuscode = connection.getResponseCode();
			
			if(connection.getResponseCode()>= 400) {
				
				System.out.println(Statuscode + "--->" + activelinks.get(j).getAttribute("href") +"Is ---> broken links");
			} else {
				System.out.println(Statuscode + "--->" + activelinks.get(j).getAttribute("href") +"Is ---> Valid links");

				
			}
		}
		System.out.println("Number of broken links:"+ brokenlinks);

	}

}
