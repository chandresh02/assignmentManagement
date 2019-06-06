package com.xworkz.project.util;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGenerator {

	String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	String numbers = "0123456789";
	String symbols = "!@#$%^&*_=+-/.?<>)";
	
	
	public String randomPasswordGeneration()
	{
		String capitalLetters=RandomStringUtils.random(2,Capital_chars);
		String smallLetters=RandomStringUtils.random(2,Small_chars);
		String number1=RandomStringUtils.random(2,numbers);
		String specialSymbols=RandomStringUtils.random(2,symbols);
		
		String randomPassword=capitalLetters+smallLetters+number1+specialSymbols;
		return randomPassword;
	}

}
