package com.xworkz.project.util;

import org.springframework.stereotype.Controller;

@Controller
public class DataValidation {
	@SuppressWarnings("unused")
	public boolean isValidFname(String fName) {
		if (!fName.isEmpty() || fName != null || (fName.length() >= 4 && fName.length() <= 50)) {
			System.out.println("First Name is Valid");
			return true;
		} else {
			System.out.println("First Name is Invalid");
			return false;
		}

	}

	@SuppressWarnings("unused")
	public boolean isValidLname(String lName) {
		if (!lName.isEmpty() || lName != null || (lName.length() >= 4 && lName.length() <= 50)) {
			System.out.println("Last Name is Valid");
			return true;
		} else {
			System.out.println("Last Name is Invalid");
			return false;
		}

	}

	@SuppressWarnings("unused")
	public boolean isValidEmail(String email) {
		if (!email.isEmpty() || email != null) {
			System.out.println("Email is Valid");
			return true;
		} else {
			System.out.println("Email is Invalid");
			return false;
		}
	}

	public boolean isValidMobileNo(long mobNo) {

		if (mobNo != 0 || (mobNo >= 1 && mobNo <= 10)) {  
			System.out.println("Contact No is Valid");
			return true;
		} else {
			System.out.println("Contact No is Invalid");
			return false;
		}
	}

	public boolean isValidCountryCode(int countryCode) {

		if (countryCode != 0 || countryCode >= 2 && countryCode <= 10) {
			System.out.println("Password is Valid");
			return true;
		} else {
			System.out.println("Password is Invalid");
			return false;
		}
	}

}
