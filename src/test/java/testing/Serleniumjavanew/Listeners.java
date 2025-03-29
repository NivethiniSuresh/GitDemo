package testing.Serleniumjavanew;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testing.newglobal.Extentreport;

public class Listeners extends Baseclass implements ITestListener
{
	ExtentTest test;
	ExtentReports erb = Extentreport.extendsreport();
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: success" + result.getName());
        test = erb.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "details");
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	 test.fail(result.getThrowable());
        System.out.println("Test Failed: " + result.getName());
        String screenshotPath = null ;
        try {
			d2 = (WebDriver) result.getTestClass().getRealClass().getField("d2").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
        try {
			 screenshotPath = screenshot(result.getMethod().getMethodName(),d2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        test.addScreenCaptureFromBase64String(screenshotPath, result.getMethod().getMethodName());    
        }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finished: " + context.getName());
        erb.flush();
    }
}
