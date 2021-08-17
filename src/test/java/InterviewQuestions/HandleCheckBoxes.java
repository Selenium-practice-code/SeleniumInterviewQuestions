package InterviewQuestions;

import java.awt.Checkbox;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBoxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Select specific CheckBox

		// driver.findElement(By.id("monday")).click();

		// Select all the CheckBoxes

		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total No of checkboxes: " + checkBoxes.size());

		// using loop
//
//		for (int i = 0; i < checkBoxes.size(); i++) {
//
//			checkBoxes.get(i).click();
//		}

		// using for each

//		for(WebElement checkbox : checkBoxes) {
//			
//			checkbox.click();
//		}
//		
		// Check multiple check box by choice

//		for (WebElement checkbox : checkBoxes) {
//
//			String value = checkbox.getAttribute("id");
//
//			if (value.equals("monday") || value.equals("sunday")) {
//
//				checkbox.click();
//			}
//
//		}

		// Select last 2 check boxes

		// Formula : total number of check boxes - no of check boxes you want to select

		int totalCheckboxes = checkBoxes.size();
//
//		for (int i = totalCheckboxes - 2; i < totalCheckboxes; i++) {
//
//			checkBoxes.get(i).click();
//
//		}

		// Select first 2 check boxes

		for (int i = 0; i < totalCheckboxes; i++) {

			if (i < 2) {
				checkBoxes.get(i).click();
			}
		}
	}

}
