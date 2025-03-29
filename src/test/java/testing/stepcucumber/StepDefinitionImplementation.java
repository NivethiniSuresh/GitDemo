package testing.stepcucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.Serleniumjava.Actionpayments;
import testing.Serleniumjava.Lastthankmessage;
import testing.Serleniumjava.Loginpage;
import testing.Serleniumjava.Productcata;
import testing.Serleniumjavanew.Baseclass;

public class StepDefinitionImplementation extends Baseclass
{
	public Loginpage landing;
	String country = "India";
	String thankyoy = "Thankyou for the order.";
	@Given("I landed the E commerance page")
	public void I_landed_the_Ecommerance_page() throws IOException
	{
		landing = loging();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_uaername_pass(String user, String password)
	{
		lp.actionlogin(user, password);
	}
	@When("^I add the product(.+)$")
	public void Logged_in_uaername_pass(String productname) throws InterruptedException
	{
		Productcata produ = new Productcata(d2);
		List<WebElement> pro  = produ.getprodlist();
		produ.getprodfilter(productname);
		produ.cartclick(productname);
		produ.cartclicking(productname);
		
	}
	
	@When("^checkout the (.+) and submit the order $")
	public void checkout_submit_orders(String productname) throws InterruptedException
	{
		
		Actionpayments pay = new Actionpayments(d2);
		pay.cartclicking(country);
	}
	@Then("{string} message is displayed")
	public void message_displayed(String string)
	{
		
		Lastthankmessage last = new Lastthankmessage(d2);
		last.message(string);
	}
}
