package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

	@FindBy(css = "[name='email2']")
	private WebElement userEmail;
	@FindBy(css = "[name='pw3']")
	private WebElement userPassword;
	@FindBy(css = "#sign-in-form .site__customButton")
	private WebElement loginBtn;
	@FindBy(css = "#email2-error")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void Login(String email, String password) {
		fillText(userEmail, email);
		fillText(userPassword, password);
		click(loginBtn);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "user1", "123" }, { "gal", "123" }, { "yonit", "1#444" }, { "gal", "123456878" }, };
		return myData;
	}
	public String getErrorMsg() {
		sleep(3000);
		return getText(errorMsg);
		
	}

}
