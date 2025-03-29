package testing.Serleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Abstractwait{
	WebDriver d2; 

	public Loginpage(WebDriver d2) {
		super(d2);
		this.d2=d2;
		PageFactory.initElements(d2, this);
	}
//	WebElement user = d2.findElement(By.id("userEmail"));
//	d2.findElement(By.id("userPassword")).sendKeys("Nivethini1999@");
//	d2.findElement(By.id("login")).click();
	
	@FindBy(id="userEmail")
	WebElement user;
	@FindBy(id="userPassword")
	WebElement pass;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css=".toast-message.ng-star-inserted")
	WebElement incorrectuser;
	public void actionlogin(String email, String password)
	{
		user.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
	}
	public String validationerror()
	{
		visblewaitingweb(incorrectuser);
		return incorrectuser.getText();
	}
	
	public void navigateToLoginPage() {
        d2.get("https://rahulshettyacademy.com/client/");
    }
}
