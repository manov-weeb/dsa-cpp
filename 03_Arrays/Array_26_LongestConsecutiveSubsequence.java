import java.util.*;

public class Array_26_LongestConsecutiveSubsequence {
     public static void main(String args[]) {
          int arr[] = { 102, 4, 100, 103, 104, 1, 101, 3, 2, 1, 1, 105, 106 };
          System.out.println(optimalSolution(arr));
     }

     public static int bruteForce(int arr[]) {
          int n = arr.length;
          int longest = 1;

          for (int i = 0; i < n; i++) {
               int count = 1;
               int x = arr[i];
               System.out.println("Starting with " + x);

               while (linearSearch(arr, x + 1)) {

                    x = x + 1;
                    count = count + 1;
               }

               longest = Math.max(count, longest);

          }

          return longest;
     }

     public static int betterSolution(int arr[]) {
          int n = arr.length;

          if (n == 0)
               return 0;

          Arrays.sort(arr);
          int longest = 1, currentCount = 1;

          for (int i = 1; i < n; i++) {
               if (arr[i] != arr[i - 1]) {
                    if (arr[i] == arr[i - 1] + 1) {
                         currentCount++;
                    } else {
                         longest = Math.max(currentCount, longest);
                         currentCount = 1;
                    }

               }

          }

          return Math.max(longest, currentCount);
     }

     public static int optimalSolution(int arr[]) {
          int n = arr.length;

          if (n == 0 || n == 1)
               return n;

          int longest = 1;

          HashSet<Integer> set = new HashSet<>();

          for (int elem : arr) {
               set.add(elem);

          }

          for (int it : set) {
               if (!set.contains(it - 1)) {
                    int count = 1;
                    int x = it;

                    while (set.contains(x + 1)) {
                         x = x + 1;
                         count++;
                    }

                    longest = Math.max(count, longest);

               }
          }

          return longest;
     }

     private static boolean linearSearch(int arr[], int elem) {
          for (int i : arr) {
               if (i == elem)
                    return true;

          }

          return false;
     }
}
