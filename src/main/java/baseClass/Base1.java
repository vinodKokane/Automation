package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityClass.Utility1;

public class Base1 {
	static protected WebDriver driver;

	public void launchBrowserChrome() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Reporter.log("Chrome Launched......", true);
		driver.get(Utility1.getDataFromProperty("URL"));
		Utility1.waitMethod(20, driver);
	}

	public void launchBrowserfirefox() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		Reporter.log("Firefox launched.....", true);
		driver.get(Utility1.getDataFromProperty("URL"));
		Utility1.waitMethod(20, driver);
	}

}