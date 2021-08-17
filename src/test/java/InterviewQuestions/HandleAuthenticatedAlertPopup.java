package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAuthenticatedAlertPopup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 
		
		// Syntax :- "http://admin:admin@the-internet.herokuapp.com/basic_auth"
		// http://username:password@URL
		
		

	}

}
