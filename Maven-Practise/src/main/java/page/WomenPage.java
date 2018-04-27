package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage 
{
	@FindBy(xpath="//img[contains(@src,'/img/p/8/8-home_default.jpg')]")
	private WebElement PrintedDress;
	
	public WomenPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnPrintedDress()
	{
		PrintedDress.click();
	}

}
