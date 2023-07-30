package Com.Ecommerce.TestCases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_NewRegistration;
import net.bytebuddy.utility.RandomString;

public class TC_NewRegistrationTestCases extends  Ecommerce_BaseClass {
	
	@Test

	public void Registration() throws InterruptedException {
	
	TC_NewRegistration TNR=new  TC_NewRegistration(driver);
   
	TNR.NewRegistration();
   
   TNR.Selectgender();
   TNR.SetFirstName("ketan");
   TNR.SetLastName("Patil");
   String Name=RandomString.make(5);
   TNR.SetEmail(Name+"ketan@gmail.com");
   TNR.SetPassword("Pune@1234");
   TNR.SetConfirmedPass("Pune@1234");
   TNR.RegButton();
   boolean Test=driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed();

if(Test==true) {
	System.out.println("Created users");
	Assert.assertTrue(true);

}

else {
	System.out.println("User Creation fails");
	Assert.assertTrue(false);
}

}
	
	}



