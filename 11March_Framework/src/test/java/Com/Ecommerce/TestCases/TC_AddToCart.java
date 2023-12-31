package Com.Ecommerce.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Ecommerce_AddToCart;
import Com.Ecommerce.PageClasses.TC_Ecommerce_Login_Page;

public class TC_AddToCart extends Ecommerce_BaseClass {
	
	@Test
	public void AddProduct() throws InterruptedException {
		logger.info("Open URL");
		TC_Ecommerce_Login_Page TEL = new TC_Ecommerce_Login_Page();
		Thread.sleep(3000);
		TEL.SetUsername(Username);
		logger.info("Enter User mail");
		Thread.sleep(3000);
		TEL.SetPassword(password);
		logger.info("Enter User password");
		Thread.sleep(3000);
		TEL.ClickButton();
		logger.info("Clicked on login button");
		Thread.sleep(3000);
		
		TC_Ecommerce_AddToCart TEA = new TC_Ecommerce_AddToCart();
		
		Actions Act = new Actions(driver);
		
		WebElement Computer = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));
		
		Act.moveToElement(Computer).perform();
		
		logger.info("Mouseover on computer");
		
		TEA.NoteBooks();
		logger.info("Clicked on NotebookText");
		
		Thread.sleep(5000);
		
		TEA.SelectProduct();
		logger.info("Product selected");
		
		TEA.AddToCart();
		logger.info("Add to cart");
		
		TEA.ProductAdded();
		logger.info("Verified message");
		
		TEA.Close();
		logger.info("Clicked on close Tab");
		
		WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
		
		Actions act = new Actions(driver);
		
		Act.moveToElement(Ele).build().perform();
		
		TEA.Product();
		
	}

}
