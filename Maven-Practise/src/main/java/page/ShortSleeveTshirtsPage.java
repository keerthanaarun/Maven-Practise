package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShortSleeveTshirtsPage 
{
	@FindBy(id="color_14")
	private WebElement blue;
	
	@FindBy(id="color_13")
	private WebElement orange;
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(xpath="//i[@class='icon-minus']")
	private WebElement qty_minus;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	private WebElement qty_plus;
	
	@FindBy(xpath="//span[.='Add to cart']")
	private WebElement AddtoCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement ProceedtoCheckout;
	
	public ShortSleeveTshirtsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectBlue()
	{
		blue.click();
	}
	
	public void selectQty(String qt)
	{
		quantity.clear();
		quantity.sendKeys(qt);
//		int q=Integer.parseInt(qty);
//		if(q<qt)
//		{
//			for(int i=0;i<qt;i++)
//			{
//				qty_plus.click();
//			}
//		}
//		else if(q>qt)
//		{
//			for(int i=q;i>=qt;i--)
//			{
//				qty_minus.click();
//			}
//		}
		
	}
	
	public void clickAddtoCart()
	{
		AddtoCart.click();
	}
	
	public void clickProceedtoCheckout()
	{
		ProceedtoCheckout.click();
	}

}
