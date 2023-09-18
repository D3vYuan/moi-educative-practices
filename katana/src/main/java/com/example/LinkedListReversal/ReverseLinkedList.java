package com.example.LinkedListReversal;

public class ReverseLinkedList {
    /**
     * Given the head of a singly linked list, reverse the linked list and return its updated head.
     * 
     * Strategy
     * [1] Initialize the prev and next pointers to NULL and set the current pointer to the head node.
     * [2] Traverse the linked list until the current pointer reaches the end of the list.
     * [3] Within the loop, set the next pointer to the next node in the list and reverse the current node’s pointer to point to the previous node.
     * [4] Update the prev and curr pointers.
     * [5] After the loop, the prev pointer will point to the last node of the original linked list, so set the head pointer to the prev pointer.
     */

     public ReverseLinkedList(){

     }
}
