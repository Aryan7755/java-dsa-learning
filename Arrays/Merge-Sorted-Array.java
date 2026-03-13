Problem

You are given two sorted integer arrays nums1 and nums2.

nums1 has a length of m + n

The first m elements are valid numbers

The last n elements are 0 and should be ignored

Merge nums2 into nums1 so that the final array remains sorted.

The result must be stored inside nums1.

Example

Input

nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output

[1,2,2,3,5,6]
Pattern

Two Pointers (Backward Merge)

Why backward?

Because the extra space is already at the end of nums1, so merging from the back avoids overwriting elements.

Approach

Set three pointers

i = m - 1 → last valid element of nums1

j = n - 1 → last element of nums2

k = m + n - 1 → last index of nums1

Compare nums1[i] and nums2[j]

Place the larger element at position k

Move the pointers accordingly.

Time Complexity
O(m + n)

We traverse both arrays once.

Space Complexity
O(1)

In-place merge.

Java Implementation
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
Key Insight

If we start merging from the front, elements of nums1 would get overwritten.

Merging from the back solves this problem.
