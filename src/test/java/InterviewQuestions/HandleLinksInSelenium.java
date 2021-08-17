package InterviewQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinksInSelenium {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.findElement(By.linkText("Electronics")).click();
		// driver.findElement(By.partialLinkText("Sellers")).click();

		// How to capture all the links on webPage

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("links on the WebPage : " + links.size());

		// Normal For loop

//		for (int i = 0; i <= links.size(); i++) {
//
//			System.out.println(links.get(i).getText());
//			System.out.println(links.get(i).getAttribute("href"));
//
//		}
		
		for(WebElement link : links) {
			
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}

	}

}
