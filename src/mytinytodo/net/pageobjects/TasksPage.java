package mytinytodo.net.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TasksPage extends BasePage {
	@FindBy(css="#task")
	WebElement taskNameField;

	@FindBy(css="#newtask_adv")
	WebElement btnNewAdvancedTask;

	@FindBy(css=".mtt-tabs>li:last-child")
	WebElement theNewTab;


	public TasksPage(WebDriver driver) {
		super(driver);
	}


	public void addTaskName (String taskName) throws InterruptedException {
		fillText(taskNameField, taskName);
	}

	public void searchTask (String taskName) throws InterruptedException {
		WebElement searchTask = driver.findElement(By.cssSelector("#search"));
		fillText(searchTask, taskName);
		howManyTasks();	
	}

	public void addNewList(String listName)  {
		WebElement newList  = driver.findElement(By.cssSelector(".mtt-tabs-add-button"));
		click(newList);
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert: "+alert.getText());
		alert.sendKeys(listName);
		alert.accept();
		driver.navigate().refresh();
		click(theNewTab);
	}



}
