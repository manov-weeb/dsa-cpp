import java.sql.Time;

public class Array_09_RotateArray {
     public static void main(String args[]) {
          int arr[] = { 2, 4, 8, 10, 15 };

          rotateByDplacesOptimal(arr, 2);

          for (int i : arr) {
               System.out.print(i + " ");
          }
     }

     public static void rotateByOnePlace(int arr[]) {
          int n = arr.length;
          int temp = arr[0];
          for (int i = 1; i < n; i++) {
               arr[i - 1] = arr[i];

          }

          arr[n - 1] = temp;
     }

     public static void rotateByDplaces(int arr[], int d) {
          int n = arr.length;
          d = d % n;
          int temp[] = new int[d];

          for (int i = 0; i < d; i++) {
               temp[i] = arr[i];
          }

          for (int i = d; i < n; i++) {
               arr[i - d] = arr[i];
          }

          for (int i = (n - d); i < n; i++) {
               arr[i] = temp[i - (n - d)];

          }

     }

     /*
      * Explanation:
      * The rotateByDplaces method rotates the array to the left by 'd' places
      * using an additional array:
      * 1. The rotation distance 'd' is taken modulo the length of the array 'n' to
      * handle cases where 'd' is larger than 'n'.
      * 2. The first 'd' elements are stored in a temporary array.
      * 3. The remaining elements in the original array are shifted left by 'd'
      * positions.
      * 4. The elements from the temporary array are placed at the end of the
      * original array.
      * 
      * Time Complexity: O(d) + O(n - d) + O(d) = O(n)
      * Space Complexity: O(d) due to the temporary array used.
      */
     public static void rotateByDplacesOptimal(int arr[], int d) {
          int n = arr.length;
          d = d % n;

          reverse(arr, 0, d - 1);
          reverse(arr, d, n - 1);
          reverse(arr, 0, n - 1);

     }

     public static void reverse(int arr[], int a, int b) {
          while (a < b) {

               int temp = arr[a];
               arr[a++] = arr[b];
               arr[b--] = temp;

          }
     }

     /*
      * Explanation:
      * The rotateByDplacesOptimal method rotates the array to the left by 'd'
      * places using the reversal algorithm:
      * 1. The rotation distance 'd' is taken modulo the length of the array 'n' to
      * handle cases where 'd' is larger than 'n'.
      * 2. Reverse the first 'd' elements.
      * Example: For 'd' = 2, reverse first 2 elements: [2, 4, 8, 10, 15] becomes [4,
      * 2, 8, 10, 15].
      * 3. Reverse the remaining elements from 'd' to 'n-1'.
      * Example: Reverse from index 2 to end: [4, 2, 8, 10, 15] becomes [4, 2, 15,
      * 10, 8].
      * 4. Reverse the entire array.
      * Example: Reverse entire array: [4, 2, 15, 10, 8] becomes [8, 10, 15, 2, 4].
      * This achieves the rotation as the first 'd' elements are moved to the end,
      * and
      * the rest are shifted to the beginning.
      * 
      * Time Complexity: O(d) + O(n-d) + O(n) = O(2n) = O(n) - Each element is processed a constant number of times.
      * Space Complexity: O(1) - No extra space is required beyond the input array.
      */
}
