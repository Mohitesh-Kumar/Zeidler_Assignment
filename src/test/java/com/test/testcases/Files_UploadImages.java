package com.test.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pages.FilesPage;
import com.test.pages.LoginPage;
import com.test.utils.TestBase;

public class Files_UploadImages extends TestBase {
	String resourceJPEGName="";
	String resourcePNGName="";
	@Test(description="TC_001 - Add Image by selecting single JPEG image from file system",enabled = true, priority=2)
	public void UploadJPEGImage() {
		try {
		// Creating object of the LoginPage and FilesPage
			
		LoginPage loginpage = new LoginPage(driver);
		FilesPage filespage = new FilesPage(driver);
		driver.get("https://demo.bigtreecms.org/admin/login/");
		
		/// ***********Login to BigTreeCms using valid credentials
		
		loginpage.loginUsingValidCredentials();
		
		// ***********Navigate to Files tab************************
		
		filespage.filesButton_click();
		// ***********Navigate to addImages tab********************
		
		filespage.addImagesButton_Click();

		// Assert if drag dragAndDropZone is Enabled or not
		
		Assert.assertEquals(filespage.dragAndDropZone_isEnabled(), true);
		
		// Assert if drag continue button is disabled before uploading image
		//Assert.assertEquals(filespage.continueButton_isEnabled(),false,"Continue button is enabled before uploading any image");

		// ***********Uploading PNG file*************************************************
		
		filespage.uploadJPEGImageBySelectingFile();
		
		// Assert if drag continue is enabled or not
		
		Assert.assertEquals(filespage.continueButton_isEnabled(), true);
		if (filespage.continueButton_isEnabled() == true) {
			Assert.assertEquals(filespage.ifJPEGImageThumbnailDisplayed(), true, "After upload Image thumbnail Not found");
			log.info("Image Uploaded and Thumbnail is displayed on screen");
		}
		//Click on continue button
		filespage.continueButton_click();
		
		//Set file name for image
		filespage.setResourceName("TestJPEGFile", ".JPEG");
		resourceJPEGName = filespage.getResourceName();
		//Update file button click
		filespage.updateFileButton_click();
		//check if uploaded image in visible in the list
		Assert.assertEquals(filespage.validateImageDetailsInImageList(resourceJPEGName, "image/jpeg", "299 x 168"), true,
				"Image not found in the List");
	
	//logout
		loginpage.click_LogoutButton();
	}
	catch(Exception e)
		{e.printStackTrace();}
	}

	@Test(description="TC_002 - Add Image by selecting single PNG image from file system",priority=1, enabled=true)
	public void UploadPNGImage() {
		try {
		// Creating object of the LoginPage and FilesPage
		LoginPage loginpage = new LoginPage(driver);
		FilesPage filespage = new FilesPage(driver);

		///Login to BigTreeCms using valid credentials
		loginpage.loginUsingValidCredentials();
		// Navigate to Files tab
		filespage.filesButton_click();
		//Navigate to addImagestab
		filespage.addImagesButton_Click();

		// Assert if drag dragAndDropZone is Enabled or not
		Assert.assertEquals(filespage.dragAndDropZone_isEnabled(), true);
		// Assert if drag dragAndDropZone is disabled or not
		//Assert.assertEquals(filespage.continueButton_isEnabled(),false,"Continue button is enabled before uploading any image");
		// Uploading PNG file
		filespage.uploadPngImageBySelectingFile();
		// Assert if drag continue button is enabled or not
		Assert.assertEquals(filespage.continueButton_isEnabled(), true,"Continue button is disabled");
		if (filespage.continueButton_isEnabled() == true) {
			//assert if thumbnail is displayed
			Assert.assertEquals(filespage.ifPNGImageThumbnailDisplayed(), true, "After upload Image thumbnail Not found");
			log.info("Image Uploaded and Thumbnail is displayed on screen");
		}
		//click continue button
		filespage.continueButton_click();
		//Assert thumbnail image
		Assert.assertEquals(filespage.editFilePageThumbnailIsDisplayed(), true,
				"After upload Image thumbnail Not found");
		filespage.setResourceName("TestPNGFile", ".PNG");
		resourcePNGName = filespage.getResourceName();
		filespage.updateFileButton_click();

		//Assert image details in the list
		Assert.assertEquals(filespage.validateImageDetailsInImageList(resourcePNGName, "image/png", "272 x 170"), true,
				"Image not found in the List");
		//logout
		loginpage.click_LogoutButton();
		}
		catch(Exception e)
		{e.printStackTrace();}

	}

	@Test(priority=3, enabled=true)
	public void DeleteImage()
	{
		try {
		LoginPage loginpage = new LoginPage(driver);
		FilesPage filespage = new FilesPage(driver);
		driver.get("https://demo.bigtreecms.org/admin/login/");
		
		/// Login to BigTreeCms using valid credentials
		loginpage.loginUsingValidCredentials();
		// Navigate to Files tab
		filespage.filesButton_click();
		// Delete uploaded images
		if(!resourceJPEGName.equalsIgnoreCase("")) {
		filespage.deleteImageFromImageList(resourceJPEGName);
		}
		if(!resourcePNGName.equalsIgnoreCase("")) {
		filespage.deleteImageFromImageList(resourcePNGName);
		}
		//logout
		loginpage.click_LogoutButton();
		}
		catch(Exception e){e.printStackTrace();}
	
	}
}
