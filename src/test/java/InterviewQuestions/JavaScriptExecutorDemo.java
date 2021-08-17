package InterviewQuestions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

//		// Syntax
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(Script, args);

		// Flash(Keep on highlighting the element) element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flash(logo, driver);

		// Drawing border around the element and take ScreenShot

		WebElement logo1 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.drawBorder(logo1, driver);

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./ScreenShots/logowithborder.png");
		FileUtils.copyFile(src, trg);

		// get the title of the Page
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);

		// click action also
		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		JavaScriptUtil.clickElementByJS(register, driver);

		// Generate an alert
		JavaScriptUtil.genrateAlert(driver, "This is my Alert.....");

		// Refreshing the page
		JavaScriptUtil.refreshBrowserByJS(driver);

		// Scrolling the page down
		JavaScriptUtil.scrollPageDown(driver);

		// Scrolling the page up
		JavaScriptUtil.scrollPageUp(driver);

		// zoom the page
		JavaScriptUtil.zoomPageByJS(driver);

	}

}
