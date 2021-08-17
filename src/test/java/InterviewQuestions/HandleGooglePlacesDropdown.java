package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleGooglePlacesDropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://twoplugs.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");

		String text;

		do {

			searchBox.sendKeys(Keys.ARROW_DOWN);
			text = searchBox.getAttribute("value");

			if (text.equals("Toronto, OH, USA")) {

				searchBox.sendKeys(Keys.ENTER);
				break;
			}

		} while (!text.isEmpty());
	}

}
