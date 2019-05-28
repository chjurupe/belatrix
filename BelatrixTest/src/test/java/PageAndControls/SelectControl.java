package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectControl extends Control{

	public SelectControl(WebDriver pWebdriver, String pXPath) {
		super(pWebdriver, pXPath);
		// TODO Auto-generated constructor stub
	}
	
	public void selectValueFromBtn(String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		WebElement Select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
		Actions action = new Actions(webdriver);
		action.moveToElement(Select).build().perform();
		
		//Thread.sleep(1000);
		
		String ElementXPath = "//span[text()='" + value + "']//ancestor::li";
		WebElement elementToBeSelected = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementXPath)));
		elementToBeSelected.click();

	}

}
