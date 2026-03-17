Problem Statement

Given an integer array nums and an integer target, return all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

a, b, c, d are distinct indices

nums[a] + nums[b] + nums[c] + nums[d] == target

The solution set must not contain duplicate quadruplets

Example

Input:
nums = [1,0,-1,0,-2,2], target = 0

Output:
[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Brute Approach
Using 4 Nested Loops

Check all possible quadruplets and use a Set to avoid duplicates.

Java Implementation
int n = nums.length;
Arrays.sort(nums);
Set<List<Integer>> set = new HashSet<>();

for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
            for (int l = k + 1; l < n; l++) {
                long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }
            }
        }
    }
}

return new ArrayList<>(set);
Time Complexity

O(n^4 * log(k))

Better Approach
Using 3 Loops + HashSet

Fix two elements and use a HashSet to find the remaining two.

Java Implementation
int n = nums.length;
Arrays.sort(nums);
Set<List<Integer>> set = new HashSet<>();

for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        Set<Long> hash = new HashSet<>();
        
        for (int k = j + 1; k < n; k++) {
            long needed = (long)target - nums[i] - nums[j] - nums[k];
            
            if (hash.contains(needed)) {
                List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int)needed);
                Collections.sort(quad);
                set.add(quad);
            }
            hash.add((long)nums[k]);
        }
    }
}

return new ArrayList<>(set);
Time Complexity

O(n^3 * log(k))

Optimal Approach
Using Sorting + Two Pointers

Fix first two elements

Use two pointers for the remaining two

Skip duplicates efficiently

Java Implementation
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long remaining = (long) target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) nums[left] + nums[right];

                    if (sum == remaining) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } 
                    else if (sum < remaining) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
Time Complexity

O(n^3)
