Problem Statement:

Given an array nums with n objects colored red, white, or blue, sort them in place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0 , 1 , and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Naive Approach
Using Two-Pass Sort -> Sort the array in two passes. Firstly, we move all 0s to the start of the array, and then we place 1s right after. The 2s will naturally be at the end.

Java implementation - 

  int n = nums.length;
  int i = -1;

       // Move all 0s to the beginning
       for (int j = 0; j < n; j++) {
           if (nums[j] == 0) {
               i++;
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
           }
       }
       int k = i + 1;
       // Move all 1s after 0s
       for (int j = k; j < n; j++) {
           if (nums[j] == 1) {
               i++;
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
           }
       }

Time Complexity	-> O(n) 

Optimal Approach
{ Dutch National Flag Algorithm }
Using three pointers:  low, mid, and high. We sort the array, where all 0s are at the front, 1s are in the middle, and 2s are at the end. This avoids extra space and ensures optimal efficiency.

  Traverse the array while mid <= high:
    If nums[mid] == 0, swap with nums[low] and increment both low and mid.
    If nums[mid] == 1, just move mid forward.
    If nums[mid] == 2, swap with nums[high] and decrement high (don't move mid yet).

Java implementation
  
import java.util.Arrays;
class Solution {
   // Helper method to swap elements in the array
   private static void swap(int[] nums, int a, int b) {
       int temp = nums[a];
       nums[a] = nums[b];
       nums[b] = temp;
   }
   public static void sortColors(int[] nums) {
       // Dutch National Flag algorithm
       int low = 0, mid = 0, high = nums.length - 1;
       // Loop through the array
       while (mid <= high) {
           if (nums[mid] == 0) {
               // Move 0 to the beginning
               swap(nums, low, mid);
               low++;
               mid++;
           } else if (nums[mid] == 1) {
               // Leave 1 in place
               mid++;
           } else {
               // Move 2 to the end
               swap(nums, mid, high);
               high--;
           }
       }
   }
}

Time Complexity	-> O(n) 
