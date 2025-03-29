package testing.newglobal;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport 
{
	public static ExtentReports extendsreport()
	{
		String file  = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(file);
		esr.config().setReportName("Set Test ReportName");
		esr.config().setDocumentTitle("Test Document Title");
		ExtentReports er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Tesster", "Nive");
		return er;
	}
}
