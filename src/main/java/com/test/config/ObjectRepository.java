package com.test.config;

/**
 * @author Mohitesh.B.Kumar
 *This is Object Class where all the web locators are declared.
 */
public class ObjectRepository {
	
	//This class contains locators of Login Page
	protected static class Login_page
	{
		
		public static final String userName_XPATH="//input[@id='user']";
		public static final String passWord_XPATH="//input[@id='password']";
		public static final String loginButton_XPATH="//input[@type='submit'][@value='Login']";
		public static final String logoutButton_XPATH="//a[@class='logout']";		
	}
	//This class contains locators of Files Page
	protected static class Files_Page
	{
		
	public static final String Files_XPATH="//a[text()='Files']";
	public static final String addImagesButton_XPATH="//nav[@id='sub_nav']/a[contains(text(),'Add Images')]";
	public static final String dragAndDropZone_XPATH="//form[@id='file_manager_dropzone']";
	public static final String continueButton_XPATH="//input[@type='submit'][@value='Continue']";
	public static final String updateFile_XPATH="//input[@type='submit'][@value='Update File']";
	public static final String resourceFileName="//input[@type='text'][@name='name']";
	public static final String uploadedImageList="//ul[@id='js-file-manager-results']/li";
	public static final String searchImages="//input[@class='form_search'][@id='js-file-manager-search']";
	public static final String resourceName_XPATH="//input[@id='field_file_name']";
	public static final String deleteFileButton_XPATH="//input[@type='submit'][@value='Delete File']";	
	
	

	}
	

}
