package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdowns {

	public static void main(String[] args) {

		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Flogin");

		WebElement dayDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		selectFromDropDown(dayDrp, "10");

		WebElement monthDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		selectFromDropDown(monthDrp, "April");

		WebElement yearDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		selectFromDropDown(yearDrp, "1995");

	}

	public static void selectFromDropDown(WebElement ele, String value) {

		Select drp = new Select(ele);

		List<WebElement> allOptions = drp.getOptions();

		for (WebElement option : allOptions) {

			if (option.getText().equals(value)) {

				option.click();
				break;
			}
		}

	}

}
