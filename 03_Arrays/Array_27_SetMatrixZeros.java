public class Array_27_SetMatrixZeros {
     public static void main(String args[]) {
          int arr[][] = { { 0, 1, 1, 1 },
                    { 1, 0, 1, 1 },
                    { 1, 1, 1, 1 },
                    { 1, 1, 1, 1 } };

          traverseTwoDimensional(arr);
          optimalSolution(arr);
          System.out.println();
          traverseTwoDimensional(arr);

     }

     public static void traverseTwoDimensional(int arr[][]) {

          int m = arr.length;
          int n = arr[0].length;

          for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
               }
               System.out.println();
          }
     }

     public static void bruteForce(int arr[][]) {
          int m = arr.length;
          int n = arr[0].length;

          for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                         markRow(arr, i);
                         markColumn(arr, j);
                    }
               }
          }
          for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                    if (arr[i][j] == -1) {
                         arr[i][j] = 0;
                    }
               }
          }

     }

     public static void betterSolution(int arr[][]) {
          int n = arr.length;
          int m = arr[0].length;

          boolean row[] = new boolean[n], col[] = new boolean[m];

          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                         row[i] = true;
                         col[j] = true;
                    }

               }

          }

          for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                         arr[i][j] = 0;
                    }

               }

          }
     }

     public static void optimalSolution(int arr[][]) {
          if (arr == null || arr.length == 0)
               return;

          int n = arr.length, m = arr[0].length;
          boolean firstRowZero = false, firstColZero = false;

          // Determine if first column should be zero-ed
          for (int i = 0; i < n; i++) {
               if (arr[i][0] == 0) {
                    firstColZero = true;
                    break;
               }

          }

          for (int i = 0; i < m; i++) {
               if (arr[0][i] == 0) {
                    firstRowZero = true;
                    break;
               }
          }

          for (int i = 1; i < n; i++) {
               for (int j = 1; j < m; j++) {
                    if (arr[i][j] == 0) {
                         arr[i][0] = 0;
                         arr[0][j] = 0;
                    }
               }

          }

          for (int i = 1; i < n; i++) {
               for (int j = 1; j < m; j++) {
                    if(arr[i][0] == 0 || arr[0][j] == 0){
                         arr[i][j] = 0;
                    }
               }
          }

          if (firstRowZero) {
               for (int j = 0; j < m; j++) {
                   arr[0][j] = 0;
               }
           }
   
           // Zero out the first column if needed
           if (firstColZero) {
               for (int i = 0; i < n; i++) {
                   arr[i][0] = 0;
               }
           }
     }

     private static void markRow(int arr[][], int i) {
          for (int j = 0; j < arr[0].length; j++) {
               if (arr[i][j] == 1) {
                    arr[i][j] = -1;
               }
          }
     }

     private static void markColumn(int arr[][], int j) {
          for (int i = 0; i < arr.length; i++) {
               if (arr[i][j] == 1) {
                    arr[i][j] = -1;
               }
          }
     }

}
