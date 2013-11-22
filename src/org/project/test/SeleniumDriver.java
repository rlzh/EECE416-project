package org.project.test;


public class SeleniumDriver {
	
	public static void main(String[] args) {
		
		// Initialize all test
		BaseTest signIn = new SignIn();
		
		// Test SignIn feature
		if (signIn.testPassed()) System.out.println("SignIn Test passed!");
		
    }
}
