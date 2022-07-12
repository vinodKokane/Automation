package openCartProject.utilityOpenCart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class UtilityOpenCart {
	public static void captureScreen(WebDriver driver) throws IOException {

		String str = RandomString.make(3);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File(".\\Screenshots\\OpenCartScreen\\OpenCart_" + str + ".png");

		FileHandler.copy(src, dest);
	}

	public static String property(String keys) throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vinod\\eclipse-workspace\\Janewari2010\\OpenCartPro.properties");
		
		pro.load(fis);
		
		String value =pro.getProperty(keys);
		return value;
	}
}