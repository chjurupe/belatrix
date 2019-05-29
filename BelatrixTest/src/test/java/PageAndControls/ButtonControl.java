package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonControl extends Control{

	public ButtonControl(WebDriver pWebdriver, String pXPath) {
		super(pWebdriver, pXPath);
		// TODO Auto-generated constructor stub
	}
	
	public void click() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
		
		button.click();		
	}

}
