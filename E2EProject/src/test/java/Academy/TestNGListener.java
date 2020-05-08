package Academy;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import resources.base;

public class TestNGListener implements ITestListener{
	
	ExtentTest test;
	base b = new base();
	//ExtentReports extent = ExtentReporterNG.getResprtObject();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.fail(result.getThrowable());
		
		try {
			b.getScreenShots(result.getName());
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		
		//extent.flush();
		
	}

		
}
	


