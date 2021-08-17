package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

		// Location - Method1
		System.out.println(logo.getLocation());
		System.out.println(logo.getLocation().getX());
		System.out.println(logo.getLocation().getY());

		// Location - Method2
		System.out.println(logo.getRect().getX());
		System.out.println(logo.getRect().getY());

		// Size - Menthod1
		System.out.println(logo.getSize());
		System.out.println(logo.getSize().getHeight());
		System.out.println(logo.getSize().getWidth());

		// Size - Menthod2
		System.out.println(logo.getRect().getDimension().getHeight());
		System.out.println(logo.getRect().getDimension().getWidth());

		driver.quit();

	}

}
