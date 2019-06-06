package com.xworkz.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class SignUpEntity implements Serializable {
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "COUNTRY_CODE")
	private int countryCode;
	@Column(name = "MOBILE_NO")
	private long mobileNo;
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "NEW_USER")
	private boolean newUser;
	@Column(name = "PASSWORD")
	private String password;

	public SignUpEntity() {
		System.out.println(this.getClass().getSimpleName() + " object created");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpEntity [firstName=" + firstName + ", lastName=" + lastName + ", countryCode=" + countryCode
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", newUser=" + newUser + ", password=" + password
				+ "]";
	}

}
