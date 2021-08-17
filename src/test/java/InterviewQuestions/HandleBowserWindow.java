package InterviewQuestions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBowserWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// getWindowHandle()
//
//		String windowID = driver.getWindowHandle();
//
//		System.out.println(windowID);

		// get window handles()
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // Open another browser window
																							// - child window

		Set<String> windowsIDs = driver.getWindowHandles();

		// 1 -Iterator method
//
//		Iterator<String> it = windowsIDs.iterator();
//
//		String parentWindowID = it.next();
//		String childWindowID = it.next();
//
//		System.out.println("Parent window ID : " + parentWindowID);
//		System.out.println("Child window ID : " + childWindowID);

		// Second menthod using List/ArrayList
//		
//		List<String> windowIds = new ArrayList(windowsIDs);
//		
//		String parentWindowIDs = windowIds.get(0);
//		String childWindowIDs = windowIds.get(1);
//		
//		System.out.println("Parent window ID : " + parentWindowIDs);
//		System.out.println("Child window ID : " + childWindowIDs);

		// how to use windowIDs for switching purpose

//		driver.switchTo().window(parentWindowID);
//		System.out.println("Parent Window Title is : " + driver.getTitle());
//
//		driver.switchTo().window(childWindowID);
//		System.out.println("Child Window Title is : " + driver.getTitle());

		// For each Loop

		for (String windowID : windowsIDs) {

			String title = driver.switchTo().window(windowID).getTitle();
			System.out.println(title);
		}

	}
}
