import java.util.HashMap;
import java.util.Map;

public class Array_16_LongestSubArrayWithSumK {
     public static void main(String args[]) {
          int arr[] = { 1, 2, 0, 0, 3, 1, 1, 1, 1, 4, 2, 3 };
          int k = 7;

          System.out.println(optimalApproach(arr, k));
     }

     public static int bruteForce(int arr[], int k) {
          int n = arr.length;
          int longest = 0;
          for (int i = 0; i < n; i++) {
               int sum = 0;
               for (int j = i; j < n; j++) {
                    sum += arr[j];

                    if (sum == k) {
                         longest = Math.max(longest, j - i + 1);
                    }
                    // int sum = 0;
                    // for (int j2 = i; j2 <= j; j2++) { // Corrected the loop condition
                    // sum += arr[j2]; // Sum the elements from i to j2
                    // if(sum == k){
                    // longest = Math.max(longest, (j2 - i + 1)); // Corrected the subarray length
                    // }
                    // }
               }
          }

          return longest;
     }

     public static int betterApproach(int arr[], int k) {
          int n = arr.length;
          Map<Integer, Integer> prefixSumMap = new HashMap<>();
          int sum = 0;
          int longest = 0;

          for (int i = 0; i < n; i++) {
               sum = sum + arr[i];

               if (sum == k) {
                    longest = i + 1;
               }

               if (prefixSumMap.containsKey(sum - k)) {
                    longest = Math.max(longest, i - prefixSumMap.get(sum - k));
               }
               prefixSumMap.putIfAbsent(sum, i);
          }

          return longest;
     }

     public static int optimalApproach(int arr[], int k) {
          int n = arr.length;
          int i = 0;
          int sum = 0, longest = 0;

          for (int j = 0; j < n; j++) {
               sum += arr[j];

              while (sum>k && i<=j) {
                sum = sum - arr[i];
                i++;
              }

               if(sum == k){
                    longest = Math.max((j-i+1), longest);
               }
              

          }

          return longest;
     }
}
