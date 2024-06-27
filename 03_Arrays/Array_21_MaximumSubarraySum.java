public class Array_21_MaximumSubarraySum {
     public static void main(String args[]) {
          int arr[] = { -2, -3, -4, -1, -2, -1, -5, -3 };

          // int result[] = bruteForce(arr);

          // for (int i : result) {
          // System.out.print(i + " ");
          // }

          System.out.println(kadanesAlgorithm(arr));

     }

     public static int[] bruteForce(int arr[]) {
          int n = arr.length;
          int maxSum = Integer.MIN_VALUE;
          int start = 0, end = 0;

          for (int i = 0; i < n; i++) {
               int sum = 0;
               for (int j = i; j < n; j++) {
                    sum += arr[j];
                    if (sum > maxSum) {
                         maxSum = sum;
                         start = i;
                         end = j;
                    }

               }

          }

          int result[] = new int[(end - start) + 1];

          for (int i = start; i <= end; i++) {
               result[i - start] = arr[i];

          }
          System.out.println("The maximum sum is: " + maxSum);
          return result;

     }

     public static int kadanesAlgorithm(int arr[]) {
          int n = arr.length;
          int maxSum = Integer.MIN_VALUE, start = 0;
          int sum = 0, resultStart = -1, resultEnd = -1;

          for (int i = 0; i < n; i++) {
               if (sum == 0)
                    start = i;

               sum += arr[i];

               if (sum > maxSum) {
                    maxSum = sum;
                    resultStart = start;
                    resultEnd = i;

               }
               if (sum < 0) {
                    sum = 0;
               }

          }
          System.out.print("[ ");
          for (int i = resultStart; i <= resultEnd; i++) {

               System.out.print(arr[i] + " ");

          }
          System.out.print(" ] ");
          System.out.println();
          return maxSum;
     }
}
