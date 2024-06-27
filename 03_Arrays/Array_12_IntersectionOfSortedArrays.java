import java.util.*;

public class Array_12_IntersectionOfSortedArrays {

     public static void main(String args[]) {
          int arr1[] = { 1, 1, 2, 2, 3, 4, 5 };
          int arr2[] = { 2, 3, 4, 4, 5, 6 };

          int result[] = optimalApproach(arr1, arr2);
          for (int i : result) {
               System.out.print(i + " ");
          }
     }

     public static int[] bruteForce(int arr1[], int arr2[]) {
          Map<Integer, Boolean> visited = new HashMap<>();

          // Mark all elements in arr1 and arr2 as not visited initially
          for (int element : arr1) {
               visited.put(element, false);
          }

          for (int element : arr2) {
               visited.put(element, false);
          }

          List<Integer> intersectionList = new ArrayList<>();

          // Find intersection elements
          for (int i = 0; i < arr1.length; i++) {
               for (int j = 0; j < arr2.length; j++) {
                    // Check for intersection and ensure element is not visited yet
                    if (arr1[i] == arr2[j] && !visited.get(arr1[i])) {
                         intersectionList.add(arr1[i]);
                         visited.put(arr1[i], true); // Mark element as visited
                         break; // Break inner loop after finding the intersection
                    }
                    // Since arrays are sorted, move to the next element in arr2 if current element
                    // in arr1 is greater
                    if (arr1[i] < arr2[j]) {
                         break;
                    }
               }
          }

          // Convert list to array
          int[] result = new int[intersectionList.size()];
          for (int k = 0; k < intersectionList.size(); k++) {
               result[k] = intersectionList.get(k);
          }

          return result;
     }

     /*
      * Explanation:
      * The brute force approach finds the intersection of two sorted arrays by using
      * a HashMap to track visited elements:
      * 
      * 1. Initialize a HashMap `visited` to mark elements in arr1 and arr2 as
      * visited.
      * 2. Traverse both arrays and mark all elements as not visited in the `visited`
      * map.
      * 3. Use nested loops to iterate through arr1 and arr2 to find common elements.
      * 4. Add each common element to an ArrayList `intersectionList` and mark it as
      * visited
      * in the `visited` map to prevent duplicates.
      * 5. Convert the `intersectionList` to an array `result` and return it.
      * 
      * Time Complexity: O(n * m), where n and m are the lengths of the two arrays.
      * In the worst case,
      * where arrays have no common elements, each element of arr1 is compared with
      * each element of arr2.
      * Space Complexity: O(min(n, m)), due to the space used by the `visited` map
      * and `intersectionList`.
      */

     public static int[] optimalApproach(int arr1[], int arr2[]) {

          List<Integer> result = new ArrayList<>();

          int m = arr1.length, n = arr2.length;
          int i = 0, j = 0;

          while (i < m && j < n) {
               if (arr1[i] == arr2[j]) {
                    result.add(arr1[i]);
                    i++;
                    j++;
               } else if (arr1[i] < arr2[j]) {
                    i++;
               } else if (arr1[i] > arr2[j]) {
                    j++;
               }

          }

          // Convert result list to array
          return result.stream().mapToInt(Integer::intValue).toArray();

     }

     /*
      * Explanation:
      * The optimal approach finds the intersection of two sorted arrays using two
      * pointers:
      * 
      * 1. Initialize an empty ArrayList `result` to store intersection elements.
      * 2. Use two pointers `i` and `j` to traverse `arr1` and `arr2` respectively.
      * 3. Compare elements pointed by `i` and `j`:
      * - If `arr1[i]` equals `arr2[j]`, add `arr1[i]` (or `arr2[j]`, as they are
      * equal) to `result`.
      * - Move both pointers `i` and `j` forward.
      * - If `arr1[i]` is less than `arr2[j]`, move `i` forward.
      * - If `arr1[i]` is greater than `arr2[j]`, move `j` forward.
      * 4. Continue until reaching the end of either array.
      * 5. Convert `result` ArrayList to an integer array and return.
      * 
      * Time Complexity: O(n + m), where n and m are the lengths of the two arrays
      * `arr1` and `arr2`.
      * The algorithm processes each element at most once in both arrays.
      * Space Complexity: O(min(n, m)), due to the space used by the `result`
      * ArrayList to store
      * intersection elements.
      */
}
