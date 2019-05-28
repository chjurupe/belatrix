package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabelControl extends Control{

	public LabelControl(WebDriver pWebdriver, String pXPath) {
		super(pWebdriver, pXPath);
		// TODO Auto-generated constructor stub
	}
	
	public String getValue() {
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
		
		return label.getText();
	}

}
