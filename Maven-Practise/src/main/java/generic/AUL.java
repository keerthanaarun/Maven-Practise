package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class AUL 
{
	//Method to read data from Property file
	public static String getProperty(String path,String key)
	{ 
		String value="";
		
		try 
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value=p.getProperty(key);
		} 
		catch (Exception e) 
		{
			
		}
		
		return value;
	}
	
	//Method to verify Page Title
	public static void verifyTitle(WebDriver driver,String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,12);
		try
		{
			wait.until(ExpectedConditions.titleContains(eTitle));
			Reporter.log("Title is matching with "+eTitle,true);
			
		}
		catch (Exception e) 
		{
			Reporter.log("Title is NOT Matching",true);
			Assert.fail();
			
		}
	}
	
	//Method to take Screenshot at the time of Script failure
	public static void takeScreenshot(String folder, String Testname, WebDriver driver)
	{
		String date=new Date().toString().replaceAll(":","_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String destPath=folder+"-"+Testname+"-"+date+".png";
		try
		{
			FileUtils.copyFile(srcFile,new File(destPath));
		}
		catch(Exception e)
		{
			
		}
		
	}
	
}
