package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{
	public WebDriver driver;
	
	@FindBy(xpath="//a[.='Women']")
	private WebElement women;
	
	@FindBy(xpath="//a[@title='Women' and @class='sf-with-ul']")
	private WebElement women_menu;
	
	@FindBy(xpath="(//a[@title='Evening Dresses'])[1]")
	private WebElement EveningDress;
	
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickWomen()
	{
		women.click();
	}
	
	public void selectDress() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(women_menu).perform();
		//women_menu.click();
		Thread.sleep(2000);
		EveningDress.click();
	}
	
	
}
