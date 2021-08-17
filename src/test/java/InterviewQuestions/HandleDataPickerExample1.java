package InterviewQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDataPickerExample1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String year = "2022";
		String month = "Dec";
		String date = "31";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click(); // Open the date Picker

		while (true) {

			String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();

			String arr[] = monthYear.split(" ");
			String mnth = arr[0];
			String yr = arr[1];

			if (mnth.equalsIgnoreCase(month) && yr.equals(year))
				break;

			else

				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}

		// Date Selection
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement dates : allDates) {

			String dt = dates.getText();

			if (dt.equals(date)) {

				dates.click();
				break;
			}
		}

	}

}
