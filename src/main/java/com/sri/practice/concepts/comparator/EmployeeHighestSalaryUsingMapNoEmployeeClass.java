package com.sri.practice.concepts.comparator;

import java.util.*;
import java.util.stream.*;

public class EmployeeHighestSalaryUsingMapNoEmployeeClass {
	
	
	public static void main(String[] args) {
		
		//ASCII
		int c='a';
		System.out.println(c);
		
		Map<String,Double> map1=new HashMap<>();
		/**
		 * entrySet(),keySet(),values(),containsKey(),containsValue(),equals(Object o)
		 * get(Object key),replace(String key, Double oldValue, Double Newvalue),remove(Object Key),remove(Object key,Object value)
		 * 
		 * Map.Entry.comparingByKey(),comparingByValue()**/
		map1.put("Sri",20000.00);
		map1.put("Sai", 20000.02);
		map1.put("Vani", 30000.00);
		map1.put("Satyam", 1000.00);
		
		map1.entrySet()
				   .stream()
				   .sorted(Map.Entry.comparingByValue())
				   .forEach(System.out::println);
		System.out.println("-----------------------------------------");
		map1.entrySet()
		   .stream()
		   .sorted(Map.Entry.comparingByKey())
		   .forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		
		
		Map<String,Double> result=map1.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed()) //if u use reversed() need to use <String,Double> type specification
				.limit(2)
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
		
		System.out.println("Top two results using map using limit and reversed "+result);
		System.out.println("-----------------------------------------");
			
		int length=map1.size();
		Map<String,Double> result1=map1.entrySet().stream().sorted(Map.Entry.comparingByValue()) //i didn't reversed
				.skip(length-2)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("Top two results using map skip and not reversed "+result1);
		
		System.out.println("-----------------------------------------");
		
		List<Object> list=List.of("MAni",1,2,"Sri","a",8,"Mani","Hello",'m');
		List<Object> resultedList=new ArrayList<>();
		List<Object> resultedList1=new ArrayList<>();
		for(Object i:list) {
			if(i instanceof String) {
				String t=((String) i).toLowerCase();
				if(!t.equals("mani")) {
					resultedList.add(i.toString().toLowerCase());
				}
			}else if(i instanceof Object) {
				resultedList.add(i);
			}
			
		}
		System.out.println(resultedList);
	
			
		resultedList1=list.stream().filter(n->!"mani".equalsIgnoreCase(n.toString())).map(e->{
			Object ttt = e.toString().toLowerCase();
			return ttt;
		}).toList();
				
		
		System.out.println("Using streams "+resultedList1);
		System.out.println("-----------------------------------------");
		
		
		
	
	
	
	
	
	}
	
	
	/**
	 * 
	 * map.keySet().stream() → stream keys
       map.values().stream() → stream values
       map.entrySet().stream() → stream key + value
       
       
       **/

}
