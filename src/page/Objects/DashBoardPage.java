package page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {

	// static attributes
	public static final String DASHBOARD_URL = "http://localhost/izlet/dashboard.php";
	private static final String LogOutBUTTONXPath = "//a[@id='logoutBtn']";
	private static final String MAKEAPOSTXPath = "//a[contains(text(),'Make a post')]";
	private static final String DASHBOARDXPath = "//a[contains(text(),'Dashboard')]";
	private static final String PROFILEBUTTONXPath = "//div[@id='profileBtn']//img[@class='BtnImg']";

	
	/**
	 * navigate
	 * @param driver
	 */
	public void navigateTo(WebDriver driver) {
		driver.navigate().to(DASHBOARD_URL);
	}


	/**
	 * Get log out button by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getLogOut(WebDriver driver) {
		WebElement logOut = driver.findElement(By.xpath(LogOutBUTTONXPath));
		return logOut;
	}

	/**
	 * Click log out button
	 * 
	 * @param driver
	 */
	public void clickLogOut(WebDriver driver) {
		getLogOut(driver).click();
	}
	
	
	/**
	 * Gget make a post by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getMakeAPost(WebDriver driver) {
		WebElement makeApost = driver.findElement(By.xpath(MAKEAPOSTXPath));
		return makeApost;
	}
	
	/**
	 * click make a post button
	 * @param driver
	 */
	public void clickMakeAPost(WebDriver driver) {
		getMakeAPost(driver).click();
	}

	/**
	 * Get DashBoard button by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getDashboard(WebDriver driver) {
		WebElement dashboard = driver.findElement(By.xpath(DASHBOARDXPath));
		return dashboard;
	}

	/**
	 * Click DashBoard button
	 * 
	 * @param driver
	 */
	public void clickDashboard(WebDriver driver) {
		getDashboard(driver).click();
	}

	/**
	 * Get profile button by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getProfileButton(WebDriver driver) {
		WebElement profileButton = driver.findElement(By.xpath(PROFILEBUTTONXPath));
		return profileButton;
	}

	/**
	 * Click profile button
	 * 
	 * @param driver
	 */
	public void clickProfileButton(WebDriver driver) {
		getProfileButton(driver).click();
	}
}
