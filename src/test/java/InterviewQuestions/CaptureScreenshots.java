package InterviewQuestions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// full Page ScreenShot

//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File trg = new File("./ScreenShots/homepage.png");
//		FileUtils.copyFile(src, trg);

		// ScreenShot of section/portion of page

//		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//		File src = section.getScreenshotAs(OutputType.FILE);
//		File trg = new File("./ScreenShots/featureProducts.png");
//		FileUtils.copyFile(src, trg);

		// ScreenShot of Webelement

		WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		File trg = new File("./ScreenShots/logo.png");
		FileUtils.copyFile(src, trg);

		driver.quit();

	}

}
