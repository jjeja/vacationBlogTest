package page.Tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.Objects.RegistrationPage;
import utility.ExcelUtils;
import utility.Constants;

public class RegistrationPageTest {

	private RegistrationPage registrationPage;

	/**
	 * class constructor
	 * creating an RegistrationPage instance 
	 */
	public RegistrationPageTest() {
		registrationPage = new RegistrationPage();
	}

	/**
	 * Method for manually fill registration form
	 *
	 * @param driver
	 */
	public void fillFormManually(WebDriver driver) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter required data:");

		// first name
		System.out.println("First name");
		registrationPage.clickFirstName(driver);
		String firstName = sc.nextLine();
		registrationPage.sendKeysFirstName(driver, firstName);

		// last name
		System.out.println("Last name");
		registrationPage.clickLastName(driver);
		String lastName = sc.nextLine();
		registrationPage.sendKeysLastName(driver, lastName);

		// user name
		System.out.println("User Name");
		registrationPage.clickUserName(driver);
		String userName = sc.nextLine();
		registrationPage.sendKeysUserName(driver, userName);

		// email
		System.out.println("Email");
		registrationPage.clickEmail(driver);
		String email = sc.nextLine();
		registrationPage.sendKeysEmail(driver, email);

		// password
		System.out.println("Password");
		registrationPage.clickPassword(driver);
		String password = sc.nextLine();
		registrationPage.sendKeysPassword(driver, password);

		// button register
		registrationPage.clickRegister(driver);
	}

	/**
	 * Method for automatically registration form with taking data from excel
	 * and send them to sendKeys method
	 * 
	 * @param driver
	 * @param i
	 * @throws Exception
	 */
	public void fillFormAutomatically(WebDriver driver, int i) throws Exception {
		String cellData;
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET1);

		// first name
		registrationPage.clickFirstName(driver);
		cellData = ExcelUtils.getCellData(i, 0);
		registrationPage.sendKeysFirstName(driver, cellData);

		// last name
		registrationPage.clickLastName(driver);
		cellData = ExcelUtils.getCellData(i, 1);
		registrationPage.sendKeysLastName(driver, cellData);

		// user name
		registrationPage.clickUserName(driver);
		cellData = ExcelUtils.getCellData(i, 2);
		registrationPage.sendKeysUserName(driver, cellData);

		// email
		registrationPage.clickEmail(driver);
		cellData = ExcelUtils.getCellData(i, 3);
		registrationPage.sendKeysEmail(driver, cellData);

		// pass
		registrationPage.clickPassword(driver);
		cellData = ExcelUtils.getCellData(i, 4);
		registrationPage.sendKeysPassword(driver, cellData);
		
		// register
		registrationPage.clickRegister(driver);

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
			
			if (i !=  ExcelUtils.getWorkSheet().getLastRowNum() + 1) {
				registrationPage.navigateTo(driver);
			}

		}
	}
}