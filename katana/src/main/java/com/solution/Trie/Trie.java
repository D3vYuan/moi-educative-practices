package com.solution.Trie;

import com.solution.Utility.TrieNode;

public class Trie {
    /**
     * 
     * Strategy
     * [1] Begin from the root node and iterate over the string one character at a
     * time.
     * [2] For each character, check if the current character exists as a child node
     * of the current node.
     * [3] If the character is found, move to that child node and continue to the
     * next character.
     * [4] If the character is not found, create a new node for that character, link
     * it as a child of the current node, and move to the newly created node.
     * [5] For the last character of the word, set a boolean variable to TRUE for
     * the corresponding node to indicate the end of the word.
     */

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // inserting string in trie
    public void insert(String word) {
        TrieNode trieNode = this.root;

        // Iterate over the word character by character.
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // If child node is not present, create a new node
            // and add to trie.
            if (!trieNode.getChildren().containsKey(c)) {
                trieNode.getChildren().put(c, new TrieNode());
            }
            trieNode = trieNode.getChildren().get(c);
        }

        // Once the a complete word is added to the trie,
        // set boolean variable to true.
        trieNode.setIsWord(true);
    }

    // searching for a string
    public boolean search(String word) {
        TrieNode trieNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // If there is no any child of a node,
            // return false as we do not find the word.
            if (!trieNode.getChildren().containsKey(c)) {
                return false;
            }

            trieNode = trieNode.getChildren().get(c);
        }
        // Return the word after traversing all nodes as it is found.
        return trieNode.isWord();
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        TrieNode trieNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            // If there is no any child of a node,
            // return false as we do not find the prefix.
            if (!trieNode.getChildren().containsKey(c)) {
                return false;
            } else {
                trieNode = trieNode.getChildren().get(c);
            }
        }

        // Return true after traversing all nodes as the prefix is found.
        return true;
    }
}
