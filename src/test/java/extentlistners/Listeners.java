package extentlistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testscript.BaseClass;
import utility.ScreenshotCapture;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {
	 
    private static ExtentTest test;
    private ExtentReports extent = ExtentReportGen.extentReportGenerator();


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started" + result.getName());

		test = extent.createTest(result.getName()); // in report
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is pass" + result.getName());

		test.log(Status.PASS, "Test case is passed");
		
		try {
		
          test.addScreenCaptureFromPath(ScreenshotCapture.captureScreenShotWithPath(driver, result.getName())); 
		} catch (IOException e) {

			System.out.println("Exception arrived while taking screen shot");
		}


	}
		
    @Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed" + result.getName());

		test.fail(result.getThrowable()); 
		// exception show in report also take screenshot
		try {
			// screenShot take
			ScreenshotCapture.captureScreenshot(driver, result.getName());

			// screenshot with path (screenshot save+attach)
          test.addScreenCaptureFromPath(ScreenshotCapture.captureScreenShotWithPath(driver, result.getName())); 
		} catch (IOException e) {

			System.out.println("Exception arrived while taking screen shot");
		}


	}

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case skipped: " + result.getName());
        test.log(Status.SKIP, "Test case skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result); 
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
        if (extent != null) {
            extent.flush(); // Write the report to the file
        }
    }
}
