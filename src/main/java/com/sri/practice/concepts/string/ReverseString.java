package com.sri.practice.concepts.string;

public class ReverseString {
	
	public static void main(String[] args) {
		String s="madam";
		StringBuilder s1=new StringBuilder(s).reverse();
		if(s.equals(s1.toString())) {
			System.out.println("Palindrone");
		}else {
			System.out.println("Not palindrone");
		}
	}

}
