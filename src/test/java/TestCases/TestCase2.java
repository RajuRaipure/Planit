package TestCases;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import helpers.EnvironmentProperties;
import helpers.GenericFunctions;
import helpers.Page;
import reusableFunctions.reusableFunctions;

import java.lang.annotation.Repeatable;
import java.util.Map;

public class TestCase2 extends Page
{
	public static Map<Object,Object> xmlMap;
	public static String path = System.getProperty("user.dir");
	public static reusableFunctions reuse=new reusableFunctions();
	public static GenericFunctions gf=new GenericFunctions();
	public static WebDriver driver;
	private final String propertyFilePath= path+"//resources//configuration//environment.properties";
	public static EnvironmentProperties environmentProperties = new EnvironmentProperties();
	public TestCase2() {
		// TODO Auto-generated constructor stub
	}
	@Before
	public void setup()
	{
		String dataFile=environmentProperties.ConfigFileReader(propertyFilePath,path);
		xmlMap=reusableFunctions.init(dataFile);
		driver=browserInfo(reuse.getData(xmlMap, "BrowserInfo", "BrowserDriver"));
	}
	@Test

	public  void test2() throws InterruptedException
	{
		driver=reusableFunctions.launchApp(xmlMap,driver);
		driver=reusableFunctions.clickOnContact(driver);
		driver=reusableFunctions.enterContactDetails(xmlMap,driver);
		driver=reusableFunctions.clickSubmitButton(driver);
		driver=reusableFunctions.verifySuccessMessage(driver);
	}
	@After
	public void teardown()
	{
		driver.quit();
	}

}
