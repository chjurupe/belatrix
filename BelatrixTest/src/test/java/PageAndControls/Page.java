package PageAndControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Page {
	
	protected final WebDriver webdriver;
	
	public Page() {
		System.setProperty("webdriver.chrome.driver","C:\\WorkSpaceQA\\BelatrixTest\\chromedriver\\chromedriver.exe");
		this.webdriver = new ChromeDriver();
		this.webdriver.manage().window().maximize();
	}
	
	public void waitUntilElementExists(String XPath) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(webdriver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));
	}
	
	public static void scrollPage(WebDriver webdriver, int xPosition, int yPosition) {
		((JavascriptExecutor) webdriver).executeScript("window.scrollBy(" + xPosition + "," + yPosition + ")","");
	}
	

}
