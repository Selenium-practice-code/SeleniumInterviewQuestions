package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePops {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Alert window with oK button

//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();

		// Alert window with oK and cancel button

//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Thread.sleep(2000);
//		//driver.switchTo().alert().accept(); // Close alert by using OK button
//		driver.switchTo().alert().dismiss(); // Close alert by using Cancel button

		// Alert window with input box and capture the text

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		System.out.println("Message Displaced on Alert : " + alert.getText());
		alert.sendKeys("Welcom in alert");
		Thread.sleep(3000);
		alert.accept();

	}

}
