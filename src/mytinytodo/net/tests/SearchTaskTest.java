package mytinytodo.net.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mytinytodo.net.pageobjects.TasksPage;

public class SearchTaskTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.mytinytodo.net/demo/");

		TasksPage tasksPage = new TasksPage(driver);
		tasksPage.searchTask("edit");

	}

}
