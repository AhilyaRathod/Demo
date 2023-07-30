package Com.Ecommerce.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Ecommerce_Login_Page;

public class TC_LoginApplication extends Ecommerce_BaseClass {
	
	@Test
	public void Login() throws InterruptedException {
		
		TC_Ecommerce_Login_Page TEL= new TC_Ecommerce_Login_Page();
		
		TEL.SetUsername(Username);
		logger.info("Enter the user email");
		
		Thread.sleep(2000);
		
		TEL.SetPassword(password);
		logger.info("Enter the user Password");
		
		TEL.ClickButton();
		logger.info("Click on the login button");
		
		String Title = driver.getTitle();
		
		if(Title.equals("nopCommerce demo store")) {
			
			Assert.assertTrue(true);
			logger.info("Login test case pass");
		}
		
		else {
			Assert.assertTrue(false);
			logger.info("Login test case failed");
		}
		
		
		
	}

}
