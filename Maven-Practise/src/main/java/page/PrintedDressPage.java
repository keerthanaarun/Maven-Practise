package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedDressPage 
{
	@FindBy(id="group_1")
	private WebElement size;
	
	@FindBy(id="add_to_cart")
	private WebElement AddtoCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement ProceedToCheckout;
	
	public PrintedDressPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectSize()
	{
		Select select=new Select(size);
		select.selectByVisibleText("M");
	}
	
	public void clickAddtoCart()
	{
		AddtoCart.click();
	}
	
	public void clickProceedToCheckout()
	{
		ProceedToCheckout.click();
	}

}
