package page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	// static attributes
	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	private static final String USERNAMEXPath = "//input[@placeholder='username']";
	private static final String PASSWORDXPath = "//input[@placeholder='password']";
	private static final String LogInBUTTONXPath = "//input[@name='login']";

	// Username
	/**
	 * @param driver
	 * @return
	 */
	public WebElement getUserName(WebDriver driver) {
		WebElement userName = driver.findElement(By.xpath(USERNAMEXPath));
		return userName;
	}

	/**
	 * @param driver
	 */
	public void clickUserName(WebDriver driver) {
		getUserName(driver).click();
	}

	/**
	 * @param driver
	 * @param str
	 */
	public void sendKeysUserName(WebDriver driver, String str) {
		getUserName(driver).sendKeys(str);
	}

	/**
	 * Returns password input
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath(PASSWORDXPath));
		return password;
	}

	/**
	 * Click on password input
	 * 
	 * @param driver
	 */
	public void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	/**
	 * Method for filling password textbox
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysPassword(WebDriver driver, String str) {
		getPassword(driver).sendKeys(str);
	}

	/**
	 * Get login button by xpath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getLogIn(WebDriver driver) {
		WebElement login = driver.findElement(By.xpath(LogInBUTTONXPath));
		return login;
	}

	/**
	 * Click on login button
	 * 
	 * @param driver
	 */
	public void clickLogIn(WebDriver driver) {
		getLogIn(driver).click();
	}

	/**
	 * Navigate to url
	 * 
	 * @param driver
	 */
	public void navigateTo(WebDriver driver) {
		driver.navigate().to(PAGE_URL);
	}
}
