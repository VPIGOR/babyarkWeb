package babyarkWeb.PageUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
				
		String path = "/Users/igorvainman/eclipse-workspace/babyarkWeb/reports/index.html";
		// Class for report configuration
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Igor's Web Automation Test");
		reporter.config().setDocumentTitle("Igor's Test Result");
		// class for report execution
		extent = new ExtentReports();
		// set settings info to executor
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Igor");
		return extent;
	}
}
