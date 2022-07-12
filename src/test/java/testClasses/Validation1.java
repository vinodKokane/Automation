package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.Base1;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utilityClass.Utility1;

public class Validation1 extends Base1{

	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String name) throws IOException {
	
		if(name.equals("chrome")) {
		
			launchBrowserChrome();
		
		}else if(name.equals("firefox")) {
		
			launchBrowserfirefox();
		
		}
		new LoginPage(driver);
		new HomePage(driver);
	}
	@BeforeMethod
	public void login() throws IOException {

		LoginPage.sendUserName(Utility1.getDataFromProperty("UserId"));
		
		Reporter.log("User id Entered....",true);
		
		LoginPage.sendPassWD(Utility1.getDataFromProperty("Password"));
		
		Reporter.log("Password is Entered....",true);
		
		LoginPage.clickOnLoginBtn();
		
		Reporter.log("click on login...",true);
		
		Utility1.waitMethod(20, driver);
		
		HomePage.clickOnAddtoCartBtn();
		
		Reporter.log("click on add to cart button....",true);
		
		HomePage.clickOnBasketBt();
		
		Reporter.log("click on Basket......",true);
		
		Utility1.waitMethod(20, driver);
		
	}
	@Test
	public void validationOfProdcut() {
		
		String actual =HomePage.itemType();
		Assert.fail();
		
		String Excepted = "Sauce Labs Backpack";
		Assert.assertEquals(actual,Excepted,"Product is not Macthed So tc Is Failed.....");
		
		Reporter.log("Congratulation Your Test Case Is pass....!!!!");
	}
	
	@AfterMethod
	public void logOutThePage() {
		
		HomePage.menuBtn();
		
		Utility1.waitMethod(20, driver);
		
		HomePage.logOutbtn();
	}

	@AfterClass
	public void closeBrowser() {
		
		Utility1.waitMethod(30, driver);
		
		Utility1.tearDown(driver);
	}
}
