package testing.Serleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractwait {
	WebDriver d2; 
	

	public Abstractwait(WebDriver d2) {
		// TODO Auto-generated constructor stub
		this.d2=d2;
		
	}

	public void waiting(By findBy) {
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(8));
		
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
	public void invisblewaiting(By ele) 
	{
		
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	    }
	public void visblewaitingweb(WebElement webele) 
	{
		WebDriverWait wait = new WebDriverWait(d2, Duration.ofSeconds(8));
	wait.until(ExpectedConditions.visibilityOf(webele));
	}
}
