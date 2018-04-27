package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.LoginPage;
import page.MyStorePage;
import page.OrderConfirmationPage;
import page.OrderPage;
import page.ShortSleeveTshirtsPage;

public class SearchandPurchase extends BaseTest
{
	@Test
	public void testSearchandPurchase() throws InterruptedException
	{
		MyStorePage mystore=new MyStorePage(driver);
		mystore.searchItem();
		driver.findElement(By.xpath("//li[contains(text(),'T-shirts')]")).click();
		AUL.verifyTitle(driver, "T-shirts");
		Thread.sleep(2000);
		
		ShortSleeveTshirtsPage tshirt=new ShortSleeveTshirtsPage(driver);
		tshirt.selectBlue();
		Thread.sleep(2000);
		tshirt.selectQty("2");
		Thread.sleep(2000);
		tshirt.clickAddtoCart();
		Thread.sleep(2000);
		tshirt.clickProceedtoCheckout();
		Thread.sleep(2000);
		AUL.verifyTitle(driver,"Order ");
		Thread.sleep(2000);
		
		OrderPage order=new OrderPage(driver);
		order.clickProceedToCheckout();
		AUL.verifyTitle(driver,"Login");
		Thread.sleep(2000);
		
		LoginPage login=new LoginPage(driver);
		String un=AUL.getProperty(SETTING_PATH, "USERNAME");
		String pw=AUL.getProperty(SETTING_PATH, "PASSWORD");
		login.setUsername(un);
		login.setPassword(pw);
		login.clickSearch_Signin();
		Thread.sleep(2000);
		AUL.verifyTitle(driver,"Order ");
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
