package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Flogin");

		WebElement dayDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		WebElement monthDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		WebElement yearDrp = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

		Select DrpCont = new Select(dayDrp);
//		Select DrpMon = new Select(monthDrp);
//		Select DrpYear = new Select(yearDrp);
//
//		DrpCont.selectByVisibleText("5");
//		DrpMon.selectByIndex(5);
//		DrpYear.selectByValue("1995");

		// Selecting Option from DropDown without using methods

		List<WebElement> allOptions = DrpCont.getOptions();

		for (WebElement option : allOptions) {

			if (option.getText().equals("7")) {

				option.click();
				break;

			}

		}

	}

}
