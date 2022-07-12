package testClassOpenCart;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import openCartProject.baseOpenCart.BaseClassOpenCart;
import openCartProject.pomClassesOpenCart.HomePageOpenCart;
import openCartProject.pomClassesOpenCart.HomePageTableOpenCart;
import openCartProject.pomClassesOpenCart.LoginPageOpenCart;
import openCartProject.utilityOpenCart.UtilityOpenCart;

public class TestClassOpenCart extends BaseClassOpenCart {

	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String name) throws IOException, InterruptedException {
		LaunchBrowser(name);
		new LoginPageOpenCart(driver);
		new HomePageOpenCart(driver);
		new HomePageTableOpenCart(driver);
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		LoginPageOpenCart.sendUserName(UtilityOpenCart.property("Un"));
		LoginPageOpenCart.sendPassword(UtilityOpenCart.property("pass"));
		LoginPageOpenCart.clickOnLoginBtn();

		Thread.sleep(2000);
		HomePageOpenCart.wariningBtn();
		HomePageOpenCart.clickOnCustomerMenu();
		Thread.sleep(200);
		HomePageOpenCart.clickOnSubMenu();
		Thread.sleep(2000);
	}

	@Test
	public void myTest() {
		int r1 = HomePageTableOpenCart.numbersOfRow();
		int c1 = HomePageTableOpenCart.numbersOfCell();
		Object b[][] = HomePageTableOpenCart.showTableData(driver);
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c1; j++) {
				System.out.println(b[i][j]);
			}
		}
	}

	@AfterClass
	public void closeBrowser() {
		tearDown();
	}
}
