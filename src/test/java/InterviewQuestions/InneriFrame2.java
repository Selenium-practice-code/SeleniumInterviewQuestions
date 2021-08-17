package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InneriFrame2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("iframeResult"); // Switch to outer iframe
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		driver.switchTo().frame(innerFrame);

		System.out.println("Inner iframe text is : " + driver.findElement(By.xpath("//h1")).getText());

		driver.switchTo().parentFrame();

		System.out.println("Outer iFrame Text is : " + driver.findElement(By.cssSelector("body p")).getText());
		
		driver.quit();

	}

}
