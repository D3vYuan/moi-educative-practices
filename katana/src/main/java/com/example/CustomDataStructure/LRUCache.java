package com.example.CustomDataStructure;

public class LRUCache {
    /**
     * Implement an LRU cache class with the following functions:
     *  Init(capacity): Initializes an LRU cache with the capacity size.
     *  Set(key, value): Adds a new key-value pair or updates an existing key with a new value.
     *  Get(key): Returns the value of the key, or −1 if the key does not exist.
     * 
     * If the number of keys has reached the cache capacity, evict the least recently used key and then add the new key.
     * 
     * As caches use relatively expensive, faster memory, they are not designed to store very large data sets. Whenever the cache becomes full, 
     * we need to evict some data from it. There are several caching algorithms to implement a cache eviction policy. 
     * 
     * LRU is a very simple and commonly used algorithm. The core concept of the LRU algorithm is to evict the oldest data from the cache to accommodate more data.
     * 
     * Strategy
     * [1] To set a pair, if the given key already exists, then we’ll update the value and move the pair to the front of the list.
     * [2] If the key doesn’t exist, check whether the cache is full. If there’s the capacity to add a new pair, then add it at the front of the list.
     * [3] If the cache is full, remove the LRU pair and add the pair at the front of the list.
     * [4] To get a value if the given key doesn’t exist, return -1.
     * [5] Else, return the corresponding value to the key and move the pair to the front of the list.
     */
}
