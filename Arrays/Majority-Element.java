/*
Problem: Majority Element
Platform: LeetCode
Topic: Arrays

Approach:
Use Boyer-Moore Voting Algorithm.
Maintain a candidate and a count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
