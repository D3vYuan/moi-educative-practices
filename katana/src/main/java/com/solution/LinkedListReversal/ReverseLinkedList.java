package com.solution.LinkedListReversal;

import com.solution.Utility.LinkedListNode;

public class ReverseLinkedList {
    /**
     * Given the head of a singly linked list, reverse the linked list and return
     * its updated head.
     * 
     * Strategy
     * [1] Initialize the prev and next pointers to NULL and set the current pointer
     * to the head node.
     * [2] Traverse the linked list until the current pointer reaches the end of the
     * list.
     * [3] Within the loop, set the next pointer to the next node in the list and
     * reverse the current node’s pointer to point to the previous node.
     * [4] Update the prev and curr pointers.
     * [5] After the loop, the prev pointer will point to the last node of the
     * original linked list, so set the head pointer to the prev pointer.
     */

    public ReverseLinkedList() {

    }

    public LinkedListNode reverse(LinkedListNode head) {
        // initialize prev and next pointer to NULL
        LinkedListNode prev = null;
        LinkedListNode next = null;

        // set current pointer to the head node
        LinkedListNode curr = head;

        // while the current pointer is not NULL
        while (curr != null) {
            // set the next pointer to the next node in the list
            next = curr.next;

            // reverse the current node's pointer to point to the previous node
            curr.next = prev;

            // set the previous pointer to the current node
            prev = curr;

            // move the current pointer to the next node
            curr = next;
        }

        // set the head pointer to the last node, which is the new first node after
        // reversal
        head = prev;

        // return the new head pointer
        return head;
    }
}
