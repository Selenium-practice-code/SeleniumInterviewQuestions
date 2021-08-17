package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionsMultipleKeys {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		WebElement inputText1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement inputText2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		inputText1.sendKeys("Welcome to Selenium Automation.");

		Actions act = new Actions(driver);

		// CTRL + A
		act.keyDown(Keys.COMMAND);
		act.sendKeys("a");
		act.keyUp(Keys.COMMAND);
		act.perform();

		// CTRL + C
		act.keyDown(Keys.COMMAND);
		act.sendKeys("c");
		act.keyUp(Keys.COMMAND);
		act.perform();

		// Press TAB - Swift to inputText2
		act.sendKeys(Keys.TAB).perform();

		// CTRL + V
		act.keyDown(Keys.COMMAND);
		act.sendKeys("v");
		act.keyUp(Keys.COMMAND);
		act.perform();

		// Compare Text

		if (inputText1.getAttribute("value").equals(inputText2.getAttribute("value")))
			System.out.println("Text Copied");
		else
			System.out.println("Text Not Copied");

		driver.quit();
	}

}
