package listenerUse;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClass.Base1;
import net.bytebuddy.utility.RandomString;
import utilityClass.Utility1;

public class Listener extends Base1 implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		String str2 = RandomString.make(3);
		Reporter.log("Test Case Is Passed...", true);
		try {
			Utility1.screenShots(str2, result.getName(), driver);
			Reporter.log("Passed Test So Screen Is captured,,,",true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		String str = RandomString.make(3);
		Reporter.log("Sorry the " + result.getName() + " is Failed.. ", true);
		try {

			Utility1.screenShots(result.getName(), str, driver);
			Reporter.log("ScreenShot is Taken....!!!", true);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String str3 = RandomString.make(3);
		Reporter.log("Skipped Test Case...", true);
		try {
			Utility1.screenShots(str3, result.getName(), driver);
			Reporter.log("ScreenShot is Taken...",true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
