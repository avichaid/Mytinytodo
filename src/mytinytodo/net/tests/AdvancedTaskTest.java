package mytinytodo.net.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import mytinytodo.net.pageobjects.AdvancedTaskPage;

public class AdvancedTaskTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.mytinytodo.net/demo/");

		TaskInfo[] tasksInfo = new TaskInfo[5];

		tasksInfo[0] = new TaskInfo("Meet Gal", "-1", "22", "Meet gal and tell him about your plan", "abc");
		tasksInfo[1] = new TaskInfo("Edit LinkedIn", "0", "23", "You must update your LinkedIn account", "def");
		tasksInfo[2] = new TaskInfo("Find job", "0", "24", "Search for a job with your LinkedIn", "def");
		tasksInfo[3] = new TaskInfo("Finish project", "1", "25", "Finish at least one project", "ghi");
		tasksInfo[4] = new TaskInfo("Edit LinkedIn", "2", "26", "You must update your LinkedIn account", "jkl");



		AdvancedTaskPage advancedTaskPage = new AdvancedTaskPage(driver);

		for (int i = 0; i < tasksInfo.length; i++) {
			advancedTaskPage.addAdvancedTask(tasksInfo[i].getTaskName(), tasksInfo[i].getPriority(), tasksInfo[i].getDay(), tasksInfo[i].getNote(), tasksInfo[i].getTag());
		}

		advancedTaskPage.searchTag("def");
		advancedTaskPage.howManyTasks();

	}

}
