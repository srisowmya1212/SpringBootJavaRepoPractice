package com.sri.practice.concepts.comparator;

import java.util.*;

public class EmployeeHighestSalary {
	
	public static void main(String[] args) {
		List<Employee> employee=Arrays.asList(
				new Employee("Sai",(double) 4000), //to accept this create a constructor in employee class
				new Employee("Arun",(double)8000),
				new Employee("Vani",(double)7000),
				new Employee("Satyam",(double)10000)
				);
		/**here sorted(Comparator.reverseOrder()) not applicable bcoz having List of list of object like 
		 * List of employee in employee onject need to sort with salary so use comparing**/
		
		List<Employee> result=employee.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).limit(2).toList();
		System.out.println(result); //print as list
		result.forEach(System.out::println); //looping 
		
		
		
		/**
		 * com.sri.practice.concepts.comparator.Employee@71e7a66b
           com.sri.practice.concepts.comparator.Employee@2ac1fdc4 
           got above output bcoz i am not using toString() in employee class. So write toString() ovveride method**/
           
		
	}

}
