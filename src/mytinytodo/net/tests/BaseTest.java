package mytinytodo.net.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {


	WebDriver driver;


	@BeforeClass
	public void openSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.mytinytodo.net/demo/");
	}

	@AfterClass
	public void closeSite() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
