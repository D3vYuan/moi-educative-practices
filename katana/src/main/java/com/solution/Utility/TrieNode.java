package com.solution.Utility;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public boolean isWord() {
        return this.isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}
