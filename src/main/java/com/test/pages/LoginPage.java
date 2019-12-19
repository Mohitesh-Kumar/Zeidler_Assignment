package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.test.utils.TestBase;
import com.test.utils.TestUtil;

public class LoginPage extends TestBase {

	WebDriver LoginPage_driver;

	// Contructor using PageFactory to initialize the elements
	public LoginPage(WebDriver driver) {
		this.LoginPage_driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Creating WebElement for Username textbox
	@FindBy(how = How.XPATH, using = Login_page.userName_XPATH)
	private WebElement userName;
	//Creating WebElement for Password textbox
	@FindBy(how = How.XPATH, using = Login_page.passWord_XPATH)
	private WebElement passWord;
	//Creating WebElement for submit button
	@FindBy(how = How.XPATH, using = Login_page.loginButton_XPATH)
	private WebElement loginButton;
	@FindBy(how = How.XPATH, using = Login_page.logoutButton_XPATH)
	private WebElement logoutButton;

	//Method to enter username
	public void set_Username(String username)
	{
	
		try {
			if(TestUtil.isElementEnabled(userName,10))
			{
			userName.sendKeys(username);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Method to enter password
	public void set_Password(String password)
	{
		try {
			if(TestUtil.isElementEnabled(passWord,10))
			{
			passWord.sendKeys(password);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method to click login button
	public void click_LoginButton()
	{
		try {
			if(TestUtil.isElementEnabled(loginButton,10))
			{
			loginButton.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginUsingValidCredentials()
	{
		try {
			set_Username("demo@bigtreecms.org");
			set_Password("demo");
			click_LoginButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click_LogoutButton()
	{
		try {
			if(TestUtil.isElementEnabled(logoutButton,10))
			{
			logoutButton.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
