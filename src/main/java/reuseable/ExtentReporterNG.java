package reuseable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNG {
    public ExtentReports getReporterObject(){
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
        reporter.config().setReportName("reporterName");
        reporter.config().setDocumentTitle("documentTitle");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("tester" , "Ibrahim");
        return extentReports ;
    }
}
