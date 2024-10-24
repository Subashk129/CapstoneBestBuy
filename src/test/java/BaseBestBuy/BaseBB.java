package BaseBestBuy;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilsBestBuy.UtilityBB;

;

public class BaseBB extends UtilityBB {	

	@BeforeSuite
	public void startReport() {
		ExtentSparkReporter reporter =new ExtentSparkReporter("./Reports/result.html");
		reporter.config().setReportName("Spicejet Reporter");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("browser"));
		getApplication(readProperty("url"));
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getFromExcel() throws Exception{
		Object[][] data = dataReader(sheetName);
		return data;
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
	
	

