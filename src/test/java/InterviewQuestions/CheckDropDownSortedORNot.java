package InterviewQuestions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSortedORNot {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.twoplugs.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

		WebElement drpElement = driver.findElement(By.xpath("//select[@name='category_id']"));

		Select dropDown = new Select(drpElement);

		List<WebElement> options = dropDown.getOptions();

		ArrayList orignalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		for (WebElement option : options) {

			orignalList.add(option.getText());
			tempList.add(option.getText());
		}

		System.out.println("Orignal List : " + orignalList);
		System.out.println("temp List : " + tempList);

		Collections.sort(tempList);

		System.out.println("Sorted temp List : " + tempList);

		if (orignalList.equals(tempList)) {

			System.out.println("DropDown Element is Sorted order");
		}

		else {

			System.out.println("DropDown Element is not Sorted order");
		}

		driver.quit();

	}

}
