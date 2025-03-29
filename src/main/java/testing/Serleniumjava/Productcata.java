package testing.Serleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Productcata extends Abstractwait{


	public Productcata(WebDriver d2) {
		super(d2);
		this.d2=d2;
		PageFactory.initElements(d2, this);
	}
//	List<WebElement> pro = d2.findElements(By.cssSelector(".mb-3"));
//	d2.findElement(By.xpath("//button[text()='Checkout']")).click();
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement carting;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	@FindBy(css="table tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	By proby = By.cssSelector(".mb-3");
	By toast =By.cssSelector("#toast-container");
	By invis = By.cssSelector(".ng-animating");
	By cart = By.cssSelector("div button:last-of-type");
	WebElement webelementi = d2.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"));
	WebElement myorders = d2.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']"));
	
	public List<WebElement> getprodlist()
	{
		waiting(proby);
		return products;
	}
	public WebElement getprodfilter(String productname)
	{
		WebElement prod = getprodlist().stream().filter(s-> s.findElement(By.tagName("b")).getText().equals(productname)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector("div button:last-of-type")).click();
		return prod;
	}
	public void cartclick(String productname)
	{
		WebElement prod = getprodfilter(productname);
		prod.findElement(cart).click();
		waiting(toast);
		invisblewaiting(invis);
//		invisblewaitingweb(webelementi);
	}
	
	public void cartclicking(String productname) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(10));
		WebElement myorders = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink='/dashboard/cart']")));
//		Thread.sleep(5000);
//		invisblewaitingweb(webelementi);
		carting.click();
		checkout.click();
	}
	
	public myordervalidationsclass ordersclicking()
	{
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(10));
		WebElement myorders = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/myorders']")));
		myorders.click();
		myordervalidationsclass myorder = new myordervalidationsclass(d2);
		return myorder;
	}
	public Boolean listofproducts(String productname) 
	{
		Boolean ordermatch =orderlist.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productname));
		return ordermatch;
	}
}
