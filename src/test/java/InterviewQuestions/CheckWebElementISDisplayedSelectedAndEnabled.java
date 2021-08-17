package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckWebElementISDisplayedSelectedAndEnabled {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register");

		// is Displayed() is Enabled()

		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));

		System.out.println("Satus of the search Store is: " + searchStore.isDisplayed());
		System.out.println("Satus of the search Store is: " + searchStore.isEnabled());
		
		// is Selected()
		
		WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='gender-male']"));
		System.out.println("Status of checkbox is :" + maleCheckBox.isSelected());
		
		WebElement femaleCheckBox = driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Status of checkbox is :" + femaleCheckBox.isSelected());
		
		maleCheckBox.click();
		System.out.println("Status of checkbox is :" + maleCheckBox.isSelected());
		System.out.println("Status of checkbox is :" + femaleCheckBox.isSelected());
		
		femaleCheckBox.click();
		System.out.println("Status of checkbox is :" + maleCheckBox.isSelected());
		System.out.println("Status of checkbox is :" + femaleCheckBox.isSelected());
		
		


		 
	}

}
