package openCartProject.baseOpenCart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import openCartProject.utilityOpenCart.UtilityOpenCart;

public class BaseClassOpenCart {
	protected static WebDriver driver;

	public static void LaunchBrowser(String type) throws IOException, InterruptedException {
		if (type.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} 
		else if (type.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(UtilityOpenCart.property("Url"));
		Thread.sleep(2000);
	}
	
	public static  void tearDown() {
		driver.close();
	}
}
