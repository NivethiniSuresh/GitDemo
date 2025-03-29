package testing.Serleniumjava;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing.Serleniumjavanew.Baseclass;
@Test(dataProvider = "inputdata")
public class Standalone extends Baseclass {
	
	public void mainclass(HashMap<String,String> inputdata ) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		String productname = "ADIDAS ORIGINAL";
		String country = "India";
		String thankyoy = "Thankyou for the order.";
		lp.actionlogin(inputdata.get("email"), inputdata.get("pass"));
		Productcata produ = new Productcata(d2);
		List<WebElement> pro  = produ.getprodlist();
		produ.getprodfilter(inputdata.get("productname"));
		produ.cartclick(inputdata.get("productname"));
		produ.cartclicking(inputdata.get("productname"));
		Actionpayments pay = new Actionpayments(d2);
		pay.cartclicking(country);
		Lastthankmessage last = new Lastthankmessage(d2);
		last.message(thankyoy);
		System.out.println("Sample code");
	}
	@Test(dependsOnMethods = {"mainclass"})
	public void orderpage(HashMap<String,String> inputdata)
	{
		lp.actionlogin(inputdata.get("email"), inputdata.get("pass"));
		Productcata produ = new Productcata(d2);
		myordervalidationsclass order = produ.ordersclicking();
		Assert.assertTrue(order.listofproducts(inputdata.get("productname")));
		
	}
	
//	@DataProvider
//	public Object[][] inputdata() throws IOException
//	{
//		List<HashMap<String, String>> data = getdatajson(System.getProperty("user.dir") + "\\src\\test\\java\\testing\\Serleniumjavadata.json");
//		Object [][] datas = {{data.get(0)},{data.get(1)}};
//		return datas;
//	}
	
	@DataProvider
	public Object[][] inputdata() throws IOException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "nivethinibabu@gmail.com");
		map.put("productname", "ADIDAS ORIGINAL");
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "shetty@gmail.com");
		map1.put("pass", "Iamking@000");
		map1.put("productname", "IPHONE 13 PRO");
		Object [][] datas = {{map},{map1}};
//		Object[][] datas = { {"nivethinibabu@gmail.com", "Nivethini1999@", "ADIDAS ORIGINAL"}, {"nivethinibau@gmail.com", "Nivethini999@", "IPHONE 13 PRO"} };
		return datas;
	}
}
