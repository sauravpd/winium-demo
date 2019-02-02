package codeSample;

import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class NodepadTest 
{
	public static final String APPLICATION_PATH="C:\\WINDOWS\\system32\\notepad.exe";
	
	@Test
	public void test() 
	{
		try
		{
			System.out.println("test");
			DesktopOptions options= new DesktopOptions();
			options.setApplicationPath(APPLICATION_PATH);
			WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
			driver.findElementByClassName("Edit").sendKeys("This is sample window application test using winium");
			driver.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
