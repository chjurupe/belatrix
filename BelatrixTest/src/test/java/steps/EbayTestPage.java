package steps;

import java.awt.Point;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import PageAndControls.CheckboxControl;
import PageAndControls.Page;
import PageAndControls.TextControl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class EbayTestPage extends Page
{
	private String EbayUrlPath = "https://www.ebay.com";
	
	private String XPathSearchText = "//input[@name='_nkw']";
	private String XPathSearchCounterElement = "//h1[@class='srp-controls__count-heading']";
	private String XPathBrandSearchText = "//li[@name='Brand']//input[@type='checkbox'][@aria-label='REPLACEBYBRAND']";
	private String XPathBrandFilterCarousell= "//a[@class='srp-carousel-list__item-link--truncated-small-item']/div[text()='REPLACEBYBRAND']";
	private String XPathStatusSearchText = "//h3[text()='Estado']//ancestor::li[1]//span[text()='REPLACEBYSTATUS']//ancestor::li[1]";
	
	
	
	
	
	private String BrandFilterValue = "";
	
	//---- Controls Definitions ----//
	TextControl textControl;
	CheckboxControl checkboxControl;
	

	public EbayTestPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^User is on Ebay Page$")
    public void user_is_on_ebay_page() throws Throwable {
    	webdriver.navigate().to(EbayUrlPath);
    }

	@When("^User search for \"([^\"]*)\"$")
    public void user_search_for_something(String itemtosearch) throws Throwable {
		textControl = new TextControl(webdriver, XPathSearchText);
		textControl.setText(itemtosearch);
    }

    @Then("^Ebay Page displays the list$")
    public void ebay_page_displays_shoes_category() throws Throwable {
    	waitUntilElementExists(XPathSearchCounterElement);
    }
    
	@When("^User select Brand \"([^\"]*)\"$")
    public void user_search_for_brand(String BrandSeleted) throws Throwable {
		BrandFilterValue = BrandSeleted;
		String BrandXPath = XPathBrandSearchText.replace("REPLACEBYBRAND",BrandSeleted);  
		
		scrollPage(webdriver, 200, 400);

		checkboxControl = new CheckboxControl(webdriver, BrandXPath);
		checkboxControl.CheckItem();
    }
	
    @Then("^Ebay Page displays the brand list$")
    public void ebay_page_displays_brand_list() throws Throwable {
    	String BrandXPath = XPathBrandFilterCarousell.replace("REPLACEBYBRAND",BrandFilterValue);
    	waitUntilElementExists(BrandXPath);
    }
    
	@When("^User select Status \"([^\"]*)\"$")
    public void user_search_for_status(String StatusSeleted) throws Throwable {
		BrandFilterValue = StatusSeleted;
		String BrandXPath = XPathStatusSearchText.replace("REPLACEBYSTATUS",StatusSeleted);  
		
		scrollPage(webdriver, 200, 400);

		checkboxControl = new CheckboxControl(webdriver, BrandXPath);
		checkboxControl.CheckItem();
    }

}
