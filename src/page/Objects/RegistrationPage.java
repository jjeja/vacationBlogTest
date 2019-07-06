package page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	// static attributes
	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	private static final String FIRSTNAMEXPath = "//input[@name='firstname']";
	private static final String LASTNAMEXPath = "//input[@name='lastname']";
	private static final String USERNAMEXPath = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAILXPath = "//input[@name='email']";
	private static final String PASSWORDXPath = "//div[@class='register_form']//input[@name='password']";
	private static final String REGISTERBUTTONXPath = "//input[@id='blue_btn']";

	
	/**
	 * Get first name input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getFirstName(WebDriver driver) {
		WebElement firstName = driver.findElement(By.xpath(FIRSTNAMEXPath));
		return firstName;
	}

	/**
	 * Click first name input
	 * 
	 * @param driver
	 */
	public void clickFirstName(WebDriver driver) {
		getFirstName(driver).click();
	}

	/**
	 * Fill first name input
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysFirstName(WebDriver driver, String str) {
		getFirstName(driver).sendKeys(str);
	}

	
	/**
	 * Get last name input by XPath
	 * 
	 * @param driver
	 * @return WebELement
	 */
	public WebElement getLastName(WebDriver driver) {
		WebElement lastName = driver.findElement(By.xpath(LASTNAMEXPath));
		return lastName;
	}

	/**
	 * Click last name input
	 * 
	 * @param driver
	 */
	public void clickLastName(WebDriver driver) {
		getLastName(driver).click();
	}

	/**
	 * Fill last name input
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysLastName(WebDriver driver, String str) {
		getLastName(driver).sendKeys(str);
	}

	/**
	 * Get username input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getUserName(WebDriver driver) {
		WebElement userName = driver.findElement(By.xpath(USERNAMEXPath));
		return userName;
	}

	/**
	 * Click username input
	 * @param driver
	 */
	public void clickUserName(WebDriver driver) {
		getUserName(driver).click();
	}

	/**
	 * Fill username input
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysUserName(WebDriver driver, String str) {
		getUserName(driver).sendKeys(str);
	}

	/**
	 * Get email input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEmail(WebDriver driver) {
		WebElement email = driver.findElement(By.xpath(EMAILXPath));
		return email;
	}

	/**
	 * Click email input
	 * 
	 * @param driver
	 */
	public void clickEmail(WebDriver driver) {
		getEmail(driver).click();
	}

	/**
	 * Fill email input
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysEmail(WebDriver driver, String str) {
		getEmail(driver).sendKeys(str);
	}

	
	/**
	 * Get password input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath(PASSWORDXPath));
		return password;
	}

	/**
	 * Click password input
	 * 
	 * @param driver
	 */
	public void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	/**
	 * Fill password input
	 * 
	 * @param driver
	 * @param str
	 */
	public void sendKeysPassword(WebDriver driver, String str) {
		getPassword(driver).sendKeys(str);
	}

	
	/**
	 * Get register by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getRegister(WebDriver driver) {
		WebElement register = driver.findElement(By.xpath(REGISTERBUTTONXPath));
		return register;
	}

	/**
	 * Click register button
	 * 
	 * @param driver
	 */
	public void clickRegister(WebDriver driver) {
		getRegister(driver).click();
	}
	
	/**
	 * navigate
	 * 
	 * @param driver
	 */
	public void navigateTo(WebDriver driver) {
		driver.navigate().to(PAGE_URL);
	}
}
