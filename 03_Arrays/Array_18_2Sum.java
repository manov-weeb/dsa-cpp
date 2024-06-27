import java.util.*;

public class Array_18_2Sum {
     public static void main(String args[]) {
          int arr[] = { 2, 6, 5, 8, 11 };
          int result[] = optimalApproach(arr, 14);

          System.out.println(result[0] + " " + result[1]);
     }

     public static int[] bruteForce(int arr[], int k) {
          int n = arr.length;

          for (int i = 0; i < n; i++) {
               for (int j = i + 1; j < n; j++) {
                    if (arr[i] + arr[j] == k) {
                         return new int[] { i, j };
                    }
               }
          }

          int result[] = { -1, -1 };

          return result;
     }

     public static int[] betterApproach(int arr[], int k) {
          int n = arr.length;
          Map<Integer, Integer> map = new HashMap<>();

          for (int i = 0; i < n; i++) {
               int complement = k - arr[i];
               if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };

               }

               map.put(arr[i], i);
          }

          return new int[] { -1, -1 };
     }

     public static int[] optimalApproach(int arr[], int k) {
          int n = arr.length;
          int i = 0, j = n - 1;

          while (i < j) {
               int sum = arr[i] + arr[j];
               if (sum > k)
                    j = j - 1;

               if (sum < k)
                    i = i + 1;

               if(sum == k) return new int[]{i, j};

          }

          return new int[] {-1, -1};
     }

}
