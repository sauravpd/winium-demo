package codeSample;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class CalculatorTest 
{

	@Test
	public void calcTest() 
	{
		try
		{
			WiniumDriver driver = null;
			String appPath = "C:/windows/system32/calc.exe";
			DesktopOptions option = new DesktopOptions();
			option.setApplicationPath(appPath);
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
