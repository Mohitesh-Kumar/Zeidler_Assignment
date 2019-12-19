package com.test.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.utils.TestBase;
import com.test.utils.TestUtil;

public class HomePage extends TestBase {
	
	static WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		HomePage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * @FindBy(how=How.XPATH, using=HomeScreen.selectCurrency_XPATH) public
	 * WebElement Selectcurrency;
	 * 
	 * @FindBy(how=How.XPATH, using=HomeScreen.selectCurrencyType_XPATH) public
	 * WebElement SelectCurrencyType;
	 * 
	 * @FindBy(how = How.XPATH, using=HomeScreen.CurrencyList_XPATH) public
	 * List<WebElement> currencyList;
	 * 
	 * @FindBy(how=How.XPATH, using=HomeScreen.oneWayTrip_XPATH) public WebElement
	 * oneWayButton;
	 * 
	 * @FindBy(how=How.XPATH, using= HomeScreen.returnDateCalender_XPATH) WebElement
	 * returnDatePicker;
	 * 
	 * @FindBy(how=How.XPATH, using="fromcitylist_XPATH") public List<WebElement>
	 * selectFromCity;
	 * 
	 * @FindBy(how=How.XPATH, using=HomeScreen.toCityList_XPATH) public
	 * List<WebElement> toCity_List;
	 * 
	 * @FindBy(how=How.XPATH, using =HomeScreen.fromCity) WebElement fromcity;
	 * 
	 * @FindBy(how=How.XPATH, using =HomeScreen.toCity) WebElement tocity;
	 * 
	 * @FindBy(how=How.XPATH, using =HomeScreen.startDate) WebElement
	 * startdateCalender;
	 * 
	 * @FindBy(how=How.XPATH, using =HomeScreen.Adultcount_XPATH) WebElement
	 * adultCount;
	 * 
	 * @FindBy(how=How.XPATH, using=HomeScreen.searchButton_XPATH) WebElement
	 * searchButton;
	 * 
	 * public void SelectCurrencyType(String currency_Text) { try {
	 * //@FindBy(how=How.XPATH, using=) public WebElement currencyClick;
	 * //span[contains(text(),'Australian Dollar')]
	 * driver.findElement(By.xpath(HomeScreen.selectCurrencyType_XPATH+"'"+
	 * currency_Text+"')]")).click(); } catch(Exception e) { e.printStackTrace(); }
	 * }
	 * 
	 * public void SelectCurrency() { try { Selectcurrency.click(); }
	 * catch(Exception e) { e.printStackTrace(); } }
	 * 
	 * public List<String> currencyList() {
	 * System.out.println("Currency List Size is : "+ currencyList.size());
	 * List<String> list=new ArrayList<String>();
	 * 
	 * try {
	 * 
	 * for(int i=1;i<=currencyList.size();i++) {
	 * list.add(driver.findElement(By.xpath(HomeScreen.CurrencyList_XPATH+"["+i+"]"+
	 * "//span[2]")).getText());
	 * 
	 * } return list; } catch(Exception e) {e.printStackTrace(); return list; } }
	 * 
	 * public void selectOneWayTrip()
	 * 
	 * { try { if(TestUtil.isElementDisplayed(oneWayButton, 20)) {
	 * if(!oneWayButton.isSelected()) { oneWayButton.click(); } else {
	 * System.out.println("oneWayButton is already selected"); } } } catch(Exception
	 * e) {e.printStackTrace();} }
	 * 
	 * public boolean returnDatePicker_isDisplayed() {
	 * if(TestUtil.isElementDisplayed(returnDatePicker, 10)) {
	 * System.out.println("Element is Displayed"); return true; } else return
	 * false;}
	 * 
	 * public void selectFromCityFromList(String citycode) { try {
	 * fromcity.sendKeys(citycode); System.out.println(selectFromCity.size());
	 * Thread.sleep(5000); for(int i=1;i<=10;i++)
	 * if(driver.findElement(By.xpath(HomeScreen.fromcitylist_XPATH+"["+i+"]/a")).
	 * getText().contains(citycode)) {
	 * driver.findElement(By.xpath(HomeScreen.fromcitylist_XPATH+"["+i+"]/a")).click
	 * (); System.out.println("City found in the list"); }
	 * 
	 * } catch(Exception e) {e.printStackTrace();} }
	 * 
	 * public void selectStartDate(String Date) { startdateCalender.click();
	 * List<WebElement> date=driver.findElements(By.
	 * xpath("//div[contains(@class,'monthBlock first')]//table//tbody//tr//td"));
	 * for(WebElement ele:date) { String day=ele.getText(); if(!(day=="")) {
	 * if(day.equalsIgnoreCase(Date)) { ele.click(); } }
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void selectToCityFromList(String citycode) { try {
	 * tocity.sendKeys(citycode);
	 * 
	 * Thread.sleep(10000); for(int i=1;i<=toCity_List.size();i++)
	 * if(driver.findElement(By.xpath(HomeScreen.toCityList_XPATH+"["+i+"]/a")).
	 * getText().contains(citycode)) {
	 * driver.findElement(By.xpath(HomeScreen.toCityList_XPATH+"["+i+"]/a")).click()
	 * ; System.out.println("City found in the list"); }
	 * 
	 * } catch(Exception e) {e.printStackTrace();} }
	 * 
	 * public void selectAdultCount() { Select select=new Select(adultCount);
	 * select.selectByIndex(3); }
	 * 
	 * public void searchButtonClick() { searchButton.click(); }
	 */
}