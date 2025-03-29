package testing.Serleniumjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Actionpayments extends Abstractwait{

	public Actionpayments(WebDriver d2) {
		super(d2);
		this.d2=d2;
		PageFactory.initElements(d2, this);
	}
//	d2.findElement(By.xpath("(//button[@type='button'])[1]")).click();
//	d2.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectcountry;
	@FindBy(xpath="//div[@class='payment__shipping']//button[1]")
	WebElement india;
	@FindBy(css=".action__submit")
	WebElement submit;
	By dropdown = By.cssSelector(".ta-results");
	Actions act1 = new Actions(d2);
	public void cartclicking(String country) throws InterruptedException
	{
		act1.sendKeys(selectcountry,country).build().perform();
		waiting(dropdown);
		Thread.sleep(5000);
		india.click();
		submit.click();
	}
}
