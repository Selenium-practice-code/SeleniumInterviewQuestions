package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdownGenricMethod {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hdfcbank.com/");

		// Product Types
		driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();

		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		selectFromBootStrapDropDropdown(productTypes, "Accounts");

		// Products
		driver.findElement(By.xpath("//a[normalize-space()='Select Product']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		selectFromBootStrapDropDropdown(products, "InstaAccount");

	}

	public static void selectFromBootStrapDropDropdown(List<WebElement> options, String value) {

		for (WebElement option : options) {

			if (option.getText().equals(value)) {

				option.click();
				break;
			}
		}

	}

}
