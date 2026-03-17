Problem Statement

Given an m x n integer matrix where:
Each row is sorted in ascending order
The first integer of each row is greater than the last integer of the previous row
Given an integer target, return true if target exists in the matrix, otherwise return false.

Example

Input:

matrix = [
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
], target = 3

Output:
true
  
Brute Approach
Using Linear Search

Traverse every element in the matrix and check if it equals the target.

Java Implementation
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == target) {
            return true;
        }
    }
}
return false;

Time Complexity -> O(m * n)

Better Approach
Binary Search on Each Row

For each row, apply binary search since rows are sorted.

Java Implementation
for (int i = 0; i < matrix.length; i++) {
    int left = 0, right = matrix[0].length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (matrix[i][mid] == target) return true;
        else if (matrix[i][mid] < target) left = mid + 1;
        else right = mid - 1;
    }
}
return false;

Time Complexity -> O(m * log n)
  
Optimal Approach
Treat Matrix as 1D Array (Binary Search)

Since the matrix is globally sorted, treat it as a flattened sorted array and apply binary search.

Key Idea

Index mapping:

row = mid / n  
col = mid % n
Java Implementation
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
Time Complexity -> O(log(m * n))
