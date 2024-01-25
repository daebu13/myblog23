package com.myblog.myblog22;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,5,5,4,6,4,36,33,55,33,6,6,88,2);
        List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
    }
}
