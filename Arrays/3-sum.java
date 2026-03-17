Problem Statement :

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1,-1,2],[-1,0,1]]

Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].

Brute Approach
Using Nested Loops : Sorting the array helps in value structure and avoids duplication, where we check all possible triplets. A HashSet guarantees that we keep just distinct triplets.
Java implementation :
  
      int n = nums.length;
       Arrays.sort(nums); // Step 1: Sort the array
       Set<List<Integer>> set = new HashSet<>(); // Step 2: Use a Set to store only unique triplets
       List<List<Integer>> result = new ArrayList<>();
       // Step 3: Iterate through every possible triplet
       for (int i = 0; i < n; i++) {
           for (int j = i + 1; j < n; j++) {
               for (int k = j + 1; k < n; k++) {
                   int sum = nums[i] + nums[j] + nums[k]; // Calculate sum of triplet
                   if (sum == 0) {
                       // Step 4: If sum is zero, add to set (auto-avoids duplicates)
                       set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                   }
               }
           }
       }
       // Step 5: Convert the set of unique triplets to a list
       result.addAll(set);
       return result;

Time Complexity - O(n^3 (log(k))

Better Approach
Using Two-Pointer and Set : By fixing one element and using two pointers to find the other two numbers that sum to the negative of the fixed element, we can efficiently find triplets.

Java implementation :
      List<List<Integer>> ans = new ArrayList<>();
       int n = nums.length;
       Arrays.sort(nums); // Step 1: Sort the array
       Set<List<Integer>> set = new HashSet<>(); // Step 2: Use a Set to store unique triplets
       // Step 3: Loop through each number
       for (int i = 0; i < n - 2; i++) {
           int low = i + 1;
           int high = n - 1;
           int target = -nums[i]; // Step 4: Target two-sum = -nums[i]
           // Step 5: Two-pointer search
           while (low < high) {
               int sum = nums[low] + nums[high];
               if (sum == target) {
                   // Found a triplet
                   set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                   low++;
                   high--;
               } else if (sum < target) {
                   low++; // Need a bigger sum
               } else {
                   high--; // Need a smaller sum
               }
           }
       }
       // Step 6: Convert set to list
       ans.addAll(set);
       return ans;

Time Complexity - O(n^2 (log(k))

Optimal Approach
Using Two Pointers : By Sorting the array, we fix one number. Then, we use two pointers to find two other numbers that, together, sum to zero. Sorting allows us to skip duplicates efficiently and use the two-pointer method to reduce time complexity.

Java implementation:

      List<List<Integer>> result = new ArrayList<>();
       int n = nums.length;
       Arrays.sort(nums); // Step 1: Sort the array
       for (int i = 0; i < n - 2; i++) {
           // Step 2: Skip duplicates for the first element
           if (i > 0 && nums[i] == nums[i - 1]) continue;
           int target = -nums[i];
           int left = i + 1, right = n - 1;
           // Step 3: Two-pointer approach
           while (left < right) {
               int sum = nums[left] + nums[right];
               if (sum == target) {
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   // Step 4: Skip duplicate values
                   while (left < right && nums[left] == nums[left + 1]) left++;
                   while (left < right && nums[right] == nums[right - 1]) right--;
                   left++;
                   right--;
               } else if (sum < target) {
                   left++;
               } else {
                   right--;
               }
           }
       }
       return result;

Time Complexity - O(n^2)
