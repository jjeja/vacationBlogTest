package page.Tests;

import org.openqa.selenium.WebDriver;

import page.Objects.DashBoardPage;
import page.Objects.PostPage;
import utility.Constants;
import utility.ExcelUtils;

public class PostPageTest {
	
	private PostPage postPage;

	/**
	 * class constructor
	 * creating an PostPage instance
	 */
	public PostPageTest() {
		postPage = new PostPage();
	}
	
	/**
	 * Method for manually making a post
	 * 
	 * @param driver
	 * @param title
	 * @param location
	 * @param transport
	 * @param description
	 */
	public void makeAPostManually(WebDriver driver, String title, String location, String transport, String description) {
	
		// title
		postPage.clickTitle(driver);
		postPage.sendKeysTitle(driver, title);
		
		// location
		postPage.clickLocation(driver);
		postPage.sendKeysLocation(driver, location);
		
		// image
		postPage.uploadImage(driver);
		
		// transport
		postPage.getTransportation(driver).click();
		postPage.selectTransportation(driver, transport);
		
		// description
		postPage.clickDescription(driver);
		postPage.sendKeysDescription(driver, description);
		
		// click post button
		postPage.clickPostButton(driver);
	}
	
	/**
	 * Method for automatic getting cells from excel and send them to sendKeys method
	 * 
	 * @param driver
	 * @param i
	 * @throws Exception
	 */
	public void makePost(WebDriver driver, int i) throws Exception {
		// set the path and name to excel file
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET2);
		
		// title
		postPage.clickTitle(driver);
		String title = ExcelUtils.getCellData(i, 1);
		postPage.sendKeysTitle(driver, title);
		
		// location
		postPage.clickLocation(driver);
		String location = ExcelUtils.getCellData(i, 2);
		postPage.sendKeysLocation(driver, location);
		
		// description
		postPage.clickDescription(driver);
		String description = ExcelUtils.getCellData(i, 0);
		postPage.sendKeysDescription(driver, description);
		
		// click post button
		postPage.clickPostButton(driver);
	}
	 
	/**
	 * Method make a new post automatically with all data from excel
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void makeAPostAutomaticallyForAllPosts(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET2);
		DashBoardPage dashboardPage = new DashBoardPage();
		dashboardPage.clickMakeAPost(driver);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			makePost(driver, i);
			
			if (i != ExcelUtils.getWorkSheet().getLastRowNum() + 1) {
				dashboardPage.clickMakeAPost(driver);
			}
		}
	}

}
