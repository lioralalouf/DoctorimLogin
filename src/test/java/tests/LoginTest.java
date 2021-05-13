package tests;

import static org.junit.Assert.assertArrayEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void tc01_loginFailed(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.Login(email, password);
		String expected = "כתובת הדואר האלקטרוני, התעודת זהות או הסיסמה שגויים. אם זו הפעם הראשונה שאתה נכנס עם סיסמה זו, אנא וודא כי אישרת את הדואר האלקטרוני שנשלח לחשבונך לאחר הרישום";
		Assert.assertEquals(lp.getErrorMsg(), expected);
		System.out.println(lp.getErrorMsg());
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "liora@odoro.co.ill", "12345678" }, { "liora@odoro.co.ill", "12345678" }, { "liora@odoro.co.ill", "12345678" }, { "liora@odoro.co.ill", "12345678" }, };
		return myData;
	}

	@Test
	public void tc02_loginSuccess() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("liora@odoro.co.il", "Sean151113");
		HomePage hp = new HomePage(driver);
		String expected = "ליאור אללוף";
		Assert.assertEquals(hp.checkLoginGreeting(), expected);
		System.out.println(hp.checkLoginGreeting());
		System.out.println(expected);
	}
	@Test
	public void tc03_logout() {
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}

}
