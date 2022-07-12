package openCartProject.pomClassesOpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPageOpenCart {

	@FindBy(id = "input-username")
	static private WebElement UserName;

	@FindBy(name = "password")
	static private WebElement passWD;

	@FindBy(xpath = "//button[@type='submit']")
	static private WebElement lgnBtn;

	public LoginPageOpenCart(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public static void sendUserName(String uid) {

		UserName.sendKeys(uid);
		Reporter.log("User Name Added Sucessfuly...",true);
	}

	public static void sendPassword(String pwd) {

		passWD.sendKeys(pwd);
		Reporter.log("Password Added Sucessfuly ...",true);
	}

	public static void clickOnLoginBtn() {

		lgnBtn.click();
		Reporter.log("Login Done ...",true);
	}
}
