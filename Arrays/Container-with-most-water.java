Problem Statement :

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the i th line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Example:
Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
Output: 49

Brute Approach
Using Nested Loops :
Find every possible pair of vertical lines using nested for loop, then determine how much water we can store, and update the maximum water area.
  
Time Complexity	
O(n^2)

  
Optimal Approach
Using Two Pointers :
We are using two pointers (left=0, right=n-1) to find the maximum area between two lines by always moving the pointer at the shorter height to potentially get a taller line and a larger area.

1. Initialize Two Pointers:
    Start with one pointer at the beginning (left=0) and the other at the end (right=n-1) of the array.
2. Calculate the Area:
    For each pair of lines, compute the area as width × min(height[left], height[right]).
3. Update the Maximum Area:
    Track the largest area found during the iteration.
4. Move the Pointer with Smaller Height:
    To potentially increase the area, shift the pointer pointing to the shorter line inward.
5. Repeat the Process until the two pointers meet, and then return the maxArea. 

Time Complexity	
O(n) 

Java Implementation - 

import java.util.*;  // Import utilities

class Solution {
   // Function to calculate the maximum area of water container
   public int maxArea(int[] height) {
       int n = height.length;
       int maxWater = 0;
       int left = 0, right = n - 1; // Initialize two pointers

       // Continue until pointers meet
       while (left < right) {
           int width = right - left; // Width between lines
           int minHeight = Math.min(height[left], height[right]); // Height is min of two lines
           maxWater = Math.max(maxWater, width * minHeight); // Update max area

           // Move the pointer pointing to the smaller height
           if (height[left] < height[right])
               left++;
           else
               right--;
       }

       return maxWater;
   }
}


	
