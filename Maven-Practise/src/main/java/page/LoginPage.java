package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(id="email")
	private WebElement unTB;
	
	@FindBy(id="passwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//span[contains(.,'Sign in')]")
	private WebElement SigninBTN;
	
	@FindBy(xpath="//p[.='There is 1 error']")
	private WebElement ErrMsg;
	
	@FindBy(xpath="//i[@class='icon-lock left']")
	private WebElement Search_Signin;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickSigninBTN()
	{
		SigninBTN.click();
	}
	
	public void clickSearch_Signin()
	{
		Search_Signin.click();
	}
	
	public void verifyErrorMessage(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 12);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ErrMsg));
			Reporter.log("Login failed - Login with valid credentials",true);
			Assert.fail();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
}
