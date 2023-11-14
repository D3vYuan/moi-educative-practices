package com.solution.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.solution.Utility.UnionFind;

public class AccountMerge {
    /*
     * 
     * Strategy
     * [1] Assign unique IDs to each account.
     * [2] Iterate over each account. For each account, go over each email, and set
     * their IDs as per the accounts to which they belong.
     * [3] Merge all accounts that share the same email(s) into a single account.
     * [4] Iterate over the list of merged accounts, and sort the emails in each
     * account.
     */

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        // Create a map for mapping emails to their parent IDs
        Map<String, Integer> emailMapping = new HashMap<>();

        // If the email already exists in the map, take union
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);

            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (emailMapping.containsKey(email)) {
                    // Before we take the union, make sure both the accounts have the same name
                    String account1 = accounts.get(i).get(0);
                    Integer accountId = emailMapping.get(email);
                    String account2 = accounts.get(accountId).get(0);
                    if (!account1.equals(account2)) {
                        return new ArrayList<>(); // Return empty list to indicate an error
                    }
                    uf.union(accountId, i);
                }
                // Add email with its ID to the map
                emailMapping.put(email, i);
            }
        }

        // Create a map to store the merged accounts
        List<List<String>> finalMerged = new ArrayList<>();
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : mergedAccounts.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0));
            finalMerged.add(merged);
        }

        return finalMerged;
    }
}
