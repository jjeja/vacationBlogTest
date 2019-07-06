package page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	public static final String GALERIJA_URL = "http://localhost/izlet/gallery.php";
	private static final String GALERIJAXPath = "//nav[@class='main-nav']//a[@class='a_bold'][contains(text(),'Galerija')]";
	private static final String CONTACTUSXPath = "//a[@id='contact_btn']";
	private static final String BACKBUTTONXPath = "//a[@class='myButton']";
	
	
	/**
	 * Go to page
	 * 
	 * @param driver
	 */
	public void openPage(WebDriver driver) {
		driver.get(PAGE_URL);
	}

	
	/**
	 * Navigate
	 * 
	 * @param driver
	 */
	public void navigateTo(WebDriver driver) {
		driver.navigate().to(PAGE_URL);
	}
	

	/** 
	 * Get gallery link by XPath
	 *
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getGallery(WebDriver driver) {
		WebElement gallery = driver.findElement(By.xpath(GALERIJAXPath));
		return gallery;
	}

	/**
	 * Click gallery link
	 * 
	 * @param driver
	 */
	public void clickGallery(WebDriver driver) {
		getGallery(driver).click();
	}

	/**
	 * Get contact us button by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getContactUs(WebDriver driver) {
		WebElement contact = driver.findElement(By.xpath(CONTACTUSXPath));
		return contact;
	}

	/**
	 * Click contact us button
	 * 
	 * @param driver
	 */
	public void clickContactUs(WebDriver driver) {
		getContactUs(driver).click();
	}
	
	
	/**
	 * Get back button by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getBackButton(WebDriver driver) {
		WebElement backButton = driver.findElement(By.xpath(BACKBUTTONXPath));
		return backButton;
	}

	/**
	 * Click back button
	 * 
	 * @param driver
	 */
	public void clickBackButton(WebDriver driver) {
		getBackButton(driver).click();
	}

}
