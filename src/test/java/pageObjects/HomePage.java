package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	@FindBy(css = ".header__user  span:nth-child(1)")
	private WebElement helloPhrase;
	@FindBy(css = ".header__user  span:nth-child(2)")
	private WebElement namePhrase;	
	@FindBy(css = ".header__user-menu .header__user-menu-link")
	private List<WebElement> listOfOptions;
 
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public String checkLoginGreeting() {
		String hello = getText(helloPhrase);
		String name = getText(namePhrase);
		return (name);
		
	}
	public void logOut() {
		sleep(2000);
		click(helloPhrase);
		for (WebElement el : listOfOptions) {
			if (getText(el).equalsIgnoreCase("התנתקות")) {
				sleep(1000);
				click(el);
				
			}
			
		}
	}
 
}
