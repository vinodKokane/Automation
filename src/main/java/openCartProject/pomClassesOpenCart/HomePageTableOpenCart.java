package openCartProject.pomClassesOpenCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePageTableOpenCart {

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//thead//tr//td")
	static private List<WebElement> cellCount;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr//td")
	static private List<WebElement> rowCount;

	@FindBy(xpath = "//a[text()='>']")
	private static WebElement nextBtn;

	public HomePageTableOpenCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	static public int numbersOfRow() {

		int row = rowCount.size();
		return row;
	}

	static public int numbersOfCell() {

		int cell = cellCount.size();

		return cell;
	}

	static public Object[][] showTableData(WebDriver driver) {
		
		int r = numbersOfRow();
		
		int c = numbersOfCell();
		
		Object a[][] = new Object[r][c];
		
		for (int i = 2; i < r; i++) {
			for (int j = 1; j < c; j++) {
				String value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[" + j + "]"))
						.getText();
				
				a[i][j] = value;
			}
		}
		return a;
	}

	public static void clickOnNextBtn() {

		nextBtn.click();
		Reporter.log("Click on Customer Sub Menu tab ...", true);
	}
}
