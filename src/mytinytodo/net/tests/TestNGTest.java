package mytinytodo.net.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import mytinytodo.net.pageobjects.AdvancedTaskPage;
import mytinytodo.net.pageobjects.TasksPage;


public class TestNGTest extends BaseTest {



	@Test(priority=1)
	public void simpleTask() throws InterruptedException {

		WebElement searchTask  = driver.findElement(By.cssSelector("#task"));

		TasksPage taskpage = new TasksPage(driver);
		taskpage.addTaskName("Simple Task");
		searchTask.sendKeys(Keys.RETURN);
	}



	@Test(priority=2)
	public void advancedTask() throws InterruptedException {

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



	@Test(priority=3)
	public void searchTask() throws InterruptedException {

		TasksPage tasksPage = new TasksPage(driver);
		tasksPage.searchTask("edit");

	}

	@Test(priority=4)
	public void newList() throws InterruptedException {

		TasksPage taskpage = new TasksPage(driver);
		taskpage.addNewList("Avichai Davidi");

		AdvancedTaskPage advanced = new AdvancedTaskPage(driver);
		advanced.addAdvancedTask("Find job", "0", "25", "Search for a job with your LinkedIn", "def");
		advanced.addAdvancedTask("boo", "2", "26", "looloo likes booboo", "kshen");
		advanced.howManyTasks();

	}


}
