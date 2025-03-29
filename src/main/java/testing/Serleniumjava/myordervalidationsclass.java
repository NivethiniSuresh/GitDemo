package testing.Serleniumjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myordervalidationsclass extends Abstractwait{


	public myordervalidationsclass(WebDriver d2) {
		super(d2);
		this.d2=d2;
		PageFactory.initElements(d2, this);
	}

	
	@FindBy(css="table tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	WebElement myorders = d2.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']"));
	
	
	public Boolean listofproducts(String productname) 
	{
		Boolean ordermatch =orderlist.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productname));
		return ordermatch;
	}
}
