package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helpers {
	
	//Method to take screenshot when the test case fail	
	public static void captureScreenshot(WebDriver driver, String screenshotname)
	{
		Path destination= Paths.get("./Screenshots",screenshotname+".png");
		try {
			//to get the directory
			java.nio.file.Files.createDirectories(destination.getParent());
			//make streaming from destination to save the image in Out variable
			FileOutputStream Out= new FileOutputStream(destination.toString());
			//make driver take the screenshot then get it as bytes
			Out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			Out.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}
	}

}
