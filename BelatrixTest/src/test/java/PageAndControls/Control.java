package PageAndControls;

import org.openqa.selenium.WebDriver;

public abstract class Control {
	protected WebDriver webdriver;
	protected String XPath;
	protected int xPosition = 0;
	protected int yPosition = 200;
	
	protected Control(WebDriver pWebdriver, String pXPath) {
		this.webdriver = pWebdriver;
		this.XPath = pXPath;	
	}
	
	public void setXPosition(int pxPosition) {
		this.xPosition = pxPosition;
	}
	
	public void setYPosition(int pyPosition) {
		this.yPosition = pyPosition;
	}

}
