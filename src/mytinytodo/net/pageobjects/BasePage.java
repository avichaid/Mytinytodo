package mytinytodo.net.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
	WebDriver driver;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void click(WebElement el) {
		el.click();
	}

	public void fillText(WebElement el, String text) throws InterruptedException {
		Thread.sleep(1000);
		el.clear();
		el.sendKeys(text);
	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public void selectPriority(WebElement el,String value) {
		Select dropdown = new Select(el);
		dropdown.selectByValue(value);

	}

	public void searchTag(String tag) {

		WebElement btnTags = driver.findElement(By.cssSelector("#tagcloudbtn"));
		click(btnTags);
		List<WebElement> tagsListElement = driver.findElements(By.cssSelector("#tagcloudcontent>a"));

		System.out.println(tagsListElement.size()+" tags");
		int count =0; 
		for (int i = 0; i < tagsListElement.size(); i++) {
			System.out.println(tagsListElement.get(i).getText());
			if(tagsListElement.get(i).getText().equals(tag))
				count++;
		}
		System.out.println("Tag "+tag+ " found "+count+" time");
		click(btnTags);

	}

	public void howManyTasks() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> tasksListElement = driver.findElements(By.cssSelector(".task-title"));
		System.out.println(tasksListElement.size()+" tasks");

	}
}
