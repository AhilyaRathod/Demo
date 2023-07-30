package Com.Ecommerce.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.Utilities.GenericUtils;

public class TC_Ecommerce_AddToCart extends Ecommerce_BaseClass {
	
	
	//1.
	public TC_Ecommerce_AddToCart() {
		
		PageFactory.initElements(driver, this);
	}
	
	//2. diff - pom and page factory
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	public WebElement Com;
	
	@FindBy(xpath = "//a[contains(text(),'Notebooks')]")
	public WebElement Notebooks;
	
	@FindBy(xpath = "//a[contains(text(),'Apple MacBook Pro 13-inch')]")
	public WebElement SelectMacbook;
	
	@FindBy(id = "add-to-cart-button-4")
	public WebElement Addtocart;
	
	@FindBy(xpath = "//p[contains(text(),'The product has been added to your')]")
	public WebElement Message;
	
	@FindBy(xpath = "//span[@title=\"Close\"]")
	public WebElement CloseTab;

	//3.
	public void NoteBooks() {
		Notebooks.click();
	}
	public void SelectProduct() {
		GenericUtils.ClickElementsUsingJavaScript(SelectMacbook, driver);
	}
	public void AddToCart() {
		Addtocart.click();
	}
	public void ProductAdded() {
		Message.isDisplayed();
	}
	public void Close() {
		CloseTab.click();
	}
	public void Product() {
		
		By input1=By.xpath("(//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"])[2]");
		
		boolean result=GenericUtils.waitforelement(driver, input1, 20).isDisplayed();
		
		if(result == true) {
			logger.info("add to cart test case pass");
			Assert.assertTrue(true);
		}else {
			logger.info("add to cart test case failed");
			Assert.assertTrue(false);
			
		}
	}
	
}
