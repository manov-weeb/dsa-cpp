
import java.util.*;

public class Array_08_RemoveDuplicatesInASortedArray {

     public static void main(String args[]) {
          int arr[] = { 2, 4, 6, 6, 6, 8, 8, 10, 10, 12, 15, 15 };

          optimalApproach(arr);

          for (int i : arr) {
               System.out.print(i + " ");
          }
     }

     public static void bruteForce(int arr[]) {
          Set<Integer> uniqueElements = new HashSet<>();

          for (int element : arr) {
               uniqueElements.add(element);
          }

          Iterator<Integer> iterator = uniqueElements.iterator();

          int i = 0;

          while (iterator.hasNext()) {
               int element = iterator.next();

               arr[i++] = element;

          }

          while (i <= (arr.length - 1)) {
               arr[i++] = 0;

          }

     }

     /*
      * Explanation:
      * The Brute Force Approach uses a HashSet to remove duplicates from a sorted
      * array:
      * 1. HashSet stores only unique values, so as we traverse the input array, we
      * add each element to the HashSet [O(n)].
      * 2. After adding unique elements to the HashSet, we iterate through the
      * HashSet and update the original array with these unique elements.
      * 3. Finally, any remaining positions in the array are filled with 0, assuming
      * there are no 0s in the original array.
      */

     public static void betterApproach(int arr[]) {
          int n = arr.length;

          int i = 0, j = 1, iterator = 0;

          while (iterator < n-1) {
               if (arr[i] == arr[j]) {
                    j++;
                    
               }
               else if(arr[i]!= arr[j]){
                    arr[i+1] = arr[j];
                    i++;
                    j++;
               }

               iterator++;

              
          }

          while (i<n) {
               arr[i] = 0;
               i++;
          }

     }

      /*
      * Explanation:
      * The Better Approach iteratively compares adjacent elements in the sorted array:
      * 1. It maintains two pointers i and j to track current and next elements.
      * 2. If arr[i] equals arr[j], it means duplicates are found; thus, j is incremented to skip duplicates.
      * 3. If arr[i] is different from arr[j], arr[i+1] is updated with arr[j], i and j are incremented to move forward.
      * 4. This approach ensures that all duplicates are skipped, and unique elements are retained efficiently.
      * 5. Finally, any remaining positions in the array are filled with 0, assuming there are no 0s in the original array.
      */

      public static void optimalApproach(int arr[]){

          int i = 0;
          for (int j = 1; j < arr.length; j++) {
               if (arr[j]!=arr[i]) {
                    arr[i+1] = arr[j];
                    i++;
               }
          }

          for (int j = i; j < arr.length; j++) {
               arr[j] = 0;
          }
      }
}
