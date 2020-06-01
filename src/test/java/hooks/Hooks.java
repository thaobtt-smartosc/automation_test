package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import utility.InitDriver;

public class Hooks {
	
	@Before
 public void openBrowser()
 {
	 InitDriver.setDriver();
 }
	@After
	public void tearDown(Scenario scenario)
	{
		if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) InitDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); 
    }
		InitDriver.getDriver().quit();
	}
}
