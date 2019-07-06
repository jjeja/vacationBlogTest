package page.Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditDeletePost {

	// static attributes
	private static final String COMMENTBUTTON_ID = "commentBtn";
	private static final String ADDCOMMENTXPath = "//textarea[@name='text']";
	private static final String SUBMITCOMMENTXPath = "//input[@name='dodaj']";
	private static final String EXPANDBUTTON_CLASS = "fa-ellipsis-v";
	private static final String EDITBUTTONS_CLASS = "fa-edit";
	private static final String DELETEBUTTONS_CLASS = "fa-trash-alt";
	private static final String EDITtitleXPath = "//input[@id='title']";
	private static final String EDITlocationXPath = "//input[@id='location']";
	private static final String CHANGEimageXPath = "//label[contains(text(),'Change...')]";
	private static final String EDITtransportXPath = "//select[@id='transport']";
	private static final String EDITdescriptionXPath = "//textarea[@id='description']";
	private static final String SUBMITpostXPath = "//div[@class='popupEdit']//input[@name='postSubmit']";

	/**
	 * Get comment button by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getCommentButton(WebDriver driver) {
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		System.out.println(posts.size());
		return posts.get(0).findElement(By.id(COMMENTBUTTON_ID));
	}

	/**
	 * Click comment button
	 * 
	 * @param driver
	 */
	public void clickCommentButton(WebDriver driver) {
		getCommentButton(driver).click();
	}
	
	/**
	 * Get add comment text area by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getAddCommentTextArea(WebDriver driver) {
		WebElement addComment = driver.findElement(By.xpath(ADDCOMMENTXPath));
		return addComment;
	}
	
	/**
	 * Click in text area
	 *
	 * @param driver
	 */
	public void clickAddCommentTextArea(WebDriver driver) {
		getAddCommentTextArea(driver).click();
	}
	
	/**
	 * Insert comment in text area
	 * 
	 * @param driver
	 * @param comment
	 */
	public void sendKeysAddComment(WebDriver driver, String comment) {
		getAddCommentTextArea(driver).sendKeys(comment);
	}
	

	/**
	 * Get submit comment button by XPath
	 * 
	 * @param driver
	 * @return WebELement
	 */
	public WebElement getSubmitComment(WebDriver driver) {
		WebElement submitComment = driver.findElement(By.xpath(SUBMITCOMMENTXPath));
		return submitComment;
	}
	
	/**
	 * Click submit comment button
	 * 
	 * @param driver
	 */
	public void clickSubmitComment(WebDriver driver) {
		getSubmitComment(driver).click();
	}


	/**
	 * Get expand button by XPath
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement getExpandButton(WebDriver driver) {
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		System.out.println(posts.size());
		// if not woring take parent of EXPANDBUTTON_CLASS
		return posts.get(0).findElement(By.className(EXPANDBUTTON_CLASS));//.findElement(By.xpath("./.."));
	}

	/**
	 * Click expand button
	 * 
	 * @param driver
	 */
	public void clickExpandButton(WebDriver driver) {
		getExpandButton(driver).click();
	}


	/**
	 * Get delete button by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getDeleteButton(WebDriver driver) {
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		System.out.println(posts.size());
		return posts.get(0).findElement(By.className(DELETEBUTTONS_CLASS));
	}

	/**
	 * Click delete button
	 * 
	 * @param driver
	 */
	public void clickDeleteButton(WebDriver driver) {
		getDeleteButton(driver).click();
	}

	
	/**
	 * Get edit button
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEditButton(WebDriver driver) {
		List<WebElement> posts = driver.findElements(By.className(PostPage.POSTS_CLASS));
		System.out.println(posts.size());
		return posts.get(0).findElement(By.className(EDITBUTTONS_CLASS));
	}

	/**
	 * Click edit button
	 * 
	 * @param driver
	 */
	public void clickEditButton(WebDriver driver) {
		getEditButton(driver).click();
	}

	/**
	 * Get edit title input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEditTitle(WebDriver driver) {
		WebElement editTitle = driver.findElement(By.xpath(EDITtitleXPath));
		return editTitle;
	}

	/**
	 * Click edit title input
	 * @param driver
	 */
	public void clickEditTitle(WebDriver driver) {
		getEditTitle(driver).click();
	}
	
	/**
	 * Clear edit title input
	 * 
	 * @param driver
	 */
	public void clearEditTitle (WebDriver driver) {
		getEditTitle(driver).clear();
	}

	/**
	 * Fill edit title input
	 * @param driver
	 * @param editedTitle
	 */
	public void sendKeysEditTitle(WebDriver driver, String editedTitle) {
		getEditTitle(driver).sendKeys(editedTitle);
	}

	
	/**
	 * Get edit location input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEditLocation(WebDriver driver) {
		WebElement editLocation = driver.findElement(By.xpath(EDITlocationXPath));
		return editLocation;
	}

	/**
	 * Click edit location input
	 * 
	 * @param driver
	 */
	public void clickEditLocation(WebDriver driver) {
		getEditLocation(driver).click();
	}
	
	/**
	 * clear edit location text from the input
	 * @param driver
	 */
	public void clearEditLocation (WebDriver driver) {
		getEditLocation(driver).clear();
	}

	/**
	 * Fill edit location input
	 * 
	 * @param driver
	 * @param editedLocation
	 */
	public void sendKeysEditLocation(WebDriver driver, String editedLocation) {
		getEditLocation(driver).sendKeys(editedLocation);
	}

	/**
	 * Get change image button
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getChangeImage(WebDriver driver) {
		WebElement changeImage = driver.findElement(By.xpath(CHANGEimageXPath));
		return changeImage;
	}

	/**
	 * Click change image button
	 * @param driver
	 */
	public void clickChangeImage(WebDriver driver) {
		getChangeImage(driver).click();
	}
	
	/**
	 * Get edit transportation select box byXPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEditTransportation(WebDriver driver) {
		WebElement editTransportation = driver.findElement(By.xpath(EDITtransportXPath));
		return editTransportation;
	}

	/**
	 * Click edit transport select
	 * 
	 * @param driver
	 */
	public void clickEditTransportation(WebDriver driver) {
		getEditTransportation(driver).click();
	}

	/**
	 * Select transport option
	 * 
	 * @param driver
	 * @param editedTransport
	 */
	public void selectTransportation(WebDriver driver, String editedTransport) {
		Select select = new Select(getEditTransportation(driver));
		select.selectByVisibleText(editedTransport);
	}

	/**
	 * Get edit description input by XPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getEditDescription(WebDriver driver) {
		WebElement editDescription = driver.findElement(By.xpath(EDITdescriptionXPath));
		return editDescription;
	}

	/**
	 * Click edit description input
	 * 
	 * @param driver
	 */
	public void clickEditDescription(WebDriver driver) {
		getEditDescription(driver).click();
	}
	
	/**
	 * Clear description text
	 * @param driver
	 */
	public void clearEditDescription (WebDriver driver) {
		getEditDescription(driver).clear();
	}

	/**
	 * fill edit description input
	 * 
	 * @param driver
	 * @param editedDescription
	 */
	public void sendKeysEditDescription(WebDriver driver, String editedDescription) {
		getEditDescription(driver).sendKeys(editedDescription);
	}

	/**
	 * Get submit edited post button byXPath
	 * 
	 * @param driver
	 * @return WebElement
	 */
	public WebElement getSubmitEditedPost(WebDriver driver) {
		WebElement submitEditedPost = driver.findElement(By.xpath(SUBMITpostXPath));
		return submitEditedPost;
	}

	/**
	 * Click submit edited post button
	 * 
	 * @param driver
	 */
	public void clickSubmitEditedPost(WebDriver driver) {
		getSubmitEditedPost(driver).click();
	}
}
