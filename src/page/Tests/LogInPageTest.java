package page.Tests;

import java.util.Scanner;
import page.Objects.*;

import org.openqa.selenium.WebDriver;

import utility.Constants;
import utility.ExcelUtils;

public class LogInPageTest {

	private LogInPage loginPage;

	/**
	 * class constructor
	 * creating an LogInPage instance
	 */
	public LogInPageTest() {
		loginPage = new LogInPage();
	}

	
	/**
	 * method for manually fill logIn form
	 *
	 * @param driver
	 */
	public void fillFormManually(WebDriver driver) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter required data:");

		// user name
		System.out.println("User Name");
		loginPage.clickUserName(driver);
		String userName = sc.nextLine();
		loginPage.sendKeysUserName(driver, userName);

		// pass
		System.out.println("Password");
		loginPage.clickPassword(driver);
		String password = sc.nextLine();
		loginPage.sendKeysPassword(driver, password);

		// login button
		loginPage.clickLogIn(driver);

	}

	/**
	 * Method for automatic getting cells from excel and send them to sendKeys method
	 * 
	 * @param driver
	 * @param i
	 * @throws Exception
	 */
	public void fillFormAutomatically(WebDriver driver, int i) throws Exception {
		String cellData;
		// set the path and name to excel file
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET1);

		// userName
		loginPage.clickUserName(driver);
		cellData = ExcelUtils.getCellData(i, 2);
		loginPage.sendKeysUserName(driver, cellData);

		// password
		loginPage.clickPassword(driver);
		cellData = ExcelUtils.getCellData(i, 4);
		loginPage.sendKeysPassword(driver, cellData);

		// login button
		loginPage.clickLogIn(driver);
	}

	/**
	 * Method for automatically registration form for every member
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void fillFormAutomaticallyForEveryCustomer(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET1);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillFormAutomatically(driver, i);

			if (i != ExcelUtils.getWorkSheet().getLastRowNum() + 1) {
				loginPage.navigateTo(driver);
			}

		}
	}
}
