package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElemnetVsFindElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		// Find Element() -- Return a single webElement

		// 1
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchBox.sendKeys("Nokia");

		// 2
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footer.getText());

		// Find Elements() -- Return a multiple web elements

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(links.size());

		for (WebElement ele : links) {

			System.out.println(ele.getText());

		}
	}

}
