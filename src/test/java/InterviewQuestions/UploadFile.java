package InterviewQuestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();

		// Upload a File using Send Keys(When Type = file is available in DOM)
//		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
//		uploadFile.sendKeys("/Users/sumitagnihotri/Downloads/file-sample_100kB.doc");

		// USing Robot class method
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file-upload']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadFile);

		/*
		 * 1- Copy the path 2- CTRL + V 3- press Enter Button
		 * 
		 */

		Robot robot = new Robot();
		robot.delay(2000);

		// Put path the file in Clip-board
		StringSelection ss = new StringSelection("/Users/sumitagnihotri/Downloads/file-sample_100kB.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// CTRL + V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
