package InterviewQuestions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTesting {

	public static void main(String[] args) throws SQLException {

		// Data
		String cust_firstname = "John";
		String cust_lastname = "Kendey";
		String cust_email = "john00@gmail.com";
		String cust_telephone = "123456789";
		String cust_password = "john123";

		// User registration

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.id("input-firstname")).sendKeys(cust_firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(cust_lastname);
		driver.findElement(By.id("input-email")).sendKeys(cust_email);
		driver.findElement(By.id("input-telephone")).sendKeys(cust_telephone);
		driver.findElement(By.id("input-password")).sendKeys(cust_password);
		driver.findElement(By.id("input-confirm")).sendKeys(cust_password);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		try {
			String congMsg = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))
					.getText();

			if (congMsg.equals("Your Account Has Been Created!")) {

				System.out.println("Registration Success from the UI/Application");
			} else {

				System.out.println("Registration Not Successful from UI/Application");
			}
		} catch (Exception e) {

			System.out.println("Some Problem in the Application");
		}

		// DataBase validation
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");

		Statement stmt = con.createStatement();

		String query = "select firstname,lastname,email,telphone from oc_customer";
		ResultSet rs = stmt.executeQuery(query); // Return the resultSet

		boolean status = false;

		while (rs.next()) {

			String firstName = rs.getString("firstname");
			String lastName = rs.getString("lastname");
			String email = rs.getString("email");
			String telePhone = rs.getString("telephone");

			if (cust_firstname.equals(firstName) && (cust_lastname.equals(lastName)
					&& (cust_email.equals(email) && (cust_telephone.equals(telePhone))))) {

				System.out.println("Records found in the table || Test Passed");
				status = true;
				break;
			}

		}

		if (status == false) {

			System.out.println("Record Not Found || Test Failed");
		}
	}

}
