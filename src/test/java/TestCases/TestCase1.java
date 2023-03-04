package TestCases;


import reusableFunctions.reusableFunctions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import helpers.EnvironmentProperties;
import helpers.GenericFunctions;
import helpers.Page;

import java.util.Map;

public class TestCase1 extends Page
{


	public static Map<Object,Object> xmlMap;
	public static String path = System.getProperty("user.dir");
	public static reusableFunctions reuse=new reusableFunctions();
	public static GenericFunctions gf=new GenericFunctions();
	public static WebDriver driver;
	public final String propertyFilePath= path+"//resources//configuration//environment.properties";
	public static EnvironmentProperties environmentProperties = new EnvironmentProperties();
	public TestCase1() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Before
	public void setup()
	{
		String dataFile=environmentProperties.ConfigFileReader(propertyFilePath,path);
		System.out.println(dataFile);
		xmlMap=reuse.init(dataFile);
		driver=browserInfo(reuse.getData(xmlMap, "BrowserInfo", "BrowserDriver"));
	}
	@Test
	public  void test1() throws InterruptedException
	{
		driver=reusableFunctions.launchApp(xmlMap,driver);
		driver=reusableFunctions.clickOnContact(driver);
		driver=reusableFunctions.clickSubmitButton(driver);
		driver=reusableFunctions.verifyErrorMessage(driver);
		driver=reusableFunctions.enterContactDetails(xmlMap,driver);
		driver=reusableFunctions.verifyErrorMessageAfterEnteringDetails(driver);
	}
	@After
	public  void teardown()
	{
		driver.quit();
		
	}

}


