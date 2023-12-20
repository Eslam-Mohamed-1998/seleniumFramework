package UtilitiesORHelpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShotSharedMethod {
	public static void takeScreenShotsAtFailure(WebDriver driver , String screenshotName) throws IOException 
	{
		
		  Path dest = Paths.get("./screenShots",screenshotName+".png");
		  Files.createDirectories(dest.getParent()); 
		  FileOutputStream out = new FileOutputStream(dest.toString());
		  out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES) );
		  out.close();
		 
		
		// Below Is Another Capture ScreenShot Solution ...
		
		//TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		//File source = tkScreen.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
