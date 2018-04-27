package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OrderConfirmationPage
{
	
	@FindBy(xpath="//p[contains(text(),'My Store is complete')]")
	private WebElement ConfirmMsg;
	
	@FindBy(xpath="//a[@class='logout']")
	private WebElement logout;
	
	public OrderConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void checkConfirmationMessage() 
	{
		if(ConfirmMsg.isDisplayed())
		{
			Reporter.log("Your order is successfully placed",true);
		}
		else
		{
			Reporter.log("Your order is NOT placed",true);
		}
		
	}
	
	public void clickLogout()
	{
		logout.click();
	}

}
