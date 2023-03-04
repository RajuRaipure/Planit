package helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Page 
{
	public static GenericFunctions gf=new GenericFunctions();
	public static WebDriver driver;
	public static String browserName;

	public static WebDriver browserInfo(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			  System.setProperty("webdriver.chrome.driver",
			  System.getProperty("user.dir")+"//driver//chromedriver//chromedriver");
			  driver=new ChromeDriver(); 
		}
		return driver;
	}

}
