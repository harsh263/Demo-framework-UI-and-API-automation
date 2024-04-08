package com.testrunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.testcases.TestLoginSuccess;
public class TestStandardRunnerJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Result result = JUnitCore.runClasses(TestLoginSuccess.class);
		System.out.println("Total number of tests " + result.getRunCount());
		System.out.println("Total number of tests failed " + result.getFailureCount());
		
		for(Failure failure: result.getFailures()) {
			
			System.out.println("This is the failure message of: " + failure.getTestHeader() + ". Failure mesage: " + failure.getMessage());
		}

	}

}
