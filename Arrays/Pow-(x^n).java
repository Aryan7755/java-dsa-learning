Problem

Given a floating-point number x and an integer n, implement a function to calculate x raised to the power n (xⁿ).

You must not use built-in power functions.

Example
Input: x = 2.00000, n = 10
Output: 1024.00000

Input: x = 2.10000, n = 3
Output: 9.26100

Input: x = 2.00000, n = -2
Output: 0.25000

Approach
Exponentiation by Squaring Using Recursion :



We need to compute x^n, and instead of multiplying x by itself n times, we break it down to smaller parts using the following approach:

1. Even Exponent (n is even) :

    We can express x^n as (x^{n/2})^2. This reduces the problem to finding x^{n/2}, which we then square to get x^n.  

2. Odd Exponent (n is odd):

    For odd n, we split it as x^n = x * x^{n-1}. Now, we can compute x^{n-1} as (x^{(n-1)/2})^2 and multiply by x.

    By repeatedly halving the exponent, we drastically reduce the number of multiplications, making this approach much more efficient than directly multiplying x by itself n times.

          The base case is reached when n == 0 and returns 1.
          Negative Exponent: If n is negative, compute the result for -n and take the reciprocal.
          Divide and Conquer: Recursively compute x^(n/2). If n is even, square the result. If odd, multiply by x once more.
          Return: Reciprocal the result for negative n; otherwise, return the computed value.

Java Implementation
import java.util.*; // Import utility classes


class Solution {
   // Helper method for exponentiation by squaring
   public double helper(double x, int n) {
       if (n == 0) return 1; // Base case: x^0 = 1
       double temp = helper(x, n / 2); // Recursively compute x^(n/2)
       temp *= temp; // Square the result
       if (n % 2 != 0) temp *= x; // If odd, multiply by x
       return temp;
   }


   public double myPow(double x, int n) {
       if (n < 0) {
           long val = (long) n; // Convert to long to handle edge cases
           double ans = helper(x, (int) -val); // Compute for positive exponent
           return 1.0 / ans; // Return reciprocal for negative exponent
       }
       return helper(x, n);
   }


   public static void main(String[] args) {
       Solution sol = new Solution();
       double x = 2.0; // Dummy input: base
       int n = 10;     // Dummy input: exponent
       System.out.println(sol.myPow(x, n)); // Output: 1024.0
   }
}


Time Complexity -	O(log n)
Space Complexity -	O(log n)
