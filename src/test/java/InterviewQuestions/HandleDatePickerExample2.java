package InterviewQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePickerExample2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String year = "1985";
		String month = "Apr";
		String date = "18";
		

		driver.findElement(By.id("dob")).click(); // Open the date picker

		Select monthDrp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthDrp.selectByVisibleText(month);

		Select yearDrp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yearDrp.selectByVisibleText(year);

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement dates : allDates) {

			String dt = dates.getText();

			if (dt.equals(date)) {

				dates.click();
				break;
			}
		}

	}

}
