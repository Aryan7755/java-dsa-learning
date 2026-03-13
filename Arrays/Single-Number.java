Problem

Given a non-empty array of integers, every element appears twice except for one.
Find that single element.

You must solve it with linear runtime complexity and constant extra space.

Example

Input

nums = [2,2,1]

Output

1

Input

nums = [4,1,2,1,2]

Output

4
Pattern

Bit Manipulation (XOR)

Tags you can write in your repo:

Pattern: Bit Manipulation
Tags: Array, XOR
Difficulty: Easy
Key Idea

XOR has two important properties:

a ^ a = 0
a ^ 0 = a

If we XOR all numbers:

duplicate numbers cancel out

only the single number remains

Example:

2 ^ 2 ^ 1
= (2 ^ 2) ^ 1
= 0 ^ 1
= 1
Approach

Initialize a variable result = 0

Traverse the array

XOR each element with result

Final value of result is the single number

Time Complexity
O(n)
Space Complexity
O(1)
Java Implementation
class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int num : nums){
            result = result ^ num;
        }

        return result;
    }
}
