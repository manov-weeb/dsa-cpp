import java.util.Arrays;

public class Array_41_PrefixXor {

     public static void main(String args[]) {
          int[] pref1 = { 5, 7, 2, 3, 1 };
          int[] result1 = findArray(pref1);
          System.out.println(Arrays.toString(result1)); // Output: [5, 2, 5, 6, 7]

          // Example 2
          int[] pref2 = { 4 };
          int[] result2 = findArray(pref2);
          System.out.println(Arrays.toString(result2)); // Output: [4]

          // Example 3
          int[] pref3 = { 1, 3, 0, 4 };
          int[] result3 = findArray(pref3);
          System.out.println(Arrays.toString(result3)); // Output: [1, 2, 3, 7]

          // Example 4
          int[] pref4 = { 2, 5, 1, 6, 9 };
          int[] result4 = findArray(pref4);
          System.out.println(Arrays.toString(result4)); // Output: [2, 7, 6, 7, 14]
     }

     public static int[] findArray(int[] pref) {
          int n = pref.length;
          int result[] = new int[n]; // Array to store the original array

          int element = pref[0];
          result[0] = element; // The first element of the original array is the same as the first element of
                               // the prefix XOR array

          for (int i = 1; i < n; i++) {
               element = pref[i] ^ pref[i - 1]; // Compute the current element of the original array
               result[i] = element; // Store it in the result array
          }

          return result; // Return the reconstructed original array
     }
}
