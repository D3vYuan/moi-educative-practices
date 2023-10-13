package com.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Educative {

    private static void runPriorityQueue(boolean ascending) {
        PriorityQueue<Integer> queue;
        if (ascending) {
            queue = new PriorityQueue<>((a, b) -> a - b); // ascending
        } else {
            queue = new PriorityQueue<>((a, b) -> b - a); // descending
        }

        queue.add(1);
        queue.add(10);
        queue.add(7);
        queue.add(8);

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            System.out.println("value: " + value);
        }
        System.out.println("-- queue --");
    }

    private static void runStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("-- stack --");
    }

    private static void runDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
        System.out.println("-- deque --");
    }

    private static void runLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // System.out.println(list.getFirst());
        // System.out.println(list.getLast());

        // System.out.println(list.peekFirst());
        // System.out.println(list.peekLast());

        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());

        while (!list.isEmpty()) {
            System.out.println(list.poll());
        }
        System.out.println("-- linked list --");
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        runPriorityQueue(true);
        runPriorityQueue(false);
        runStack();
        runDeque();
        runLinkedList();
    }
}