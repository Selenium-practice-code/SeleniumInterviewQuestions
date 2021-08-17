package InterviewQuestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// First find all links on the webPage then find the broken link

		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinks = 0;

		for (WebElement element : links) {

			String url = element.getAttribute("href");

			if (url == null || url.isEmpty()) {

				System.out.println("URL is empty");
				continue;
			}

			URL link = new URL(url);

			try {

				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();

				if (httpconn.getResponseCode() >= 400) {

					System.out.println(httpconn.getResponseCode() + url + "  is" + "  Broken link");
					brokenLinks++;

				}

				else {

					System.out.println(httpconn.getResponseCode() + url + "  is" + "  Valid link");
				}

			} catch (Exception e) {

			}

		}

		System.out.println("No of broken links is : " + brokenLinks);
		driver.quit();

	}

}
