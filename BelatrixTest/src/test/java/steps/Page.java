package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {
	
	protected final WebDriver webdriver;
	
	public Page() {
		System.setProperty("webdriver.chrome.driver","C:\\WorkSpaceQA\\BelatrixTest\\chromedriver\\chromedriver.exe");
		this.webdriver = new ChromeDriver();
	}
	

}
