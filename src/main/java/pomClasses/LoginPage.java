package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user-name")
	private static WebElement userName;

	@FindBy(name = "password")
	private static WebElement passWD;

	@FindBy(id = "login-button")
	private static WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void sendUserName(String uname) {
		userName.sendKeys(uname);
	}

	public static void sendPassWD(String pwd) {
		passWD.sendKeys(pwd);
	}

	public static void clickOnLoginBtn() {
		loginBtn.click();
	}
}
