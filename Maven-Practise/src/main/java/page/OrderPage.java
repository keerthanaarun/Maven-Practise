package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage 
{
	@FindBy(xpath="//span[.='Proceed to checkout']")
	private WebElement ProceedToCheckout;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	private WebElement ProceedToCheckoutWithAgree;
	
	@FindBy(id="cgv")
	private WebElement IagreeChkbox;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	private WebElement PayByCheck;
	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickProceedToCheckout()
	{
		ProceedToCheckout.click();
	}
	
	public void clickIagreeChkbox()
	{
		IagreeChkbox.click();
	}
	
	public void clickProceedToCheckoutWithAgree()
	{
		ProceedToCheckoutWithAgree.click();
	}
	
	public void clickPayByCheck()
	{
		PayByCheck.click();
	}

}
