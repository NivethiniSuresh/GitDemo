package testing.Serleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standaloneref {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver d2 = new ChromeDriver();
		d2.manage().window().maximize();
		Loginpage lp = new Loginpage(d2);
		d2.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		d2.get("https://rahulshettyacademy.com/client/");
		d2.findElement(By.id("userEmail")).sendKeys("nivethinibabu@gmail.com");
		d2.findElement(By.id("userPassword")).sendKeys("Nivethini1999@");
		d2.findElement(By.id("login")).click();
		List<WebElement> pro = d2.findElements(By.cssSelector(".mb-3"));
		System.out.println(pro.get(1));
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(8));
		WebElement prod = pro.stream().filter(s-> s.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		prod.findElement(By.cssSelector("div button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOf(d2.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//		WebElement prod2 = pro.stream().filter(s-> s.findElement(By.tagName("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
//		prod2.findElement(By.cssSelector("div button:last-of-type")).click();
//		wait.until(ExpectedConditions.visibilityOf(d2.findElement(By.cssSelector("#toast-container"))));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.visibilityOf(d2.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"))));
		d2.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
//		wait.until(ExpectedConditions.visibilityOf(d2.findElement(By.cssSelector(".cartSection h3"))));
//		List<WebElement> cart= d2.findElements(By.xpath(".cartSection h3"));
//		Boolean ag = cart.stream().anyMatch(s->s.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
//		Assert.assertTrue(ag);
		d2.findElement(By.xpath("//button[text()='Checkout']")).click();
		Actions act1 = new Actions(d2);
		act1.sendKeys(d2.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		d2.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		d2.findElement(By.cssSelector(".action__submit")).click();
		String mess = d2.findElement(By.className("hero-primary")).getText();
		Assert.assertTrue(mess.equalsIgnoreCase("Thankyou for the order."));
		d2.close();
	}

}
