package com.test.pages;

import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import com.test.utils.TestBase;
import com.test.utils.TestUtil;

public class FilesPage extends TestBase {

	WebDriver FilesPage_driver;
	String sikuliImagePath = System.getProperty("user.dir") + "\\src\\main\\resources\\SikuliImages\\";

	public FilesPage(WebDriver driver) {
		this.FilesPage_driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = Files_Page.Files_XPATH)
	private WebElement filesButton;

	@FindBy(how = How.XPATH, using = Files_Page.addImagesButton_XPATH)
	private WebElement addImagesButton;

	@FindBy(how = How.XPATH, using = Files_Page.dragAndDropZone_XPATH)
	private WebElement dragAndDropZone;
	@FindBy(how = How.XPATH, using = Files_Page.continueButton_XPATH)
	private WebElement continueButton;

	@FindBy(how = How.XPATH, using = Files_Page.resourceName_XPATH)
	private WebElement resourceName;

	@FindBy(how = How.XPATH, using = Files_Page.updateFile_XPATH)
	private WebElement updateFileButton;
	@FindBy(how = How.XPATH, using = Files_Page.uploadedImageList)
	private List<WebElement> ImageList;
	
	@FindBy(how = How.XPATH, using = Files_Page.deleteFileButton_XPATH)
	private WebElement deleteFileButton;
	

	public void filesButton_click()

	{
		try {
			if (TestUtil.isElementEnabled(filesButton, 10)) {
				filesButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addImagesButton_Click() {
		try {
			if (TestUtil.isElementEnabled(addImagesButton, 10)) {
				addImagesButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadJPEGImageBySelectingFile() {
		try {
			
			dragAndDropZone.click();
			String uploadJPEGImagePath = sikuliImagePath + "SampleImage.jpg";
			String fileInputTextBoxImagePath = sikuliImagePath + "fileTextBox.PNG";
			String openbuttonImagePath = sikuliImagePath + "openButton.PNG";
			uploadImageUsingSikuli(uploadJPEGImagePath, fileInputTextBoxImagePath, openbuttonImagePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadPngImageBySelectingFile() {
		try {
			dragAndDropZone.click();
			String uploadPNGImagePath = sikuliImagePath + "SamplePNGImage.png";
			String fileInputTextBoxImagePath = sikuliImagePath + "fileTextBox.PNG";
			String openbuttonImagePath = sikuliImagePath + "openButton.PNG";
			uploadImageUsingSikuli(uploadPNGImagePath, fileInputTextBoxImagePath, openbuttonImagePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean ifPNGImageThumbnailDisplayed() {
		if (TestUtil.ifImageExist(sikuliImagePath + "afterUploadPNGImage.PNG") == true) {
			return true;
		} else {
			return false;
		}
	}
	public boolean ifJPEGImageThumbnailDisplayed() {
		if (TestUtil.ifImageExist(sikuliImagePath + "afterUploadJPEGImageThumbnail.PNG") == true) {
			return true;
		} else {
			return false;
		}
	}

	public void uploadImageUsingSikuli(String uploadImagePath, String fileInputTextBoxImagePath,
			String openbuttonImagePath) throws FindFailed {
		Screen screen = new Screen();
		Pattern fileInputTextBox = new Pattern(fileInputTextBoxImagePath);
		Pattern openButton = new Pattern(openbuttonImagePath);
		screen.type(fileInputTextBox, uploadImagePath);
		screen.click(openButton);
	}

	public void continueButton_click() {
		try {
			Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(continueButton));
				continueButton.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean continueButton_isEnabled() {
		try {
			if (TestUtil.isElementEnabled(continueButton, 30)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean dragAndDropZone_isEnabled() {
		try {
			if (TestUtil.isElementDisplayed(dragAndDropZone, 10) == true) {
				log.info("dragAndDropZone is displayed and enabled");
				return true;
			} else {
				log.info("dragAndDropZone is not displayed on screen");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setResourceName(String imageName, String imageExtension) {
		if (TestUtil.isElementDisplayed(resourceName, 20) == true) {
			try {
				long now = Instant.now().toEpochMilli();
				resourceName.clear();
				resourceName.sendKeys(imageName + "_" + now + imageExtension);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else {
			log.info("Element nout s=found");
		}
		;
	}

	public String getResourceName() {
		try {
			return resourceName.getAttribute("value");

		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}
	}

	public boolean editFilePageThumbnailIsDisplayed() {
		if (TestUtil.ifImageExist(sikuliImagePath + "EditFilePageThumbnail.PNG") == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean editFilePageJPEGThumbnailIsDisplayed() {
		if (TestUtil.ifImageExist(sikuliImagePath + "EditFilePageJPEGThumbnail.PNG") == true) {
			return true;
		} else {
			return false;
		}
	}

	public void updateFileButton_click() {
		try {
			if (TestUtil.isElementEnabled(updateFileButton, 20)) {
				updateFileButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateImageDetailsInImageList(String imageName, String imageType, String imageSize) {
		int count = ImageList.size();
		boolean isImagePresent = false;
		for (int i = 1; i <= count; i++) {
			String imageNamefromList = driver
					.findElement(By.xpath("//ul[@id='js-file-manager-results']/li[" + i + "]" + "/section[2]"))
					.getText();
			String imageTypefromList = driver
					.findElement(By.xpath("//ul[@id='js-file-manager-results']/li[" + i + "]" + "/section[3]"))
					.getText();
			String imageSizefromList = driver
					.findElement(By.xpath("//ul[@id='js-file-manager-results']/li[" + i + "]" + "/section[4]"))
					.getText();
			if (imageNamefromList.equalsIgnoreCase(imageName) && imageTypefromList.equalsIgnoreCase(imageType)
					&& imageSizefromList.equalsIgnoreCase(imageSize)) {
				isImagePresent = true;
				break;
			}
		}
		return isImagePresent;
	}

	public void deleteImageFromImageList(String imageName) 
	{	int count = ImageList.size();
	for (int i = 1; i <= count; i++) {
		String imageNamefromList = driver
				.findElement(By.xpath("//ul[@id='js-file-manager-results']/li[" + i + "]" + "/section[2]"))
				.getText();
		
		if (imageNamefromList.equalsIgnoreCase(imageName)) {
			WebElement deleteButton=driver.findElement(By.xpath("//ul[@id='js-file-manager-results']/li[" + i + "]" + "/section[6]/a"));
			WebDriverWait wait= new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
			deleteButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(deleteFileButton));
			deleteFileButton.click();
			log.info("Image "+imageName+" has been deleted successfully");
			break;
		}
	}

}
	

	{
	}
}
