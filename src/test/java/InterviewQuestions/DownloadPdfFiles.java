package InterviewQuestions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPdfFiles {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "/Downloads/";
		// For Chrome
		HashMap prefrences = new HashMap();
		prefrences.put("plugins.always_open_pdf_externally", true); // for PDF download
		prefrences.put("download.default_directory", location);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefrences);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		// For FireFox
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("pdfjs.disabled", true); // for PDF download
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");// mime type
		profile.setPreference("browser.download.folderList", 2); // 0 - desktop 1- downloadFolder 2 - desired location
		profile.setPreference("browser.download.dir", location);

		FirefoxOptions optionss = new FirefoxOptions();
		optionss.setProfile(profile);

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

	}
}
