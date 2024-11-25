package extentlistners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentReportGen {

    private static ExtentReports extent;

    public static ExtentReports extentReportGenerator() {
        if (extent == null) {
            try {
                // Ensure directory exists before creating the reporter
                String path = System.getProperty("user.dir") + File.separator + "extentreports" + File.separator + "pageextentreportfile.html";
                File reportDir = new File(System.getProperty("user.dir") + File.separator + "extentreports");
                if (!reportDir.exists()) {
                    if (reportDir.mkdirs()) {
                        System.out.println("Report directory created successfully.");
                    } else {
                        System.err.println("Failed to create report directory.");
                    }
                }

                // Initialize the reporter
              
                ExtentSparkReporter reporter = new ExtentSparkReporter(path);
                reporter.config().setTheme(Theme.DARK);
                reporter.config().setReportName("Automation Test Report");
                reporter.config().setDocumentTitle("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(reporter);
                extent.setSystemInfo("Project", "Amazon Application");
                extent.setSystemInfo("Environment", "SIT");
                extent.setSystemInfo("Executed by", "Somnath Ugale");

            } catch (Exception e) {
                System.err.println("Failed to initialize ExtentReports: " + e.getMessage());
                e.printStackTrace(); // Print the full stack trace for further debugging
            }
        }
        return extent;
    }
}