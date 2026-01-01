package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

    public static void main(String[] args) {
//        countFrequency("Divyansh");
//        getMaxSalaryEmployee();
//        mergeTwoListsWithSortedAndDistinct();
//        firstNonRepeatingCharacter();
//        sumOfSalariesGreaterThanThreshold();
//        groupStringsByLength();
//        partitionNumbersByEvenOdd();
//        maxNumberInList();
//        countFrequencyInAString();
//        sortListByLength();
//        duplicateInAList();
//        convertStringListAndJoinWithComma();
//        flattenList();
//        summaryStatisticsOfNumbers();
//        sortListOfEmployeesBySalaryDescAndThenByName();
//        listOfEmployeesToMap();
//        partitionListIntoEvenOdd();
//        findSecondHighestNumber();
//        sortStringCaseInsensitive();
//        sumOfAllSalaries();
//        highestSalaryEmployee();
//        averageSalaryEmployee();
//        countEmployeeWithMoreThan1LakhPerDepartment();
//        getDistinctDepartments();
//        sortEmployeesByDepartmentThenBySalaryDescending();
        partitionEmployeesBySalary();
    }


    public static void countFrequency(String request) {
        String req = "hello world";
        Map<Character, Long> collect = req.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }

    public static void findDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 5, 7, 8);
        List<Integer> list = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
    }

    public static void getMaxSalaryEmployee() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ravi", "IT", 120000),
                new Employee(3, "Ananya", "HR", 90000),
                new Employee(4, "Kiran", "HR", 60000)
        );

        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect);
    }

    public static void mergeTwoListsWithSortedAndDistinct() {

        List<String> list1 = Arrays.asList("Java", "Python", "C++");
        List<String> list2 = Arrays.asList("C++", "Go", "Rust");

        List<String> list = Stream.concat(list1.stream(), list2.stream()).distinct().sorted().toList();
        System.out.println(list);
    }

    public static void firstNonRepeatingCharacter() {
        String req = "swiss";
        Character c1 = req.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse('s');
        System.out.println(c1);
    }

    public static void sumOfSalariesGreaterThanThreshold() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ravi", "IT", 120000),
                new Employee(3, "Ananya", "HR", 40000),
                new Employee(4, "Kiran", "HR", 30000)
        );

        double sum = employees.stream().filter(employee -> employee.getSalary() > 50000).mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);
    }

    public static void groupStringsByLength() {
        List<String> words = Arrays.asList("Java", "Python", "Go", "Rust", "Ruby", "Kotlin", "C");
        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(collect);
    }

    public static void partitionNumbersByEvenOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect);
    }

    public static void maxNumberInList() {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 3, 15, 8);
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println(max.get());
    }

    public static void countFrequencyInAString() {
        String input = "banana";
        Map<Character, List<Character>> collect = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity()));
        System.out.println(collect);
    }

    public static void sortListByLength() {
        List<String> words = Arrays.asList("Java", "Go", "Rust", "Python", "C");
        List<String> list = words.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(list);
    }

    public static void duplicateInAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 5, 7);
        List<Integer> list = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 2).map(entry -> entry.getKey())
                .toList();
        System.out.println(list);
    }

    public static void convertStringListAndJoinWithComma() {
        List<String> words = Arrays.asList("java", "python", "go");
        String collect = words.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    public static void flattenList() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Java", "Python"),
                Arrays.asList("Go", "Rust"),
                Arrays.asList("Kotlin")
        );

        List<String> collect = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void summaryStatisticsOfNumbers() {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 3, 15, 8);
//        Optional<Integer> reduceToSum = numbers.stream().reduce((a, b) -> a + b);
//        numbers.stream().collect(Collectors.averagingInt())
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(intSummaryStatistics.getSum());
    }

    public static void sortListOfEmployeesBySalaryDescAndThenByName() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh","HR", 85000),
                new Employee(2, "Ananya", "HR",120000),
                new Employee(3, "Ravi", "HR",120000),
                new Employee(4, "Kiran", "HR",30000)
        );
        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Comparator.comparing(Employee::getName))).toList();
        System.out.println(list);

    }

    public static void listOfEmployeesToMap() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh","HR", 85000),
                new Employee(2, "Ananya", "HR",120000),
                new Employee(3, "Ravi", "HR",120000),
                new Employee(4, "Kiran", "HR",30000)
        );
        Map<Integer, String> collect = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(collect);
    }

    public static void partitionListIntoEvenOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println(collect);
    }

    public static void findSecondHighestNumber() {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 3, 15, 8, 20);
        Optional<Integer> first = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(first.get());
    }

    public static void sortStringCaseInsensitive() {
        List<String> strings = Arrays.asList("java", "Go", "Python", "c");
        List<String> list = strings.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();
        System.out.println(list);
    }

    public static void sumOfAllSalaries() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000)
        );

        Double reduce = employees.stream().map(Employee::getSalary).reduce((double) 0, (a, b) -> a + b);
        double sum = employees.stream().mapToDouble(Employee::getSalary).sum();
        Double collect = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(reduce);
    }

    public static void highestSalaryEmployee() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000)
        );
        Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max.get());

    }

    public static void averageSalaryEmployee() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000)
        );
        Double collect = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);
    }

    public static void countEmployeeWithMoreThan1LakhPerDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000),
                new Employee(5, "Manav", "Finance", 65000),
                new Employee(6, "Shreya", "Finance", 110000),
                new Employee(7, "Sanya", "IT", 125000)
        );
        Map<String, Long> collect = employees.stream().filter(employee -> employee.getSalary() > 100000).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect);
    }

    public static void getDistinctDepartments() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000),
                new Employee(5, "Manav", "Finance", 65000)
        );

        List<String> list = employees.stream().map(Employee::getDepartment).distinct().toList();
        System.out.println(list);
    }

    //todo IMPORTANT
    public static void sortEmployeesByDepartmentThenBySalaryDescending() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "iT", 85000),
                new Employee(2, "Ananya", "finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000),
                new Employee(5, "Manav", "Finance", 65000),
                new Employee(6, "Sanya", "IT", 125000)
        );

        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getDepartment, String.CASE_INSENSITIVE_ORDER).thenComparing(Employee::getSalary, Comparator.reverseOrder())).toList();
        System.out.println(list);
    }

    public static void partitionEmployeesBySalary() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Divyansh", "IT", 85000),
                new Employee(2, "Ananya", "Finance", 120000),
                new Employee(3, "Ravi", "IT", 95000),
                new Employee(4, "Kiran", "HR", 30000),
                new Employee(5, "Manav", "Finance", 65000),
                new Employee(6, "Sanya", "IT", 125000)
        );

        Map<Boolean, List<String>> collect = employees.stream().
                collect(Collectors.partitioningBy(emp -> emp.getSalary() > 100000, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect);
    }

}
