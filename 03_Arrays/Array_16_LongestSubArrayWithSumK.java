import java.util.HashMap;
import java.util.Map;

public class Array_16_LongestSubArrayWithSumK {
     public static void main(String args[]) {
          int arr[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
          int k = 7;

          System.out.println(bruteForce(arr, k));

     }

     public static int bruteForce(int arr[], int k) {

          int longest = 0;
          for (int i = 0; i < arr.length; i++) {
               int sum = 0;
               for (int j = i; j < arr.length; j++) {

                    sum += arr[j];
                    if (sum == k) {

                         longest = Math.max(j - i + 1, longest);
                    } else if (sum > k) {
                         break;
                    }

               }

          }

          return longest;
     }

}
