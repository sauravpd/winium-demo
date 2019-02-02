package codeSample;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

/**
 * Calculator Test using winium
 * @author saurav
 *
 */
public class CalculatorTest 
{

	/**
	 * application path
	 */
	public static final String APPLICATION_PATH="C:\\windows\\system32\\calc.exe";
	
	/**
	 * Sample window application test using winium
	 */
	@Test
	public void calcTest() 
	{
		System.out.println("Calculator Test");
		try
		{
			WiniumDriver driver = null;
			DesktopOptions option = new DesktopOptions();
			option.setApplicationPath(APPLICATION_PATH);
			option.setDebugConnectToRunningApp(false);
			option.setLaunchDelay(2);
			driver = new WiniumDriver(new URL("http://localhost:9999"),option);
			Thread.sleep(1000);
			WebElement window =  driver.findElementByClassName("CalcFrame");
			WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
			menuItem.click();
			driver.findElementByName("Scientific").click();

			window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
			driver.findElementByName("History").click();

			window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
			driver.findElementByName("History").click();

			window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
			driver.findElementByName("Standard").click();

			driver.findElementByName("5").click();
			driver.findElementByName("+").click();
			driver.findElementByName("5").click();
			driver.findElementByName("=").click();
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
