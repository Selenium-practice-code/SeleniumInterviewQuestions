package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sumitagnihotri 1) How to find total number of pages ? 2)
 */
public class DynamicWebtableWithPagination {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Login the application
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");

		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement sales = driver.findElement(By.xpath("//a[normalize-space()='Sales']"));
		sales.click();

		WebElement orders = driver.findElement(By.xpath("//a[normalize-space()='Orders']"));
		orders.click();

		// 1) Find total number of pages

		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);

		int totalPages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println("Total Number of Pages is : " + totalPages);

		for (int p = 1; p <= 5; p++) {

			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active Page : " + activePage.getText());
			activePage.click();

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"))
					.size();
			System.out.println("Number of Rows : " + rows);

			// read all the rows form each page

			for (int r = 1; r <= rows; r++) {

				String orderID = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				String customerName = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				String status = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
						.getText();

				if (status.equals("Pending")) {

					System.out.println(orderID + "   " + customerName + "   " + status);

				}

			}

			String pageNo = Integer.toString(p + 1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageNo + "']")).click();

		}

		driver.quit();
	}

}
