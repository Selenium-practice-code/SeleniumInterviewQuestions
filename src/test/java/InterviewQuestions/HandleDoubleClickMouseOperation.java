package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDoubleClickMouseOperation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

		driver.switchTo().frame("iframeResult");

		WebElement field1 = driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("Welcome to Selenium");

		WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		Actions act = new Actions(driver);
		act.doubleClick(copyText).perform();
	}

}
