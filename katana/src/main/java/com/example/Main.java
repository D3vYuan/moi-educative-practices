package com.example;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // String test = "test";
        // for (int i = 0; i < test.length(); i ++){
        //     int charIndex = test.charAt(i) - 'a';
        //     System.out.println(String.format("%s @[%d]", test.charAt(i), charIndex));
        // }

        // PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a); // ascending
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a); // descending
        queue.add(1);
        queue.add(10);
        queue.add(7);
        queue.add(8);
        while (!queue.isEmpty()){
            Integer value = queue.poll();
            System.out.println("value: "+ value);
        }
    }
}