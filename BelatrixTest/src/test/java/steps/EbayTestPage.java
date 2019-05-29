package steps;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PageAndControls.ButtonControl;
import PageAndControls.CheckboxControl;
import PageAndControls.LabelControl;
import PageAndControls.Page;
import PageAndControls.SelectControl;
import PageAndControls.TextControl;
import cucumber.api.java.en.And;
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
	private String XPathRecordsLabel = "//h1[@class='srp-controls__count-heading']";
	private String XPathSort = "//div[@id='w4-w3']/button";
	//private String XPathProductListToBuy = "//span[contains(@class,'purchaseOptions')][text()='Buy It Now']//ancestor::li[contains(@id, 'srp-river-results-listing')]";
	private String XPathAddToShoppingCartbtn = "//*[@id='isCartBtn_btn']";
	private String XPathProdBuyItNowItem = "((//span[contains(@class,'purchaseOptions')][contains(text(),'Cómpralo ahora')]|//span[contains(@class,'purchaseOptions')][contains(text(),'Buy It Now')])//ancestor::li[contains(@id, 'srp-river-results-listing')]//img)[INDEXTOREPLACE]";
	private String XPathProductTakenList = "(//div[@class='s-item__info clearfix'])[position() <= numberproducts]";
	
	private String BrandFilterValue = "";
	private List<WebElement> productList;
	

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

	@And("^Number of results is printed$")
    public void user_sprint_results() throws Throwable {
		labelControl = new LabelControl(webdriver, XPathRecordsLabel);
		String value = labelControl.getValue();
		System.out.println("Number of records: " + value);
    }
	
	@When("^User orber by \"([^\"]*)\"$")
    public void user_order_by(String OrderTypeSelected) throws Throwable {
		SelectControl selectControl = new SelectControl(webdriver, XPathSort);
		selectControl.selectValueFromBtn(OrderTypeSelected);
		
    }
	
    @When("^User Take the first \"([^\"]*)\" products$")
    public void user_take_the_first_something_products_with_their_prices_and_print_them_in_console(int numberproducts) throws Throwable {
       
    	String ProductListXPath = XPathProductTakenList.replace("numberproducts", Integer.toString(numberproducts));
    	productList = getListOfElements(ProductListXPath);
    	
    }
    
    @Then("^Their prices are printed in console$")
    public void their_prices_are_printed_in_console() throws Throwable {
    	//System.out.println(productList);
    	for (WebElement webElement : productList) {
    		String ProductName = webElement.findElement(By.xpath("//h3[@class='s-item__title']")).getText();
    		String Price = webElement.findElement(By.xpath("//div//span[@class='s-item__price']")).getText();
    		System.out.println("Product Name: " + ProductName + " Price: " + Price);
 		}
    
    }
	
	@When("^Assert the order taking the first \"([^\"]*)\" results$")
    public void user_buy_the_first_something_records(int records) throws Throwable {
    	
    	
    	for(int i=1; i<records; i++) {
    	
    		
    		String ProductXPath = XPathProdBuyItNowItem.replace("INDEXTOREPLACE", Integer.toString(i));
    		buttonControl = new ButtonControl(webdriver, ProductXPath);
    		buttonControl.click();
    		
    		buttonControl = new ButtonControl(webdriver, XPathAddToShoppingCartbtn);
    		buttonControl.click();
    	
    		returnToPreviousPage();
    	
    		returnToPreviousPage();
    	}
    	
    }	
	
}
