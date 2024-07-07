import java.util.*;

public class Array_30_NumberOfSubArraysWithSumK {
     public static void main(String args[]) {
          int arr[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
          int k = 3;

          System.out.println(optimalSolution(arr, k));

     }

     public static int bruteForce(int arr[], int k) {

          int count = 0;
          for (int i = 0; i < arr.length; i++) {
               int sum = 0;
               for (int j = i; j < arr.length; j++) {

                    sum += arr[j];
                    if (sum == k) {
                         count++;
                    } 

               }

          }

          return count;
     }

     public static int optimalSolution(int arr[], int k) {
          int prefixSum = 0;  // Initialize the prefix sum
          int count = 0;  // Initialize the count of subarrays with sum k

          // HashMap to store the frequency of prefix sums
          HashMap<Integer, Integer> map = new HashMap<>();
          map.put(0, 1);  // Add base case for prefix sum 0

          // Iterate over each element in the array
          for (int i = 0; i < arr.length; i++) {
               prefixSum += arr[i];  // Update the prefix sum by adding current element

               // Check if (prefixSum - k) exists in the map
               count += map.getOrDefault(prefixSum - k, 0);

               // Update the frequency of the current prefix sum in the map
               map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
          }

          return count;  // Return the total count of subarrays with sum k
     }
}