import java.util.*;

public class Array_13_MissingNumber {
     public static void main(String agrs[]) {
          int arr[] = { 1, 2, 3, 4, 5, 6, 7, 9 };
          System.out.println("Missing is: " + betterApproachUsingXOR(arr));

     }

     // Assumes array is Sorted.
     public static int bruteForce(int arr[]) {

          for (int i = 0; i < arr.length; i++) {
               if (!(arr[i] == i + 1)) {
                    return i + 1;
               }

          }
          return arr.length + 1;
     }

     // Array might not be sorted
     public static int betterApproach(int arr[]) {
          HashMap<Integer, Boolean> map = new HashMap<>();

          for (int i = 1; i <= arr.length; i++) {
               map.put(i, false);
          }

          for (int i = 0; i < arr.length; i++) {
               if (map.containsKey(arr[i])) {
                    map.put(arr[i], true);
               }
          }

          for (int i = 1; i <= arr.length; i++) {
               if (!map.get(i)) {
                    return i;
               }
          }

          return -1;

     }

     /*
      * Explanation:
      * 
      * The betterApproach method finds the missing number in an array where the
      * elements may not be sorted:
      * 
      * 1. Initialize a HashMap `map` to mark numbers from 1 to n (where n is the
      * length of the array) as false initially.
      * 
      * 2. Traverse the array and mark each number present in the array as true in
      * the HashMap.
      * 
      * 3. Traverse through numbers from 1 to n and find the first number that is
      * still marked as false in the HashMap. This number is the missing number.
      * 
      * Time Complexity: O(n), where n is the length of the array. This is because
      * we traverse the array and the HashMap once.
      * 
      * Space Complexity: O(n), due to the space used by the HashMap to store the
      * numbers from 1 to n.
      */

     public static int betterApproachUsingSum(int arr[]) {
          int requiredSum = 0, actualSum = 0;
          // Step 1: Calculate the sum of first n natural numbers (1 to n)
          for (int i = 1; i <= arr.length + 1; i++) {
               requiredSum += i;
          }

          // Step 2: Calculate the sum of elements in the array
          for (int i = 0; i < arr.length; i++) {
               actualSum += arr[i];
          }

          // Step 3: The missing number is the difference between requiredSum and
          // actualSum
          return requiredSum - actualSum;

     }

     public static int betterApproachUsingXOR(int arr[]) {
          int requiredXOR = 0, actualXOR = 0;

          

          for (int i = 0; i < arr.length; i++) {
               actualXOR = actualXOR ^ arr[i];
               requiredXOR = requiredXOR^(i+1);
          }

          requiredXOR = requiredXOR^(arr.length+1);

          return actualXOR^requiredXOR;

     }
}
