public class Array_22_RearrangeBySign {

     public static void main(String args[]) {
          int arr[] = { -2, -3, 4, -1, 2, -1, 5, 3 };

          optimalApproach(arr);
          for (int i : arr) {
               System.out.print(i + " ");
          }

     }

     public static void bruteForce(int arr[]) {
          int n = arr.length;
          int[] positives = new int[n / 2];
          int[] negatives = new int[n / 2];

          for (int i = 0, j = 0, k = 0; i < n; i++) {
               if (arr[i] > 0) {
                    positives[j++] = arr[i];
               } else {
                    negatives[k++] = arr[i];
               }

          }

          for (int i = 0; i < (n / 2); i++) {
               arr[2 * i] = positives[i];
               arr[2 * i + 1] = negatives[i];

          }

     }

     public static void optimalApproach(int arr[]) {
          int n = arr.length;

          int result[] = new int[n];

          int pos = 0, neg = 1;

          for (int i = 0; i < n; i++) {

               if (arr[i] > 0) {
                    result[pos] = arr[i];
                    pos = pos + 2;
               }

               else {
                    result[neg] = arr[i];
                    neg = neg + 2;
               }

          }


          
          System.arraycopy(result, 0, arr, 0, n);
     
     }
}
