package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextControl extends Control {

	public TextControl(WebDriver pWebdriver, String pXPath) {
		super(pWebdriver, pXPath);
		// TODO Auto-generated constructor stub
	}
	
	public void setText(String value) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		WebElement inputText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
		inputText.clear();
		inputText.sendKeys(value);
		Thread.sleep(1000);
		inputText.sendKeys(Keys.ENTER);
		
	}

}
