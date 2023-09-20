package com.example.Greedy;

public class JumpGame {
    /**
     * In a single-player jump game, the player starts at one end of a series of squares, with the goal of reaching the last square.
     * 
     * At each turn, the player can take up to s steps towards the last square, where s is the value of the current square.
     * For example, if the value of the current square is 3, the player can take either 3 steps, or 2 steps, or 1 step in the direction of the last square. The player cannot move in the opposite direction, that is, away from the last square.
     * You have been tasked with writing a function to validate whether a player can win a given game or not.
     * You’ve been provided with the nums integer array, representing the series of squares. The player starts at the first index and, following the rules of the game, tries to reach the last index.
     * If the player can reach the last index, your function returns TRUE; otherwise, it returns FALSE.
     * 
     * Strategy
     * [1] Set the last element in the array as your initial target.
     * [2] Traverse the array from the end to the first element in the array.
     * [3] If the current index is reachable from any preceding index, based on the value at that index, make that index the new target.
     * [4] If you reach the first index of the array without finding any index from which the current target is reachable, return FALSE.
     * [5] Else, if you are able to move each current target backward all the way to the first index of the array, you’ve found a path from the start to the end of the array. Return TRUE.
     */

     public JumpGame(){

     }

     public boolean jumpGame(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i --){
            int currentDestination = i + nums[i];
            if (currentDestination >= lastIndex){
                lastIndex = i;
            }
        }

        return lastIndex == 0;
     }
}
