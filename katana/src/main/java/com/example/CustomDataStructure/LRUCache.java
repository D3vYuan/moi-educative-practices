package com.example.CustomDataStructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * Implement an LRU cache class with the following functions:
     * Init(capacity): Initializes an LRU cache with the capacity size.
     * Set(key, value): Adds a new key-value pair or updates an existing key with a
     * new value.
     * Get(key): Returns the value of the key, or −1 if the key does not exist.
     * 
     * If the number of keys has reached the cache capacity, evict the least
     * recently used key and then add the new key.
     * 
     * As caches use relatively expensive, faster memory, they are not designed to
     * store very large data sets. Whenever the cache becomes full,
     * we need to evict some data from it. There are several caching algorithms to
     * implement a cache eviction policy.
     * 
     * LRU is a very simple and commonly used algorithm. The core concept of the LRU
     * algorithm is to evict the oldest data from the cache to accommodate more
     * data.
     * 
     * Strategy
     * [1] To set a pair, if the given key already exists, then we’ll update the
     * value and move the pair to the front of the list.
     * [2] If the key doesn’t exist, check whether the cache is full. If there’s the
     * capacity to add a new pair, then add it at the front of the list.
     * [3] If the cache is full, remove the LRU pair and add the pair at the front
     * of the list.
     * [4] To get a value if the given key doesn’t exist, return -1.
     * [5] Else, return the corresponding value to the key and move the pair to the
     * front of the list.
     */
    class LinkedListNode<T> {
        public T data;
        public LinkedListNode<T> next;
        public LinkedListNode<T> prev;

        public LinkedListNode(T dataval) {
            this.data = dataval;
            this.next = null;
            this.prev = null;
        }
    }

    class LinkedList<T>{
        private LinkedListNode<T> head;
        private LinkedListNode<T> tail;
        private int length; 

        public LinkedList(){
            this.head = null;
            this.tail = null;
        }

        public int size(){
            return this.length;
        }

        public void insertAtHead(T data) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
            this.length++;
        }
    
        public void insertAtTail(T data) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
            this.length++;
        }
    
        public void addFirst(LinkedListNode<T> newNode) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
            this.length++;
        }
    
        public void addLast(LinkedListNode<T> newNode) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
            this.length++;
        }
    
        public void remove(T data) {
            LinkedListNode<T> tmp = this.head;
            while (tmp != null) {
                if (tmp.data == data) {
                    this.remove(tmp);
                    return;
                }
                tmp = tmp.next;
            }
        }
    
        public void remove(LinkedListNode<T> node) {
            if (node == null)
                return;
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            if (node == this.head)
                this.head = this.head.next;
            if (node == this.tail) {
                this.tail = this.tail.prev;
                if (this.tail != null)
                    this.tail.next = null;
            }
            this.length--;
            node = null;
        }
    
        public void removeFirst() {
            this.remove(this.head);
        }
    
        public void removeLast() {
            this.remove(this.tail);
        }
    
        public LinkedListNode<T> getFirst() {
            return this.head;
        }
    
        public LinkedListNode<T> getLast() {
            return this.tail;
        }
    }

    class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class KeyValuePairLL extends LinkedList<Pair> {
        
    };

    // We will use a linkedlist of a pair of integers
    // where the first integer will be the key
    // and the second integer will be the value

    int cacheCapacity;
    Map<Integer, LinkedListNode<Pair>> cacheMap = new HashMap<>();
    KeyValuePairLL cacheList = new KeyValuePairLL();

    // Constructor that sets the size of the cache
    public LRUCache(int size) {
        // Write your code here
        this.cacheCapacity = size;
    }

    int get(int key) {
        // Replace this placeholder return statement with your code
        LinkedListNode<Pair> foundIter;

        if (cacheMap.containsKey(key))
            foundIter  = cacheMap.get(key);
        else
            return -1;

        LinkedListNode<Pair> listIterator = foundIter;
        cacheList.remove(foundIter);
        cacheList.addFirst(listIterator);

        return listIterator.data.second;
    }

    void set(int key, int value) {
        if (cacheMap.containsKey(key)){
            LinkedListNode<Pair> foundIter = cacheMap.get(key);
            LinkedListNode<Pair> listIterator = foundIter;

            cacheList.remove(foundIter);
            cacheList.addFirst(listIterator);

            listIterator.data.second = value;
            return;
        }
        
        if (cacheMap.size() == cacheCapacity) {
			int keyTmp = cacheList.getLast().data.first;
			cacheList.removeLast();
			cacheMap.remove(keyTmp);
		}

		cacheList.insertAtHead(new Pair(key, value));

		if (cacheMap.containsKey(key)) {
			cacheMap.replace(key, cacheList.getFirst());
		} else {
			cacheMap.put(key, cacheList.getFirst());
		}
    }

}
