public class Array_29_SprialTraversal {
     public static void main(String agrs[]) {
          int arr[][] = {{1 , 2 , 3 , 4,  5 , 6},
              { 20 ,21, 22, 23, 24, 7},
             {  19 ,32 ,33, 34, 25, 8},
             {  18, 31, 36, 35, 26, 9},
               {17 ,30 ,29 ,28 ,27 ,10},
              { 16 ,15, 14, 13, 12, 11 }};

              solution(arr);
     }

     public static void solution(int arr[][]) {
          int n = arr.length;
          int m = arr[0].length;

          int top = 0, bottom = n - 1;
          int left = 0, right = m - 1;

           // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
          // Traverse from left to right along the top row
          for (int i = left; i <= right; i++) {
              System.out.print(arr[top][i] + " ");
          }
          top++; // Move the top boundary down

          // Traverse from top to bottom along the right column
          for (int i = top; i <= bottom; i++) {
              System.out.print(arr[i][right] + " ");
          }
          right--; // Move the right boundary left

          // Traverse from right to left along the bottom row (if within bounds)
          if (top <= bottom) {
              for (int i = right; i >= left; i--) {
                  System.out.print(arr[bottom][i] + " ");
              }
              bottom--; // Move the bottom boundary up
          }

          // Traverse from bottom to top along the left column (if within bounds)
          if (left <= right) {
              for (int i = bottom; i >= top; i--) {
                  System.out.print(arr[i][left] + " ");
              }
              left++; // Move the left boundary right
          }
      }
  }
}