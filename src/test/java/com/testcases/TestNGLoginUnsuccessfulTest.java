package com.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGLoginUnsuccessfulTest {
  @Test(dataProvider = "dp")
  public void testloginunsuccessful(Integer n, String s) {
	  System.out.println("This is test case of Unsuccessful login TestNG...");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test2 Before Method...");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Test2 After Method...");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Test2 Before Class method...");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Test2 After Class method...");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test2 Before Test method...");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test2 After Test method...");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Test2 Before Suite method...");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Test2 After Suite method...");
  }

}
