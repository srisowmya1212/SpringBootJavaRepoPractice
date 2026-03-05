package com.sri.practice.concepts.streams;

import java.util.*;
import java.util.stream.*;

public class StreamsAllMethods {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 3);
        List<String> names = Arrays.asList("Sri", "Ram", "Sowmya", "Java");
        
        //anyMatch returns boolean prefer filer to use next methods in stream

        // 1. filter()
        System.out.println("filter(): " +
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList()));

        // 2. map()
        System.out.println("map(): " +
                numbers.stream()
                        .map(n -> n * 2)
                        .collect(Collectors.toList()));

        // 3. flatMap()
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        System.out.println("flatMap(): " +
                nested.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList()));

        // 4. distinct()
        System.out.println("distinct(): " +
                numbers.stream()
                        .distinct()
                        .collect(Collectors.toList()));

        // 5. sorted()
        System.out.println("sorted(): " +
                numbers.stream()
                        .sorted()
                        .collect(Collectors.toList()));

        // 6. sorted reverse
        System.out.println("sorted reverse(): " +
                numbers.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()));

        // 7. limit()
        System.out.println("limit(): " +
                numbers.stream()
                        .limit(3)
                        .collect(Collectors.toList()));

        // 8. skip()
        System.out.println("skip(): " +
                numbers.stream()
                        .skip(2)
                        .collect(Collectors.toList()));

        // 9. peek()
        System.out.println("peek(): ");
        numbers.stream()
                .peek(n -> System.out.println("Processing: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // 10. collect()
        Set<Integer> set = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("collect to Set(): " + set);

        // 11. groupingBy()
        System.out.println("groupingBy(): " +
                numbers.stream()
                        .collect(Collectors.groupingBy(n -> n % 2)));

        // 12. partitioningBy()
        System.out.println("partitioningBy(): " +
                numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        // 13. joining()
        System.out.println("joining(): " +
                names.stream()
                        .collect(Collectors.joining(",")));

        // 14. summarizingInt()
        System.out.println("summarizingInt(): " +
                numbers.stream()
                        .collect(Collectors.summarizingInt(Integer::intValue)));

        // 15. findFirst()
        System.out.println("findFirst(): " +
                numbers.stream().findFirst().get());

        // 16. findAny()
        System.out.println("findAny(): " +
                numbers.stream().findAny().get());

        // 17. anyMatch()
        System.out.println("anyMatch(): " +
                numbers.stream().anyMatch(n -> n > 5));
        
        System.out.println("anyMatch(): " +
                numbers.stream().anyMatch(n -> n > 5));

        // 18. allMatch()
        System.out.println("allMatch(): " +
                numbers.stream().allMatch(n -> n > 0));

        // 19. noneMatch()
        System.out.println("noneMatch(): " +
                numbers.stream().noneMatch(n -> n < 0));

        // 20. count()
        System.out.println("count(): " +
                numbers.stream().count());

        // 21. reduce()
        System.out.println("reduce(): " +
                numbers.stream().reduce(0, Integer::sum));

        // 22. min()
        System.out.println("min(): " +
                numbers.stream().min(Integer::compareTo).get());

        // 23. max()
        System.out.println("max(): " +
                numbers.stream().max(Integer::compareTo).get());

        // 24. mapToInt()
        System.out.println("mapToInt sum(): " +
                numbers.stream().mapToInt(Integer::intValue).sum());

        // 25. mapToDouble()
        System.out.println("mapToDouble avg(): " +
                numbers.stream().mapToDouble(Integer::doubleValue).average().getAsDouble());

        // 26. mapToLong()
        System.out.println("mapToLong sum(): " +
                numbers.stream().mapToLong(Integer::longValue).sum());

        // 27. forEach()
        System.out.println("forEach(): ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 28. forEachOrdered() with parallel
        System.out.println("forEachOrdered(): ");
        numbers.parallelStream()
                .forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();

        // 29. parallelStream()
        System.out.println("parallelStream(): ");
        numbers.parallelStream()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 30. sequential()
        System.out.println("sequential(): ");
        numbers.parallelStream()
                .sequential()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        
     // anyMatch example
        List<Integer> greaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());

        System.out.println("Elements > 5: " + greaterThanFive);
        System.out.println("anyMatch (>5): " +
                numbers.stream().anyMatch(n -> n > 5));

        // allMatch example
        List<Integer> greaterThanZero = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());

        System.out.println("Elements > 0: " + greaterThanZero);
        System.out.println("allMatch (>0): " +
                numbers.stream().allMatch(n -> n > 0));
        
       /** mapToObj() is used to:

        	Convert a primitive stream (IntStream, LongStream, DoubleStream)
        	➜ into an Object Stream

        	Because primitive streams (IntStream, etc.) don’t contain objects. **/
        
        List<Long> ids = Arrays.asList(1L, 2L, 3L);

        List<String> idStrings = ids.stream()
                .mapToLong(Long::longValue)
                .mapToObj(id -> "ID-" + id)
                .collect(Collectors.toList());

        System.out.println(idStrings);
        
        List<String> result = IntStream.range(1, 6)   // 1 to 5
                .mapToObj(n -> "Number: " + n)
                .collect(Collectors.toList());

        System.out.println("mapToObj(): " + result);
        
        
    }
}


