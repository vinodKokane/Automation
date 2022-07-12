package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "(//button[contains(@class,'btn')])[1]")
	private static WebElement addToCartBtn;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private static WebElement BasketBtn;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private static WebElement inventory;

	@FindBy(id = "react-burger-menu-btn")
	private static WebElement menuBtn;

	@FindBy(id = "logout_sidebar_link")
	private static WebElement logOutBtn;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void clickOnAddtoCartBtn() {
		addToCartBtn.click();
	}

	public static void clickOnBasketBt() {
		BasketBtn.click();
	}

	public static String itemType() {
		String itemName = inventory.getText();
		return itemName;
	}

	public static void menuBtn() {
		menuBtn.click();
	}

	public static void logOutbtn() {
		logOutBtn.click();

	}
}
