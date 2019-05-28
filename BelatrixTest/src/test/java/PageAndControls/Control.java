package PageAndControls;

import org.openqa.selenium.WebDriver;

public abstract class Control {
	protected WebDriver webdriver;
	protected String XPath;
	
	protected Control(WebDriver pWebdriver, String pXPath) {
		this.webdriver = pWebdriver;
		this.XPath = pXPath;	
	}
	

}
