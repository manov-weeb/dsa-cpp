import java.util.HashMap;

public class Array_33_SubArraysWithXorK {
     public static void main(String args[]) {
          int[] arr = { 4, 2, 2, 6, 4 }; // Example array
          int k = 6; // Example k
          int count = optimalSolution(arr, k);
          System.out.println("Number of subarrays with XOR equal to " + k + ": " + count);

     }

     public static int bruteForce(int arr[], int k) {
          int count = 0;

          for (int i = 0; i < arr.length; i++) {
               int currentXOR = 0;
               for (int j = i; j < arr.length; j++) {
                    currentXOR ^= arr[j];
                    if (currentXOR == k) {
                         count++;
                    }
               }
          }

          return count;

     }

     public static int optimalSolution(int arr[], int k) {
          int count = 0;
          int prefixXOR = 0;

          HashMap<Integer, Integer> map = new HashMap<>();

          map.put(0, 1);

          for (int i = 0; i < arr.length; i++) {
               prefixXOR ^= arr[i];

               int requiredXOR = k ^ prefixXOR;

               if (map.containsKey(requiredXOR)) {
                    count += map.get(requiredXOR);
               }

               map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
          }

          return count;

     }
}
