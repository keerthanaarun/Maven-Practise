package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst
{
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void openApplication()
	{
		driver=new ChromeDriver();
		String url=AUL.getProperty(SETTING_PATH, "URL");
		driver.get(url);
		String strITO=AUL.getProperty(SETTING_PATH, "ITO");
		long ITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult res)
	{
		String Testname=res.getName();
		if(res.getStatus()==2)
		{
			AUL.takeScreenshot(PHOTO_PATH, Testname, driver);
		}
		driver.quit();
	}
}
