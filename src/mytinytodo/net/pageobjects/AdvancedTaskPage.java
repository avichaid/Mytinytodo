package mytinytodo.net.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedTaskPage extends BasePage {

	@FindBy(css="#newtask_adv")
	WebElement btnAdvancedTask;

	@FindBy(css="[name='prio']")
	WebElement selectPrioElement;

	@FindBy(css=".ui-datepicker-trigger")
	WebElement dateElement;

	@FindBy(xpath=".//div[4]/input")
	WebElement taskNameElement;

	@FindBy(css="[name='note']")
	WebElement noteElement;

	@FindBy(css=".ui-datepicker-trigger")
	WebElement btnCalendar;

	@FindBy(css="#edittags")
	WebElement tagsTextElement;

	@FindBy(css=".alltags-cell")
	WebElement allTagsCellElement;

	@FindBy(css="[value='Save']")
	WebElement btnSaveElement;





	public AdvancedTaskPage(WebDriver driver) {
		super(driver);
	}

	public void addAdvancedTask(String taskName,String priorityValue,String day,String note, String tag) throws InterruptedException {
		click(btnAdvancedTask);
		Thread.sleep(1000);
		selectPriority(selectPrioElement, priorityValue);
		fillText(taskNameElement, taskName);
		click(btnCalendar);
		WebElement btnDay = driver.findElement(By.linkText(day));
		click(btnDay);
		fillText(noteElement,note);
		fillText(tagsTextElement, tag);
		click(btnSaveElement);

	}

}
