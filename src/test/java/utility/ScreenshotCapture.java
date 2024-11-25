package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {

	public static WebDriver driver;

	public static void captureScreenshot(WebDriver driver, String name) throws IOException {
		String path = System.getProperty("user.dir") + "\\TestProofScreenshots" + name + ".png";
		TakesScreenshot scr = (TakesScreenshot) driver; // type casting
		File source = scr.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(source, destination);

	}

	public static String captureScreenShotWithPath(WebDriver driver, String name) throws IOException {
		String path = System.getProperty("user.dir") + "\\TestProofScreenshots" + name + ".png";
		TakesScreenshot scr = (TakesScreenshot) driver;
		File source = scr.getScreenshotAs(OutputType.FILE);

		File destination = new File(path);
		FileHandler.copy(source, destination);

		return path;
	}

}
