package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDowns {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hdfcbank.com/");

		driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();

		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

		System.out.println("No of options is : " + productTypes.size());

		for (WebElement ele : productTypes) {

			if (ele.getText().equals("Accounts")) {

				ele.click();
				break;
			}

		}

		driver.findElement(By.xpath("//a[normalize-space()='Select Product']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));

		for (WebElement product : products) {

			if (product.getText().equals("InstaAccount")) {

				product.click();
				break;
			}
		}

	}

}
