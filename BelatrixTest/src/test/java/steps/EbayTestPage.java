package steps;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/*import cucumber.api.PendingException;*/
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class EbayTestPage extends Page
{
	private String EbayUrlPath = "https://www.ebay.com";
	

	public EbayTestPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^User is on Ebay Page$")
    public void user_is_on_ebay_page() throws Throwable {
        //throw new PendingException();
    	webdriver.navigate().to(EbayUrlPath);
    }

    @When("^User select shoes Category$")
    public void user_select_shoes_category() throws Throwable {
        //throw new PendingException();
    	System.out.println("Test 2");
    }

    @Then("^Ebay Page displays shoes category$")
    public void ebay_page_displays_shoes_category() throws Throwable {
        //throw new PendingException();
        System.out.println("Test 3");
    }

}
