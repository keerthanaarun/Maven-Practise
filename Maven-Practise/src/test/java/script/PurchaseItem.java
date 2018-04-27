package script;

import org.testng.annotations.Test;
import generic.AUL;
import generic.BaseTest;
import page.LoginPage;
import page.MyAccountPage;
import page.MyStorePage;
import page.OrderConfirmationPage;
import page.OrderPage;
import page.PrintedDressPage;
import page.WomenPage;

public class PurchaseItem extends BaseTest
{
	@Test
	public void testPurshaseItem() throws InterruptedException
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
		account.clickWomen();
		AUL.verifyTitle(driver,"Women ");
		Thread.sleep(2000);
		
		WomenPage women=new WomenPage(driver);
		women.clickOnPrintedDress();
		AUL.verifyTitle(driver,"Printed Dress ");
		Thread.sleep(2000);
		
		PrintedDressPage printed_dress=new PrintedDressPage(driver);
		printed_dress.selectSize();
		Thread.sleep(2000);
		printed_dress.clickAddtoCart();
		Thread.sleep(2000);
		printed_dress.clickProceedToCheckout();
		Thread.sleep(2000);
		AUL.verifyTitle(driver,"Order ");
		Thread.sleep(2000);
		
		OrderPage order=new OrderPage(driver);
		order.clickProceedToCheckout();
		Thread.sleep(2000);
		order.clickProceedToCheckout();
		Thread.sleep(2000);
		order.clickIagreeChkbox();
		Thread.sleep(2000);
		order.clickProceedToCheckoutWithAgree();
		Thread.sleep(2000);
		order.clickPayByCheck();
		Thread.sleep(2000);
		AUL.verifyTitle(driver, "My Store");
		Thread.sleep(2000);
		
		mystore.clickIConfirmMyOrder();
		Thread.sleep(2000);
		AUL.verifyTitle(driver,"Order confirmation");
		Thread.sleep(2000);
		
		OrderConfirmationPage confirmation=new OrderConfirmationPage(driver);
		confirmation.checkConfirmationMessage();
		Thread.sleep(2000);
		confirmation.clickLogout();
		Thread.sleep(2000);
		
		
	}

}
