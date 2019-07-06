package pageMain;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Objects.DashBoardPage;
import page.Objects.EditDeletePost;
import page.Objects.HomePage;
import page.Objects.LogInPage;
import page.Objects.PostPage;
import page.Objects.RegistrationPage;
import page.Tests.DashBoardPageTest;
import page.Tests.EditDeletePostTest;
import page.Tests.HomePageTest;
import page.Tests.LogInPageTest;
import page.Tests.PostPageTest;
import page.Tests.RegistrationPageTest;
import utility.Constants;
import utility.ExcelUtils;

public class Main {
	
	ChromeDriver driver;
	
	HomePageTest homePageTest;
	
	// run before class, create driver
	@BeforeClass
	public void setUp() throws Exception {
		System.out.println("setup");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePageTest = new HomePageTest();
	}
	
	// execute before every test method, open home page
	@BeforeMethod
	private void setUpBeforeMethod() {
		homePageTest.openPage(driver);
	}
	
	
	// run after all the tests, quit driver
	@AfterClass
	public void quit() {
		driver.quit();
	}
	
	// test open page 
	@Test
	private void testOpenPage () {
		Assert.assertEquals(driver.getCurrentUrl(), HomePage.PAGE_URL);
	}
	
	// registration of customers manually
	@Test
	public void testRegistrationManually() throws InterruptedException {
		RegistrationPageTest registrationPageTest = new RegistrationPageTest();
		registrationPageTest.fillFormManually(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), RegistrationPage.PAGE_URL);
	}
	
	// 
	@Test
	public void testRegistationAutomatically () throws Exception {
		RegistrationPageTest registrationPageTest = new RegistrationPageTest();
		registrationPageTest.fillFormAutomaticallyForEveryCustomer(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), RegistrationPage.PAGE_URL);
	}
	
	@Test
	public void testLogInManually () {
		LogInPageTest loginPageTest = new LogInPageTest();
		loginPageTest.fillFormManually(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), DashBoardPage.DASHBOARD_URL);
	}
	
	@Test
	public void testLogInAutomatically () throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		loginPageTest.fillFormAutomaticallyForEveryCustomer(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), LogInPage.PAGE_URL);
	}
	
	@Test
	public void testMakeAPostManually() throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		PostPageTest postPageTest = new PostPageTest();
		DashBoardPage dashboardPage = new DashBoardPage();

		loginPageTest.fillFormAutomatically(driver, 4);
		dashboardPage.clickMakeAPost(driver);
		
		// get all data from keyboard
		Scanner sc = new Scanner (System.in);
		System.out.println("Make a post by typing data manually");
		System.out.println("Add title");
		String title = sc.nextLine();
		System.out.println("Add location");
		String location = sc.nextLine();
		System.out.println("Add transport");
		String transport = sc.nextLine();
		System.out.println("Add description");
		String description = sc.nextLine();

		postPageTest.makeAPostManually(driver, title, location, transport, description);

		// refresh page
		DashBoardPage dashBoardPage = new DashBoardPage();
		dashBoardPage.navigateTo(driver);

		// get all posts
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		// get title from the first post
		WebElement titleHolder = posts.get(0).findElement(By.tagName("h2"));
		String actualPostTitle = titleHolder.getText();
		
		Assert.assertEquals(actualPostTitle, title);
	}
	
	@Test
	public void testMakeAPostAutomatically() throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		PostPageTest postPageTest = new PostPageTest();
		DashBoardPage dashBoardPage = new DashBoardPage();

		loginPageTest.fillFormAutomatically(driver, 4);

		// insert posts
		postPageTest.makeAPostAutomaticallyForAllPosts(driver);

		// get excel file
		ExcelUtils.setExcelFile(Constants.DATAXPath + Constants.DATAFile, Constants.SHEET2);
		
		// get all posts
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		int postNum = 0;
		int count =  ExcelUtils.getWorkSheet().getLastRowNum();
		// go from the end of the excel file and compare it with posts from top to the bottom
		for (int i = count; i > 0; i--) {
			String title = ExcelUtils.getCellData(i, 1);
			WebElement titleHolder = posts.get(postNum).findElement(By.tagName("h2"));
			String actualPostTitle = titleHolder.getText();
			Assert.assertEquals(actualPostTitle, title);
			postNum++;
		}
		
		dashBoardPage.navigateTo(driver);
	}
	
	@Test
	public void testAddComment () throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		DashBoardPage dashBoardPage = new DashBoardPage();
		EditDeletePost editDeletePost = new EditDeletePost();
		String comment = "This was a very fun roadtrip.";
		
		// add comment
		loginPageTest.fillFormAutomatically(driver, 4);
		editDeletePost.clickCommentButton(driver);
		editDeletePost.clickAddCommentTextArea(driver);
		editDeletePost.sendKeysAddComment(driver, comment);
		editDeletePost.clickSubmitComment(driver);
		
		// refresh page
		dashBoardPage.navigateTo(driver);
       
		// get comment text so we could compare it
		editDeletePost.clickCommentButton(driver);
		editDeletePost.clickAddCommentTextArea(driver);
		String newComment = editDeletePost.getAddCommentTextArea(driver).getText();
		
		Assert.assertEquals(newComment, comment);
	}
	
	@Test
	public void testDeletePost () throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		EditDeletePost editDeletePost = new EditDeletePost();
		PostPageTest postPageTest = new PostPageTest();
		DashBoardPage dashboardPage = new DashBoardPage();
		
		loginPageTest.fillFormAutomatically(driver, 4);
		
		// add 4 posts, first 4 posts from excel, so we could have editable posts to delete and test
		dashboardPage.clickMakeAPost(driver);
		postPageTest.makePost(driver, 1);
		dashboardPage.clickMakeAPost(driver);
		postPageTest.makePost(driver, 2);
		dashboardPage.clickMakeAPost(driver);
		postPageTest.makePost(driver, 3);
		dashboardPage.clickMakeAPost(driver);
		postPageTest.makePost(driver, 4);

		// get all posts
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		
		// get titles from the first and second post
		String firstPostTitle = posts.get(0).findElement(By.tagName("h2")).getText(),
				secondPostTitle = posts.get(1).findElement(By.tagName("h2")).getText();
		
		// delete first post
		editDeletePost.clickExpandButton(driver);
		editDeletePost.clickDeleteButton(driver);
		
		// delete second post
		editDeletePost.clickExpandButton(driver);
		editDeletePost.clickDeleteButton(driver);
		
		// refresh page
		DashBoardPage dashBoardPage = new DashBoardPage();
		dashBoardPage.navigateTo(driver);
		       
		// get posts (updated)
		List<WebElement> newPosts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		
		// new post titles
		String newFirstPostTitle = newPosts.get(0).findElement(By.tagName("h2")).getText(),
				newSecondPostTitle = newPosts.get(1).findElement(By.tagName("h2")).getText();

		Assert.assertNotEquals(newFirstPostTitle, firstPostTitle);
		Assert.assertNotEquals(newSecondPostTitle, secondPostTitle);
	}
	
	@Test
	public void testEditPost() throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		EditDeletePost editDeletePost = new EditDeletePost();
		EditDeletePostTest editDeletePostTest = new EditDeletePostTest();
		DashBoardPage dashboardPage = new DashBoardPage();
		PostPageTest postPageTest = new PostPageTest();
		


		loginPageTest.fillFormAutomatically(driver, 4);
		
		// add post so we could edit it
		dashboardPage.clickMakeAPost(driver);
		postPageTest.makePost(driver, 1);
		
		editDeletePost.clickExpandButton(driver);
		editDeletePost.clickEditButton(driver);
		String newTitle ="newTitle",
				newLocation = "newLocation",
				newTransport = "Walk",
				newDescription = "newDescription";
		
		// request was to enter it manually
		Scanner sc = new Scanner(System.in);
		System.out.println("Edit title:");
		newTitle = sc.nextLine();
		System.out.println("location");
		newLocation = sc.nextLine();
		System.out.println("transport");
		newTransport = sc.nextLine();
		System.out.println("description");
		newDescription = sc.nextLine();
		
		editDeletePostTest.editPost(driver, newTitle, newLocation, newTransport, newDescription);
		
		// refresh page
		DashBoardPage dashBoardPage = new DashBoardPage();
		dashBoardPage.navigateTo(driver);
		
		// reload every post and get new values, so we could compare them
		editDeletePost.clickExpandButton(driver);
		editDeletePost.clickEditButton(driver);
		String editedTitle = editDeletePost.getEditTitle(driver).getAttribute("value");
		String editedLocation = editDeletePost.getEditLocation(driver).getAttribute("value");
		String editedTransport = editDeletePost.getEditTransportation(driver).getAttribute("value");
		String editedDescription = editDeletePost.getEditDescription(driver).getAttribute("value");
		
		Assert.assertEquals(editedTitle, newTitle);
		Assert.assertEquals(editedLocation, newLocation);
		Assert.assertEquals(editedTransport, newTransport.toLowerCase());
		Assert.assertEquals(editedDescription, newDescription);
	}
	
	@Test
	public void testLogOut() throws Exception {
		LogInPageTest loginPageTest = new LogInPageTest();
		DashBoardPageTest dashboardPageTest = new DashBoardPageTest();

		loginPageTest.fillFormAutomatically(driver, 4);
		dashboardPageTest.logOut(driver);

		Assert.assertEquals(driver.getCurrentUrl(), HomePage.PAGE_URL);
	}
	

}
