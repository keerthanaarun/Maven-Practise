package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo 
{
	@Test
	public void demoTest()
	{
		Reporter.log("Demo Updated",true);
		Reporter.log("Check Updation",true);
	}

}
