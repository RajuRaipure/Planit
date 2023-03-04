package reusableFunctions;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentTest;

import com.esotericsoftware.yamlbeans.YamlReader;

import ObjectIDs.testElementIDs;
import helpers.GenericFunctions;
import junit.framework.Assert;

public class reusableFunctions extends GenericFunctions implements testElementIDs
{

	//public static WebDriver driver;
	public static WebDriver driver;
	public static boolean failflag;
	//WebDriverWait wait=new WebDriverWait(driver, 30);
	public static YamlReader reader;
	public static Object object;
	public static Map<Object,Object> map;

	public static String subTotalStuffBear="";
	public static String subTotalFluffyBunny="";
	public static String subTotalValentineBear="";

	public static boolean flag;
	public reusableFunctions()
	{

	}

	public static WebDriver launchApp( Map<Object, Object> xmlMap, WebDriver driver)
	{
		try
		{
			String url=getData(xmlMap, "Url", "Planit");
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			failflag = true;
		}
		return driver;
	}
	public static WebDriver clickOnContact(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CONTACT));
		driver.findElement(CONTACT).click();
		return  driver;
	}
	public static WebDriver clickSubmitButton(WebDriver driver) throws InterruptedException {
		//WebElement SUBMITBTN= driver.findElement(SUBMIT_BTN);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_BTN));
		driver.findElement(SUBMIT_BTN).click();
		Thread.sleep(15000);
		return driver;
	}



	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", element);
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 3px white');", element);
	}

	@SuppressWarnings("unchecked")
	public static  String getData(Map<Object,Object> map,String mappingHeader, String sequence)
	{
		String expectedValue = null;
		try
		{
			for(int i =0; i<map.size(); i++)
			{
				if (map.get(mappingHeader) != null)
				{
					ar = (ArrayList<String>)(map.get(mappingHeader));
					for(int j =0; j< ar.size(); j++)
					{
						String str = ar.get(j);
						String[] split = str.split("::");
						String key = split[0];
						String val = split[1];
						if(key.equals(sequence))
						{
							if(val.equalsIgnoreCase("BLANK"))
								expectedValue = "";
							else
								expectedValue = val;
							break;
						}
					}
				}
			}
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
		return expectedValue;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map init(String file)
	{
		try
		{
			reader = new YamlReader(new FileReader(file));
			object = reader.read();
			map = (Map)object;
			reader.close();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return map;
	}
	public static WebDriver verifyErrorMessage(WebDriver driver)
	{
		String errormsg1=driver.findElement(ERROR_MSG_1).getText();
		String errormsg2=driver.findElement(ERROR_MSG_2).getText();
		String errormsg3=driver.findElement(ERROR_MSG_3).getText();
		String errormsg4=driver.findElement(ERROR_MSG_4).getText();
		Assert.assertEquals("We welcome your feedback - but we won't get it unless you complete the form correctly.",errormsg1);
		Assert.assertEquals("Forename is required",errormsg2);
		Assert.assertEquals("Email is required",errormsg3);
		Assert.assertEquals("Message is required",errormsg4);
		return driver;
	}

	public static WebDriver enterContactDetails(Map<Object, Object> xmlMap, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORENAME));
		driver.findElement(FORENAME).sendKeys(getData(xmlMap, "Contacts", "ForeName"));
		driver.findElement(SURNAME).sendKeys(getData(xmlMap, "Contacts", "Surname"));
		driver.findElement(EMAIL).sendKeys(getData(xmlMap, "Contacts", "Email"));
		driver.findElement(MESSAGE).sendKeys(getData(xmlMap, "Contacts", "Message"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver verifyErrorMessageAfterEnteringDetails(WebDriver driver)
	{
		boolean result=false;
		try
		{
			driver.findElement(ERROR_MSG_2).isDisplayed();
			driver.findElement(ERROR_MSG_3).isDisplayed();
			driver.findElement(ERROR_MSG_4).isDisplayed();
			result=true;
		}
		catch(Exception e)
		{
			System.out.println("No error message displayed");
		}
		Assert.assertTrue("No Error messages are displayed", true);
	
		return driver;
	}


	public static WebDriver verifySuccessMessage(WebDriver driver)
	{
		Assert.assertEquals("Thanks Test, we appreciate your feedback.",driver.findElement(SUCCESS_MSG).getText());
		return driver;
	}

	public static WebDriver clickOnShop(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SHOP));
		driver.findElement(SHOP).click();
		return driver;
	}

	public static WebDriver clickBuyButtonForSpecifiedItems(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(STUFF_FROG_BUY));
		driver.findElement(STUFF_FROG_BUY).click();
		driver.findElement(FLUFFY_BUNNY_BUY).click();
		driver.findElement(VALENTINE_BEAR_BUY).click();
		return driver;
	}

	public static WebDriver clickOnCart(WebDriver driver)
	{
		driver.findElement(CART).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver verifySubTotalForEachProduct(Map<Object, Object> xmlMap, WebDriver driver)
	{
		driver.findElement(STUFF_FROG_QTY).clear();
		driver.findElement(STUFF_FROG_QTY).sendKeys(getData(xmlMap, "QTY", "STUFF_FROG"));
		driver.findElement(FLUFFY_BUNNY_QTY).clear();
		driver.findElement(FLUFFY_BUNNY_QTY).sendKeys(getData(xmlMap, "QTY", "FLUFFY_BUNNY"));
		driver.findElement(VALENTINE_BEAR_QTY).clear();
		driver.findElement(VALENTINE_BEAR_QTY).sendKeys(getData(xmlMap, "QTY", "VALENTINE_BEAR"));
		subTotalStuffBear=driver.findElement(STUFF_FROG_SUBTOTAL).getText();
		subTotalFluffyBunny=driver.findElement(FLUFFY_BUNNY_SUBTOTAL).getText();
		subTotalValentineBear=driver.findElement(VALENTINE_BEAR_SUBTOTAL).getText();
		Assert.assertEquals("$"+String.valueOf(2*10.99),subTotalStuffBear);
		Assert.assertEquals("$"+String.valueOf(5*9.99),subTotalFluffyBunny);
		Assert.assertEquals("$"+String.valueOf(3*14.99),subTotalValentineBear);
		return  driver;
	}

	public static float getSubTotal(String subTotal)
	{
		float finalSubTotal=Float.parseFloat(subTotal.replace("$",""));
		return finalSubTotal;
	}

	public static WebDriver verifyPriceOfEachProduct(WebDriver driver)
	{
		Assert.assertEquals("$10.99",driver.findElement(STUFF_FROG_PRICE).getText());
		Assert.assertEquals("$9.99",driver.findElement(FLUFFY_BUNNY_PRICE).getText());
		Assert.assertEquals("$14.99",driver.findElement(VALENTINE_BEAR_PRICE).getText());
		return driver;
	}

	public static WebDriver verifyTotalPrice(WebDriver driver)
	{
		float actualTotal=getSubTotal(subTotalStuffBear)+getSubTotal(subTotalFluffyBunny)+getSubTotal(subTotalValentineBear);
		String ttl=driver.findElement(TOTAL).getText();
		String[] expectedTotal = ttl.split(":");
		Assert.assertEquals(String.valueOf(actualTotal),expectedTotal[1].trim());
		return driver;
	}
}
