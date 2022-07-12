package openCartProject.pomClassesOpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePageOpenCart {

	@FindBy(xpath="//button[@class='btn-close']")
	static private WebElement warningBtn;
	
	@FindBy(xpath = "(//li[@id='menu-customer']//a)[1]")
	static private WebElement customerTab;

	@FindBy(xpath = "//a[text()='Customers']")
	private static  WebElement custSubMenu;

	public HomePageOpenCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	static public void wariningBtn() {
		warningBtn.click();
	}
	public static void clickOnCustomerMenu() {
		customerTab.click();
		Reporter.log("Click on Customer Tab ...",true);
	}

	public static  void clickOnSubMenu() {

		custSubMenu.click();
		Reporter.log("Click on Customer Sub Menu tab ...",true);
	}
}