package page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {

	// static attributes
	public static final String POSTS_CLASS = "posts";
	private static final String NAZIVXPath = "//input[@placeholder='Naziv']";
	private static final String LOKACIJAXPath = "//input[@placeholder='Lokacija']";
	private static final String BROWSEXPath = "//label[contains(text(),'Browse...')]";
	private static final String TRANSPORTXPath = "//div[@class='popupPost']//select[@name='transport']";
	private static final String OPISXPath = "//textarea[@placeholder='Opis']";
	private static final String POSTXPath = "//div[@class='popupPost']//input[@name='postSubmit']";
	private static final String IMAGE_PATH = "path_to_image";

	/**
	 * Get title input by XPath
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getTitle(WebDriver driver) {
		WebElement title = driver.findElement(By.xpath(NAZIVXPath));
		return title;
	}

	/**
	 * Click title input
	 * @param driver
	 */
	public void clickTitle(WebDriver driver) {
		getTitle(driver).click();
	}

	/**
	 * Fill title input
	 * 
	 * @param driver
	 * @param title
	 */
	public void sendKeysTitle(WebDriver driver, String title) {
		getTitle(driver).sendKeys(title);
	}

	/**
	 * Returns location input field
	 * 
	 * @param driver
	 * @return WebELement
	 */
	public WebElement getLocation(WebDriver driver) {
		WebElement location = driver.findElement(By.xpath(LOKACIJAXPath));
		return location;
	}

	/**
	 * Click location input field
	 * 
	 * @param driver
	 */
	public void clickLocation(WebDriver driver) {
		getLocation(driver).click();
	}

	/**
	 * Fill location input
	 * 
	 * @param driver
	 * @param location
	 */
	public void sendKeysLocation(WebDriver driver, String location) {
		getLocation(driver).sendKeys(location);
	}
	
	/**
	 * Get browse image button by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getBrowse(WebDriver driver) {
		WebElement browse = driver.findElement(By.xpath(BROWSEXPath));
		return browse;
	}

	/**
	 * Click browse image button
	 * 
	 * @param driver
	 */
	public void clickBrowse(WebDriver driver) {
		getBrowse(driver).click();
	}
	
	/**
	 * Get upload image container by id
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getUploadImage(WebDriver driver) {
		WebElement uploadElement = driver.findElement(By.id("image"));
		return uploadElement;
	}
	
	/**
	 * Upload image to the container
	 * 
	 * @param driver
	 */
	public void uploadImage (WebDriver driver) {
		getUploadImage(driver).sendKeys(IMAGE_PATH);
	}

	/**
	 * Get transport select by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getTransportation(WebDriver driver) {
		WebElement transport = driver.findElement(By.xpath(TRANSPORTXPath));
		return transport;
	}

	/**
	 * Select transport option
	 * 
	 * @param driver
	 * @param transport
	 */
	public void selectTransportation(WebDriver driver, String transport) {
		Select select = new Select(getTransportation(driver));
		select.selectByVisibleText(transport);
	}
	
	/**
	 * Get description input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getDescription(WebDriver driver) {
		WebElement description = driver.findElement(By.xpath(OPISXPath));
		return description;
	}

	/**
	 * Click description input 
	 * @param driver
	 */
	public void clickDescription(WebDriver driver) {
		getDescription(driver).click();
	}

	/**
	 * Fill description input
	 * 
	 * @param driver
	 * @param description
	 */
	public void sendKeysDescription(WebDriver driver, String description) {
		getDescription(driver).sendKeys(description);
	}
	
	/**
	 * Get post button by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getPostButton(WebDriver driver) {
		WebElement postButton = driver.findElement(By.xpath(POSTXPath));
		return postButton;
	}

	/**
	 * Click post button
	 * 
	 * @param driver
	 */
	public void clickPostButton(WebDriver driver) {
		getPostButton(driver).click();
	}

}
