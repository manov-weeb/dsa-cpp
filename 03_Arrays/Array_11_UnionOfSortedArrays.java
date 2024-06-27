import java.util.*;

public class Array_11_UnionOfSortedArrays {
     public static void main(String args[]) {

          int arr1[] = { 1, 1, 2, 2, 3, 4, 5 };
          int arr2[] = { 2, 3, 4, 4, 5, 6 };

          int result[] = optimalApproach(arr1, arr2);
          for (int i : result) {
               System.out.print(i + " ");
          }

     }

     public static int[] bruteForce(int arr1[], int arr2[]) {

          Set<Integer> uniqueElements = new HashSet<>();

          // Add all elements of arr1 to the set
          for (int element : arr1) {
               uniqueElements.add(element);
          }

          // Add all elements of arr2 to the set
          for (int element : arr2) {
               uniqueElements.add(element);
          }

          // Convert set to an array
          int result[] = new int[uniqueElements.size()];
          int index = 0;
          for (int element : uniqueElements) {
               result[index++] = element;
          }

          // Sort the result array
          Arrays.sort(result);

          return result;
     }

     /*
      * Explanation:
      * The brute force approach uses a HashSet to find the union of two sorted
      * arrays:
      * 1. Traverse both arrays and add each element to a HashSet to ensure all
      * unique elements are stored.
      * 2. Convert the HashSet back to an array.
      * 3. Sort the result array.
      * 
      * Time Complexity: O(n + m + (n + m) log (n + m)), where n and m are the
      * lengths of the two arrays.
      * Space Complexity: O(n + m), due to the HashSet used.
      */

     public static int[] optimalApproach(int arr1[], int arr2[]) {
          List<Integer> result = new ArrayList<>();

          int m = arr1.length, n = arr2.length;
          int i = 0, j = 0;

          while (i < m && j < n) {
               if (arr1[i] <= arr2[j]) {
                    if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                         result.add(arr1[i]);
                    }
                    i++;
               } else if (arr1[i] >= arr2[j]) {
                    if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                         result.add(arr2[j]);
                    }
                    j++;
               }

          }

          while (i < m) {
               result.add(arr1[i]);
               i++;
          }

          while (j < n) {
               result.add(arr2[j]);
               j++;
          }

          // Convert result list to array
          return result.stream().mapToInt(Integer::intValue).toArray();
     }

     /*
      * Explanation:
      * 
      * The optimalApproach method finds the union of two sorted arrays arr1 and
      * arr2.
      * It uses a merging technique similar to the merge step of the merge sort.
      * 
      * Steps:
      * 1. Initialize a List<Integer> result to store the union of arr1 and arr2.
      * 2. Initialize pointers i and j to traverse arr1 and arr2 respectively.
      * 3. Use a while loop to compare elements of arr1 and arr2 until either array
      * is fully traversed.
      * 4. Inside the loop:
      * - If arr1[i] <= arr2[j], check if the result list is empty or if the last
      * added element is different from arr1[i].
      * If true, add arr1[i] to the result list.
      * Increment i to move to the next element in arr1.
      * - Otherwise (arr1[i] > arr2[j]), add arr2[j] to the result list under the
      * same condition.
      * Increment j to move to the next element in arr2.
      * 5. After the loop, append any remaining elements of arr1 or arr2 to the
      * result list.
      * 6. Convert the result list to an int[] array using streams and return it.
      * 
      * This approach ensures that all elements in the result array are unique and in
      * sorted order.
      * 
      * Time Complexity: O(m + n), where m and n are the lengths of arr1 and arr2
      * respectively,
      * since each element is processed exactly once.
      * Space Complexity: O(m + n), due to the List used to store the result.
      */

}
