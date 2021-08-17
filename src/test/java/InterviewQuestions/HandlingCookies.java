package InterviewQuestions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		// How to capture cookies from browser ?

		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies : " + cookies.size());

		// How to print(name & value) cookies from browser ?
		for (Cookie cookie : cookies) {

			System.out.println(cookie.getName() + " :  " + cookie.getValue());
		}

		// How add cookie to the browser ?
		Cookie cookieObj = new Cookie("SumitCookie", "12345678");
		driver.manage().addCookie(cookieObj);

		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after adding cookie : " + cookies.size());

		// how to delete specific cookie from the browser?
		driver.manage().deleteCookie(cookieObj);
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting cookie by CookieObject : " + cookies.size());

		driver.manage().deleteCookieNamed("_ga");
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting cookie by Name : " + cookies.size());

		// Delete ALL cookies

		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting all cookie : " + cookies.size());

		driver.quit();

	}

}
