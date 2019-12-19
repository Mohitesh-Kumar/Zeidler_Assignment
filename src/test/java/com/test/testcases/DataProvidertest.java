package com.test.testcases;

import java.util.*;

import org.testng.annotations.*;

import com.test.utils.TestUtil;

public class DataProvidertest {

	
	@Test(dataProvider = "getdata")
	public void testcase1(String Firstname, String Lastname, String rollno, String Department)
	{
		System.out.println("Data provider Firstname : "+ Firstname);
		System.out.println("Data provider Lastname : "+ Lastname);
		System.out.println("Data provider rollno : "+ rollno);
		System.out.println("Data provider Department : "+ Department);
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getdata()
	{
		ArrayList<Object[]> testdata=TestUtil.getdatafromexcel();
		return testdata.iterator();
		
	}
	
	
}
