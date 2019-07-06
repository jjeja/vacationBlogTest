package page.Tests;

import org.openqa.selenium.WebDriver;

import page.Objects.EditDeletePost;

public class EditDeletePostTest {

	private EditDeletePost editDeletePost;

	/**
	 * class constructor
	 * creating an EditDeletePost instance
	 */
	public EditDeletePostTest() {
		editDeletePost = new EditDeletePost();
	}

	/**
	 * method deleting post
	 * 
	 * @param driver
	 */
	public void deletePost(WebDriver driver) {
		editDeletePost.clickDeleteButton(driver);
		System.out.println("Post is deleted.");
	}
	
	/**
	 * method edit post
	 * 
	 * @param driver
	 * @param newTitle
	 * @param newLocation
	 * @param newTransport
	 * @param newDescription
	 */
	public void editPost(WebDriver driver, String newTitle, String newLocation, String newTransport, String newDescription) {
		editDeletePost.clickEditTitle(driver);
		editDeletePost.clearEditTitle(driver);
		editDeletePost.sendKeysEditTitle(driver, newTitle);

		// edit location
		editDeletePost.clickEditLocation(driver);
		editDeletePost.clearEditLocation(driver);
		editDeletePost.sendKeysEditLocation(driver, newLocation);

		// edit transportation
		editDeletePost.clickEditTransportation(driver);
		editDeletePost.selectTransportation(driver, newTransport);

		// edit description
		editDeletePost.clickEditDescription(driver);
		editDeletePost.clearEditDescription(driver);
		editDeletePost.sendKeysEditDescription(driver, newDescription);

		// submit
		editDeletePost.clickSubmitEditedPost(driver);

	}

}
