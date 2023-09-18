package com.example.Trie;

public class SearchSuggestionsSystem {
    /**
     * Given an array of strings called products and a word to search, design a system that, 
     * when each character of the searched word is typed, suggests at most three product names from products. 
     * Suggested products should share a common prefix with the searched word. If more than three products exist with a common prefix, 
     * return the three product names that appear first in lexicographical order.
     * 
     * Return the suggested products, which will be a list of lists after each character of searched word is typed.
     * 
     * Strategy
     * [1] Insert all product names in a trie, creating a node for each new character in a word.
     * [2] As each new letter of the searched word is received, retrieve all words in the trie whose initial characters match. For example, if “gam” has been typed in, it may match “game”, “games”, “gamify” and “gamma”.
     * [3] If there are more than three matched strings, return the ones that appear first in the lexicographic order. In our example, we would return “game”, “games” and “gamify”.
     */

     public SearchSuggestionsSystem(){

     }
}
