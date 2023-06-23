package com.abc.reactiveexample.programs;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class TestRun1 {

    public static int removeDuplicatesFromArray(int[] array){

        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(array).forEach(set::add);
        System.out.println(set);// final Result 1

        int[] arr= Arrays.stream(array).distinct().sorted().toArray();
        System.out.println(Arrays.toString(arr)); //final Result 2

        


        return  0;
    }

    public static void main(String[] args) {
        int[] array= new int[]{20,11,5,3,10,20,10,20,30,30};
        removeDuplicatesFromArray(array);
    }
}
