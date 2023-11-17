package com.testrunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunnerJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Result result = JUnitCore.runClasses(LoginTestSuite.class);
		System.out.println("Test suite runner. Total number of tests " + result.getRunCount());
		System.out.println("Test suite runner. Total number of tests failed " + result.getFailureCount());
		
		for(Failure failure: result.getFailures()) {
			
			System.out.println("This is the failure message of: " + failure.getTestHeader() + ". Failure mesage: " + failure.getMessage());
		}


	}

}
