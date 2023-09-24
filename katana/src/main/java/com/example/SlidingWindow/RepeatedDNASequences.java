package com.example.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
    /**
     * Given a string, s, that represents a DNA subsequence,
     * and a number k, return all the contiguous subsequences (substrings) of length
     * k that occur more than once in the string. 
     * The order of the returned subsequences does not matter.
     * If no repeated substring is found, the function should return an empty set.
     * 
     * Strategy
     * [1] Iterate over the k-length substrings of the input string.
     * [2] Store the hash of the current substring to keep track of all unique
     * substrings.
     * [3] If the hash of a substring has already been stored, the substring is
     * repeated, so we add it to the output.
     * [4] When all substrings have been evaluated, return the output.
     */

    public RepeatedDNASequences() {

    }

    public Set<String> findRepeatedSequences(String s, int k) {
        int n = s.length();

        if (n < k) {
            return new HashSet<>();
        }

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        int a = 4;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        int hashValue = 0;

        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < n - k + 1; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a) + numbers.get(i + k - 1);
            }

            if (hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            hashSet.add(hashValue);
        }
        return output;
    }

    public Set<String> findRepeatedSequencesV1(String s, int k) {

        Map<String, Integer> frequencies = new HashMap<>();

        // Replace this placeholder return statement with your code
        if (s == null || s.length() <= 0) {
            return new HashSet<>();
        }

        int start = 0;
        int end = k - 1;

        while (end + 1 <= s.length()) {
            String currentString = s.substring(start, end + 1);
            System.out.println(String.format("Processing: %s from [%d] - [%d]", currentString, start, end));
            // char[] currentStringCharacters = currentString.toCharArray();
            // Arrays.sort(currentStringCharacters);
            // String currentSortedString = new String(currentStringCharacters);
            String currentSortedString = currentString;

            if (frequencies.containsKey(currentSortedString)) {
                // System.out.println(String.format("Processing: Updating %s", currentSortedString));
                int updatedCount = frequencies.get(currentSortedString) + 1;
                frequencies.replace(currentSortedString, updatedCount);
                System.out.println(String.format("Processing: Updating %s to count #%d", currentSortedString, updatedCount));
            } else {
                System.out.println(String.format("Processing: Adding %s", currentSortedString));
                frequencies.putIfAbsent(currentSortedString, 1);
            }

            start += 1;
            end += 1;
        }

        // Set<String> repeatedSequences  = frequencies.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toSet());
        // return repeatedSequences;

        Set<String> repeatedSequences  = new HashSet<>();
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()){
            int count = entry.getValue();
            if (count <= 1){
                continue;
            }
            System.out.println(String.format("Processing: Found repeated string (%s)", entry.getKey()));
            repeatedSequences.add(entry.getKey());
        }
        return repeatedSequences;
    }
}
