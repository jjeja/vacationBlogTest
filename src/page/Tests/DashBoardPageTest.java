package page.Tests;

import org.openqa.selenium.WebDriver;

import page.Objects.DashBoardPage;
import page.Objects.HomePage;

public class DashBoardPageTest {
	private DashBoardPage dashBoardPage;
	
	/**
	 * class constructor
	 * creating an DashBoardPage instance
	 */
	public DashBoardPageTest() {
		dashBoardPage = new DashBoardPage();
	}
	
 
	/**
	 * Method for log out
	 * 
	 * @param driver
	 */
	public void logOut(WebDriver driver) {
		dashBoardPage.clickLogOut(driver);
	}

	/**
	 * Method go to person profile
	 * 
	 * @param driver
	 */
	public void goToProfile(WebDriver driver) {
		dashBoardPage.clickProfileButton(driver);
	}

}
