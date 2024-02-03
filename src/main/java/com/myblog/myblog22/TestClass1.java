package com.myblog.myblog22;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
//        List<Integer> result = Arrays.asList(10,2,3,44,3,2,3,6,20,30,3,2,6,7,9);
//        List<Integer> collect = result.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(collect);


//        List<Integer> collect = result.stream().sorted().collect(Collectors.toList());
//        System.out.println(collect);

//        List<String> result= Arrays.asList("adam","mike","stalllin");
//        List<String> names = result.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
//        List<String> name1 = result.stream().filter(s -> s.equals("mike")).collect(Collectors.toList());
//        List<Integer> mapps = result.stream().map(i -> i + 10).collect(Collectors.toList());
//        List<Integer> different = result.stream().distinct().collect(Collectors.toList());
//        System.out.println(names);
//        System.out.println(name1);
//        System.out.println(mapps);
//        System.out.println(different);


        // predicate<> functional interface
//
//        Predicate<Integer> pre = s -> s % 2 == 0;
//        boolean evenNumbers = pre.test(10);
//        System.out.println(evenNumbers);
//
//        // second example
//
//        Predicate<String> st = s -> s.equals("mike");
//        boolean name = st.test("mi");
//        System.out.println(name);
//
//        // Function<> functional interface
//
//        Function<String, Integer> name3 = n -> n.length();
//        Integer nameeeee = name3.apply("miaekrlakra");
//        System.out.println(nameeeee);


//        List<Employee> logins = Arrays.asList(new Employee("mike", "testing"),
//                new Employee("stallin", "testing"),
//                new Employee("bob", "testing"));
//
//        List<LoginDto> dtos = logins.stream().map(loginss -> mapToDto(loginss)).collect(Collectors.toList());
//        System.out.println(dtos);
//
//
//    }
//
//    static LoginDto mapToDto(Employee login) {
//        LoginDto dto = new LoginDto();
//        dto.setUserName(login.getUserName());
//        dto.setPassword(login.getPassword());
//        return dto;


        List<Employee> employees = Arrays.asList(new Employee("mike","chennai",32),
                new Employee("stallin", "chennai",31),
                new Employee("faisal","bangalore",24),
                new Employee("sam","pune",28));
//
////        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
////       for (Employee e :emps){
////           System.out.println(e.getName());
////           System.out.println(e.getCity());
////           System.out.println(e.getAge());
////       }
//
//       List<Employee> employees1 = employees.stream().filter(emp1-> emp1.getName().startsWith("m")).collect(Collectors.toList());
//       for (Employee e : employees1){
//           System.out.println(e.getName());
//           System.out.println(e.getCity());
//       }

//
        Map<String, List<Employee>> groupByCity = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        System.out.println(groupByCity);


//        List<Integer> num = Arrays.asList(1,3,2,5,7,8,9,10);
//        List<Integer> square = num.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
//        System.out.println(square);

    }



}
