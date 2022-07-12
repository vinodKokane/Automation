package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility1 {
	public static String getDataFromProperty(String key) throws IOException {

		Properties pro = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Janewari2010\\propertiesFile.properties");

		pro.load(fis);

		String value = pro.getProperty(key);

		return value;

	}

	public static void waitMethod(int time, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
	}

	public static void tearDown(WebDriver driver) {
		driver.quit();
	}

	public static void screenShots(String name, String str, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\Img_" + name + str + ".png");
		FileHandler.copy(src, dest);
	}
}
