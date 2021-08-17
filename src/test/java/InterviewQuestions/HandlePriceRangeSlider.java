package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePriceRangeSlider {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));

		System.out.println("Location of min slider is : " + minSlider.getLocation()); // (59, 250)
		System.out.println("Hight and Wi dth of min slider is : " + minSlider.getSize()); // (22, 21)

		Actions act = new Actions(driver);
		act.dragAndDropBy(minSlider, 100, 0).perform();
		act.dragAndDropBy(maxSlider, -100, 0).perform();
		 
	}

}
