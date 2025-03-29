package testing.Serleniumjava;

import java.io.IOException;
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
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import testing.Serleniumjavanew.Baseclass;

public class Errorvalidation extends Baseclass {
	@Test
	public void mainclass() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productname = "ADIDAS ORIGINAL";
		String country = "India";
		String thankyoy = "Thankyou for the order.";
		lp.actionlogin("nivethiniba@gmail.com", "Nivethini1999@");
//		 Incorrect email or password. 
		Assert.assertEquals("Iorrect email or password.", lp.validationerror());
	}
}
