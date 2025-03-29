package testing.Serleniumjavanew;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import testing.Serleniumjava.Loginpage;

public class Baseclass 
{
	public WebDriver d2;
	public Loginpage lp;
	public WebDriver intialize() throws IOException
	{
	Properties prof = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\testing\\newglobal\\Global.properties");
	prof.load(fis);
	String browsername = prof.getProperty("browser");
	if(browsername.equalsIgnoreCase("Chrome"))
	{
		 d2 = new ChromeDriver();
		
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		
	}
	d2.manage().window().maximize();
	d2.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	return d2;
	}
	@BeforeMethod
	public Loginpage loging() throws IOException
	{
		d2= intialize();
		lp = new Loginpage(d2);
		lp.navigateToLoginPage();
		return lp;
	}
	
	@AfterMethod
	public void cloingpage()
	{
		d2.close();
	}
	
	public List<HashMap<String, String>> getdatajson(String filepsth) throws IOException
	{
		  String json = FileUtils.readFileToString(new File(filepsth),  StandardCharsets.UTF_8);
		  ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data= mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {});
		  return data;
	}
	public String screenshot(String tc, WebDriver d2) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) d2;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		File screenshotDir = new File(System.getProperty("user.dir") + "//reports//");
		 File file = new File(screenshotDir, tc + ".png");
	     FileUtils.copyFile(source, file);
//		File file = new File(System.getProperty("user.dir") + "//repots"+tc+" .png");
//		FileUtils.copyFile(source, screenshotDir);
		 return file.getAbsolutePath();
	}
}
