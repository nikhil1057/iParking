package com.employee.server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	int f=1;
	Pattern regexPattern;
	Matcher regMatcher;
	Validations()
	{
		
	}
	public int validateEmailAddress(String i2) {
		// TODO Auto-generated method stub
		regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
		
		regMatcher = regexPattern.matcher(i2);
		System.out.println("aaa");
		
		if(regMatcher.matches())
		{return 0;}
		else {return 1;}
			
		}
	
		

	public int validateMobileNumber(String i3) {
		// TODO Auto-generated method stub
	regexPattern = Pattern.compile("^[0-9]{10}$");
		
		regMatcher = regexPattern.matcher(i3);
		System.out.println("kkk");
		
		if(regMatcher.matches())
			return 0;
		else
			return 1;
			
	
		
	}
	public int validatePassword(String s4, String s5) {
		// TODO Auto-generated method stub
		System.out.println("lll");
		
		if(s4.equals(s5))
		 return 0;
		else 
			return 1;
		
	}
}
