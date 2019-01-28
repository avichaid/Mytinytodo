package mytinytodo.net.tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import mytinytodo.net.pageobjects.AdvancedTaskPage;
import mytinytodo.net.pageobjects.TasksPage;

public class NewListTest {

	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.mytinytodo.net/demo/");

		TasksPage taskpage = new TasksPage(driver);
		taskpage.addNewList("Avichai Davidi");

		AdvancedTaskPage advanced = new AdvancedTaskPage(driver);
		advanced.addAdvancedTask("Find job", "0", "25", "Search for a job with your LinkedIn", "def");
		advanced.addAdvancedTask("boo", "2", "26", "looloo likes booboo", "kshen");
		advanced.howManyTasks();


	}

}
