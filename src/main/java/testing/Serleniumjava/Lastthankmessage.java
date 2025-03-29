package testing.Serleniumjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Lastthankmessage extends Abstractwait{

	public Lastthankmessage(WebDriver d2) {
		super(d2);
		this.d2=d2;
		PageFactory.initElements(d2, this);
	}
//	String mess = d2.findElement(By.className("hero-primary")).getText();
//	Assert.assertTrue(mess.equalsIgnoreCase("Thankyou for the order."));
//	d2.close();
	@FindBy(className="hero-primary")
	WebElement mess;
	
	public void message(String thankyoy)
	{
		String messages = mess.getText();
		Assert.assertTrue(messages.equalsIgnoreCase(thankyoy));
	}
}
