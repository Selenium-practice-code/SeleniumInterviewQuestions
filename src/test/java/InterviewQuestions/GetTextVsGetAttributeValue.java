package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttributeValue {

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/login");
		
		WebElement email = driver.findElement(By.id("Email"));
		
		email.clear();
		email.sendKeys("abc@gmail.com");
		
		// Capturing the text from input box

		System.out.println(email.getAttribute("name"));
		
		System.out.println(email.getText());
	}

}
