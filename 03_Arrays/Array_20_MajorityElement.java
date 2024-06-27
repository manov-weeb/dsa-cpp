import java.util.HashMap;
import java.util.Map;

public class Array_20_MajorityElement {
     public static void main(String[] args) {
          int[] arr = { 2, 2, 1, 3, 1, 1, 2, 1, 1 };
          int majorityElement = mooresVotingAlgorithm(arr);
          System.out.println("The majority element is: " + majorityElement);
     }

     public static int usingMap(int arr[]) {
          int n = arr.length;
          Map<Integer, Integer> map = new HashMap<>();

          for (int i = 0; i < n; i++) {
               map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

          }

          for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
               if (entry.getValue() > n / 2) {
                    return entry.getKey(); // Return the majority element
               }
          }

          // If no majority element found
          return -1; // Indicates no majority element
     }

     public static int mooresVotingAlgorithm(int arr[]) {
          int n = arr.length;

          int count = 0;
          int element = -1;

          // find the element that occurs most.
          for (int i = 0; i < n; i++) {
               if (count == 0) {
                    count = 1;
                    element = arr[i];
               } else if (arr[i] == element) {
                    count++;
               } else {
                    count--;
               }

          }

          // check if it occurs more than (n/2) times
          int counter = 0;
          for (int i : arr) {
               if (i == element)
                    counter++;
          }

          if(counter>(n/2))  return element;

          return -1;

         
     }
}
