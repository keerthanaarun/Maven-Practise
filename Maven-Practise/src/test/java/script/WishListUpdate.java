package script;

import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.LoginPage;
import page.MyAccountPage;
import page.MyStorePage;

public class WishListUpdate extends BaseTest
{
	@Test
	public void testWishListUpdation() throws InterruptedException
	{
		String un=AUL.getProperty(SETTING_PATH, "USERNAME");
		String pw=AUL.getProperty(SETTING_PATH, "PASSWORD");
		
			
		MyStorePage mystore=new MyStorePage(driver);
		mystore.clickSignin();
		AUL.verifyTitle(driver, "Login");
		Thread.sleep(2000);
		
		LoginPage login=new LoginPage(driver);
		login.setUsername(un);
		login.setPassword(pw);
		login.clickSigninBTN();
		login.verifyErrorMessage(driver);
		AUL.verifyTitle(driver, "My account");
		Thread.sleep(2000);
		
		MyAccountPage account=new MyAccountPage(driver);
		account.selectDress();
	}

}
