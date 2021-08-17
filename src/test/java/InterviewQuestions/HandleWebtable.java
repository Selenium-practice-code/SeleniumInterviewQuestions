package InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sumitagnihotri
 * 
 *         How many rows in a table? how many column in a table? Retrieve
 *         specific column/row data Retrieve all the data form the table Print
 *         release date, version no of java language of Selenium
 */
public class HandleWebtable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1) How many rows in a table?

		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Number of Rows is : " + rows);

		// 2) how many column in a table?

		int columns = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
		System.out.println("Number of Columns in a Table : " + columns);

		// 3) Retrieve specific column/row dat

		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("The value is : " + value);

		// 4) Retrieve all the data form the table Print

		System.out.println("Data from the table .................");

		for (int r = 1; r <= rows; r++) { // increment of rows 1 2

			for (int c = 1; c <= columns; c++) { // increment of columns 1 2 3 4 5 6..

				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(data + "   ");

			}

			System.out.println();
		}

		// 5) release date, version no of java language of Selenium

		for (int r = 1; r <= rows; r++) {

			String language = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[1]"))
					.getText();

			if (language.equals("Java")) {

				String versionNo = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[2]"))
						.getText();
				String releaseDate = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[3]"))
						.getText();
				System.out.println(language + "   " + versionNo + "  " + releaseDate );
			}

		}

		driver.quit();

	}

}
