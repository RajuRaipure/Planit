package ObjectIDs;
import org.openqa.selenium.By;

public interface testElementIDs 
{
	By USER_ID = By.id("username");
	   By CONTACT = By.linkText("Contact");
	   By SUBMIT_BTN=By.xpath("//a[contains(text(),'Submit')]");
	   By ERROR_MSG_1=By.xpath("/html/body/div[2]/div/div/div");
	   By ERROR_MSG_2=By.id("forename-err");
	   By ERROR_MSG_3=By.id("email-err");
	   By ERROR_MSG_4=By.id("message-err");
	   By FORENAME=By.id("forename");
	   By EMAIL=By.id("email");
	   By SURNAME=By.id("surname");
	   By MESSAGE=By.id("message");
	   By SHOP=By.linkText("Shop");
	   By SUCCESS_MSG=By.xpath("/html/body/div[2]/div/div");
	   By STUFF_FROG_BUY=By.xpath("//h4[contains(text(),'Stuffed Frog')]/parent::div/p/a");
	   By FLUFFY_BUNNY_BUY=By.xpath("//h4[contains(text(),'Fluffy Bunny')]/parent::div/p/a");
	   By VALENTINE_BEAR_BUY=By.xpath("//h4[contains(text(),'Valentine Bear')]/parent::div/p/a");
	   By CART=By.partialLinkText("Cart");
	   By STUFF_FROG_QTY=By.xpath("//td[contains(text(),'Stuffed Frog')]/parent::tr/td[3]/input");
	   By FLUFFY_BUNNY_QTY=By.xpath("//td[contains(text(),'Fluffy Bunny')]/parent::tr/td[3]/input");
	   By VALENTINE_BEAR_QTY=By.xpath("//td[contains(text(),'Valentine Bear')]/parent::tr/td[3]/input");
	   By STUFF_FROG_SUBTOTAL=By.xpath("//td[contains(text(),'Stuffed Frog')]/parent::tr/td[4]");
	   By FLUFFY_BUNNY_SUBTOTAL=By.xpath("//td[contains(text(),'Fluffy Bunny')]/parent::tr/td[4]");
	   By VALENTINE_BEAR_SUBTOTAL=By.xpath("//td[contains(text(),'Valentine Bear')]/parent::tr/td[4]");

	   By VALENTINE_BEAR_PRICE=By.xpath("//td[contains(text(),'Valentine Bear')]/parent::tr/td[2]");
	   By STUFF_FROG_PRICE=By.xpath("//td[contains(text(),'Stuffed Frog')]/parent::tr/td[2]");
	   By FLUFFY_BUNNY_PRICE=By.xpath("//td[contains(text(),'Fluffy Bunny')]/parent::tr/td[2]");
	   By TOTAL=By.xpath("//strong[contains(text(),'Total')]");

}
