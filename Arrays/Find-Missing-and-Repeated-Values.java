Problem

You are given an n × n grid containing numbers from 1 to n².

One number appears twice and one number is missing.

Return the repeated number and the missing number.

Example

Input

grid = [[1,3],
        [2,2]]

Output

[2,4]

Explanation

Numbers from 1..4 should appear.

Actual numbers: 1,2,2,3

Repeated → 2
Missing → 4

Approach 1 — Using Frequency Array
Idea

Total numbers = n²

Create a frequency array of size n² + 1

Traverse the grid and count occurrences

Number with:

frequency 2 → repeated

frequency 0 → missing

Time Complexity
O(n²)
Space Complexity
O(n²)
Java Implementation
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        int missing = -1;
        int repeated = -1;

        for(int i = 1; i <= size; i++) {
            if(freq[i] == 0) {
                missing = i;
            }
            if(freq[i] == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing};
    }
}


Approach 2 — Mathematical Method (Optimal)
Idea

For numbers 1..n²

Expected sum:

S = n²(n² + 1) / 2

Expected square sum:

P = n²(n² + 1)(2n² + 1) / 6

Let

x = repeated
y = missing

From the grid:

actualSum = S + x - y
actualSquareSum = P + x² - y²

Solve the two equations to get x and y.

Time Complexity
O(n²)
Space Complexity
O(1)
Java Implementation
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long sum = 0;
        long squareSum = 0;

        for(int[] row : grid){
            for(int val : row){
                sum += val;
                squareSum += (long) val * val;
            }
        }

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long diff = sum - expectedSum; 
        long squareDiff = squareSum - expectedSquareSum;

        long sumXY = squareDiff / diff;

        long repeated = (diff + sumXY) / 2;
        long missing = sumXY - repeated;

        return new int[]{(int) repeated, (int) missing};
    }
}
