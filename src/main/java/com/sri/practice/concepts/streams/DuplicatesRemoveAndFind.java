package com.sri.practice.concepts.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.*;

public class DuplicatesRemoveAndFind {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
//		list1.addAll(1,2,3,4,5,6);//The method addAll(int, Collection<? extends Integer>) in the type List<Integer> is not applicable for the arguments (int, int, int, int, int, int)
		// Arrays.sort,equals,binarySearch,compare,spliterator,stream,toString
		List<Integer> list2 = Arrays.asList(1, 23, 1, 2, 3, 7, 3, 56);
		list1.addAll(list2);
		/**
		 * add(integer) and addAll(only list),add index,intger saand also addFirst and
		 * addLast list. contains,containsAll(list),removeFirst,removeLast,removeIf(condition),removeAll(list),remove(intger)
		 * ,get(int index),set(int index,integer),getFirst(),getLst() toArray(),toString()
		 * reversed(),indexOf(),lastIndexOf(),iterator(),listIterator(),subList(from index, to index)
		 **/
		list1.add(26);
		list1.addFirst(100);
		list1.addLast(200);
		list1.add(3, 60);
		System.out.println("List1 " + list1);
		// we can use List.of(1,2,3,4,5);
		List<Integer> list3 = List.copyOf(list1);
		System.out.println(list1 == list3); // false as its not static refernece
		System.out.println(list1.equals(list3)); // true as its non primitive comparing
		System.out.println("List3 " + list3);
		System.out.println(list3.containsAll(list1)); // true
		list1.addAll(1, list3);
		System.out.println("Added index at 1 of list3 to list1 so final list " + list1);
		System.out.println("SubList of list1 "+list1.subList(2, 6));
		System.out.println("Iterator of list1 "+list1.iterator());
		System.out.println("Index of of list1 "+list1.indexOf(100)); //0 index number got if i give value
		System.out.println("reversing list "+list1.reversed());
		Set<Integer> generalRepresentation = new HashSet<Integer>();
//		Set<Integer> set1=new HashSet<>(list1); //U CAN USE THIS
//		Set<Integer> set1=new HashSet(list1); //u cAN USE THIS
		Set<Integer> set1 = new HashSet<Integer>(list1);
//		Set<Integer> set1=new HashSet<list1>;//wrong
		System.out.println("Using HashMap set result not sorted ,not ordered used lsit1 " + set1);
		//Collections. reverse(),reverseOrder(Comparator) ,min(),max(),indexOfSubList(List<Intgere>,List<Integer>), binarySearch()
		System.out.println("Min value of list1 using collections "+Collections.min(list1));
//		System.out.println("reverse value of list1 using collections "+Collections.reverse(list1)); //The operator + is undefined for the argument type(s) String, void
		Collections.reverse(list1);
		System.out.println("Reversed list of list1 "+list1);
//		Collections.reverseOrder(list1);
		Collections.sort(list1, Collections.reverseOrder()); 
		list1.sort(Collections.reverseOrder());
		//Comparator reverseOrder,comparing
		list1.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("Reverse Order of list1 "+list1);
		set1.stream().sorted().toList(); //wrong but executed
		System.out.println("Sorted set1 using streams wrong somewhat but executed "+set1);
		Set<Integer> set2 = new TreeSet<Integer>(list1);
		System.out.println("Sorted list directly by using treeset "+set2);
		List<Integer> list4= List.of(2,5,3,2,4,8,1,7,9,10);
		List<Integer> result=list4.stream().distinct().sorted().toList();
		/**allMatch(),anyMatch(),collect(),filter(),findAny(),findFirst(),mapToObj(),mapToDouble()
		 * mapToInt(),equals() ,limit(),skip(),sequential(),flatMap(),forEach(),mapToDouble()**/
		System.out.println("Sorted and removed duplicates list using streams "+result);
		List<Integer> list5=new ArrayList<Integer>(Arrays.asList(10,10,20,5,1,7,7,2,5,9));
		Set<Integer> duplicates=new TreeSet<Integer>();
		Set<Integer> resultedSet=new TreeSet<Integer>();
		/**
		 * Set.add(value) returns:

            ✅ true → if element is added successfully (not already present)

           ❌ false → if element is already present (duplicate)*/
//		for(Integer a:list5) {
//			if(!resultedSet.add(a)) {
//				duplicates.add(a);
//			}
//		}
		
		//we can use both above and down
		
		for (Integer a : list5) {
		    if (resultedSet.contains(a)) {
		        duplicates.add(a);  
		    } else {
		        resultedSet.add(a);  
		    }
		}
		System.out.println("Duplicates list in list1 "+duplicates);
		System.out.println("Resulted set after removeing duplicates and ordered using TreeSet "+resultedSet);
		
		
		
	}

}


/*
 * List1 [100, 1, 23, 60, 1, 2, 3, 7, 3, 56, 26, 200]
false
true
List3 [100, 1, 23, 60, 1, 2, 3, 7, 3, 56, 26, 200]
true
Added index at 1 of list3 to list1 so final list [100, 100, 1, 23, 60, 1, 2, 3, 7, 3, 56, 26, 200, 1, 23, 60, 1, 2, 3, 7, 3, 56, 26, 200]
SubList of list1 [1, 23, 60, 1]
Iterator of list1 java.util.ArrayList$Itr@2a3046da
Index of of list1 0
reversing list [200, 26, 56, 3, 7, 3, 2, 1, 60, 23, 1, 200, 26, 56, 3, 7, 3, 2, 1, 60, 23, 1, 100, 100]
Using HashMap set result not sorted ,not ordered used lsit1 [1, 2, 3, 100, 7, 200, 23, 56, 26, 60]
Min value of list1 using collections 1
Reversed list of list1 [200, 26, 56, 3, 7, 3, 2, 1, 60, 23, 1, 200, 26, 56, 3, 7, 3, 2, 1, 60, 23, 1, 100, 100]
Reverse Order of list1 [200, 200, 100, 100, 60, 60, 56, 56, 26, 26, 23, 23, 7, 7, 3, 3, 3, 3, 2, 2, 1, 1, 1, 1]
Sorted set1 using streams wrong somewhat but executed [1, 2, 3, 100, 7, 200, 23, 56, 26, 60]
Sorted list directly by using treeset [1, 2, 3, 7, 23, 26, 56, 60, 100, 200]
Sorted and removed duplicates list using streams [1, 2, 3, 4, 5, 7, 8, 9, 10]
Duplicates list in list1 [5, 7, 10]
Resulted set after removeing duplicates and ordered using TreeSet [1, 2, 5, 7, 9, 10, 20]*/
