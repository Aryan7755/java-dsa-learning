Problem

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum, and return its sum.

Example:

Input:

nums = [-2,1,-3,4,-1,2,1,-5,4]

Output:

6

Explanation:

The subarray [4, -1, 2, 1] has the maximum sum = 6.

Approach

->A brute force solution would check all possible subarrays, which leads to O(n²) complexity.
->Instead, we use Kadane's Algorithm, which works in O(n) time.

Idea:
Maintain a running sum currentSum
If currentSum becomes negative, reset it to the current element
Track the maximum sum encountered
This works because a negative prefix will only reduce future sums, so it should be discarded.

Algorithm:
1.Initialize maxSum with the first element
2.Initialize currentSum with the first element
3.Traverse the array from index 1
    Update:
    currentSum = max(nums[i], currentSum + nums[i])
    maxSum = max(maxSum, currentSum)
4.Return maxSum

Java Implementation
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

Complexity Analysis

Time Complexity

O(n)

Space Complexity

O(1)
