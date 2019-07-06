package page.Tests;

import org.openqa.selenium.WebDriver;

import page.Objects.HomePage;

public class HomePageTest {

	private HomePage homePage;
	
	/**
	 * class constructor
	 * creating an HomePage instance
	 */
	public HomePageTest() {
		homePage = new HomePage();
	}
	
	/**
	 * method opens home page
	 * 
	 * @param driver
	 */
	public void openPage(WebDriver driver) {
		homePage.openPage(driver);
	}
	
	/**
	 * method goes to gallery
	 * 
	 * @param driver
	 */
	public void goToGallery(WebDriver driver) {
		homePage.clickGallery(driver);
	}
	
	/**
	 * method navigate from gallery to home page
	 * 
	 * @param driver
	 */
	public void goBackOnHomePage(WebDriver driver) {
		homePage.clickBackButton(driver);
	}

}
