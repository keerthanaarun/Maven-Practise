package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage 
{
	@FindBy(xpath="//a[contains(@title,'Log in to your ')]")
	private WebElement Signin;
	
	@FindBy(xpath="//span[.='I confirm my order']")
	private WebElement IConfirmMyOrder;
	
	@FindBy(id="search_query_top")
	private WebElement SearchBox;
	
	
	public MyStorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignin()
	{
		Signin.click();
	}
	
	public void clickIConfirmMyOrder()
	{
		IConfirmMyOrder.click();
	}
	
	public void searchItem()
	{
		SearchBox.sendKeys("dress");
	}
	
}
