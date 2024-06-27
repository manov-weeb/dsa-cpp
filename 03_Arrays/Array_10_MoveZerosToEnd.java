
public class Array_10_MoveZerosToEnd {
     public static void main(String args[]) {
          int arr[] = { 2, 1, 0, 0, 9, 5, 0, 7, 1, 2, 0, 9, 0 };

          optimalApproach(arr);

          for (int i : arr) {
               System.out.print(i + " ");
          }

     }

     public static void bruteForce(int arr[]) {
          int n = arr.length;

          int nonZero[] = new int[n];
          int index = 0;

          for (int i = 0; i < n; i++) {
               if (arr[i] != 0) {
                    nonZero[index++] = arr[i];
               }
          }

          while (index < n) {
               nonZero[index++] = 0;
          }

          for (int i = 0; i < n; i++) {
               arr[i] = nonZero[i];
          }

     }
     /*
      * Explanation:
      * The brute force approach uses an additional array to store non-zero elements:
      * 1. Traverse the input array and store all non-zero elements in a new array.
      * 2. Fill the remaining positions in the new array with zeros.
      * 3. Copy the contents of the new array back to the original array.
      * 
      * Time Complexity: O(n) + O(n - No. of Non Zero Elements) + O(n), where n is
      * the number of elements in the array.
      * Space Complexity: O(n), due to the additional array used.
      */

     public static void optimalApproach(int arr[]) {
          int n = arr.length;

          // finding the first 0 zero
          int j = -1;
          for (int i = 0; i < n; i++) {
               if (arr[i] == 0) {
                    j = i;
                    break;
               }

          }

          if (j == -1) {
               return;
          }

          for (int i = j + 1; i < n; i++) {
               if (arr[i] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    j++;

               }

          }

     }

     /*
      * Explanation:
      * The optimal approach moves zeros to the end in-place:
      * 1. Find the first zero in the array and use it as a reference point (index
      * j).
      * 2. Traverse the array from the position after the first zero.
      * 3. Whenever a non-zero element is found, swap it with the element at index j.
      * 4. Increment j to keep track of the next zero position.
      * 
      * Time Complexity: O(n), where n is the number of elements in the array.
      * Space Complexity: O(1), as it uses only a few extra variables for swapping.
      */

}
