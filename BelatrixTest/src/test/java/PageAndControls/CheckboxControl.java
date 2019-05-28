package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxControl extends Control{

	public CheckboxControl(WebDriver pWebdriver, String pXPath) {
		super(pWebdriver, pXPath);
		// TODO Auto-generated constructor stub
	}
	
	public void CheckItem() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
		checkBox.click();
		
	}
	

}
