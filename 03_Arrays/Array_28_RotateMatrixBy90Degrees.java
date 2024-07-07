public class Array_28_RotateMatrixBy90Degrees {
     public static void  main(String args[]){
          int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

         optimalSolution(arr);

          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + "   ");
               }
               System.out.println();
          }
     }

      // Brute force approach: Create a new matrix to store the rotated version
      public static int[][] bruteForce(int arr[][]) {
          int n = arr.length, m = arr[0].length;

          // Create a new matrix to store the rotated result
          int result[][] = new int[n][m];

          // Fill the result matrix with rotated values
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    result[j][n - 1 - i] = arr[i][j];
               }
          }

          // Return the result matrix
          return result;
     }

     // Optimal solution: Rotate the matrix in-place
     public static void optimalSolution(int arr[][]) {
          // Step 1: Transpose the matrix
          transpose(arr);

          // Step 2: Reverse each row of the transposed matrix
          for (int i = 0; i < arr.length; i++) {
               reverse(arr[i]);
          }
     }

     // Reverse a single-dimensional array
     private static void reverse(int arr[]) {
          int start = 0;
          int end = arr.length - 1;

          // Swap elements from start to end to reverse the array
          while (start <= end) {
               int temp = arr[start];
               arr[start] = arr[end];
               arr[end] = temp;

               start++;
               end--;
          }
     }

     // Transpose the matrix
     private static void transpose(int arr[][]) {
          for (int i = 0; i < arr.length; i++) {
               for (int j = i + 1; j < arr[0].length; j++) {
                    // Swap arr[i][j] and arr[j][i]
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
               }
          }
     }
}