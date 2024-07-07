import java.util.*;

public class Array_32_MajorityElementII {

     public static void main(String args[]) {
          int arr[] = { 1, 2, 3, 1, 1, 2, 2, 2, 3, 3, 3, 3, 2, 2 };
          int result[] = mooresVotingAlgorithm(arr);
          System.out.println(java.util.Arrays.toString(result));
     }

     public static int[] bruteForce(int arr[]) {
          int n = arr.length;
          // ArrayList to store results dynamically
          ArrayList<Integer> result = new ArrayList<>();

          for (int i = 0; i < n; i++) {
               // Skip this element if it is already in the result list
               if (result.contains(arr[i]))
                    continue;

               int count = 0;
               // Count occurrences of arr[i] in the array
               for (int j = 0; j < n; j++) {
                    if (arr[j] == arr[i])
                         count++;
               }
               // Check if the count exceeds n/3
               if (count > n / 3) {
                    result.add(arr[i]); // Add the element to the result if it qualifies
               }

               if (result.size() == 2) {
                    break;
               }
          }

          // Convert result to array before returning
          int[] resultArray = new int[result.size()];
          for (int i = 0; i < result.size(); i++) {
               resultArray[i] = result.get(i);
          }
          return resultArray;
     }

     public static int[] usingMap(int arr[]) {
          int n = arr.length;
          // ArrayList to store results dynamically
          ArrayList<Integer> result = new ArrayList<>();
          HashMap<Integer, Integer> map = new HashMap<>();

          int mini = (int) (n / 3) + 1;

          for (int i = 0; i < n; i++) {
               int value = map.getOrDefault(arr[i], 0);
               map.put(arr[i], value + 1);

               if (map.get(arr[i]) == mini) {
                    result.add(arr[i]);
               }

               if (result.size() == 2)
                    break;
          }

          int[] resultArray = new int[result.size()];
          for (int i = 0; i < result.size(); i++) {
               resultArray[i] = result.get(i);
          }
          return resultArray;
     }

     public static int[] mooresVotingAlgorithm(int arr[]) {
          int counter1 = 0, counter2 = 0;
          int elem1 = Integer.MIN_VALUE, elem2 = Integer.MIN_VALUE;

          for (int i = 0; i < arr.length; i++) {
               if (counter1 == 0 && elem2 != arr[i]) {
                    counter1 = 1;
                    elem1 = arr[i];
               } else if (counter2 == 0 && elem1 != arr[i]) {
                    counter2 = 1;
                    elem2 = arr[i];
               } else if (arr[i] == elem1)
                    counter1++;
               else if (arr[i] == elem2)
                    counter2++;
               else {
                    counter1--;
                    counter2--;
               }

          }

          int result[] = new int[2];

          counter1 = 0;
          counter2 = 0;
          for (int i = 0; i < arr.length; i++) {
               if (elem1 == arr[i])
                    counter1++;
               if (elem2 == arr[i])
                    counter2++;
          }

          int mini = (int) (arr.length / 3) ;

          if (counter1 > mini)
               result[0] = elem1;

          if (counter2 > mini)
               result[1] = elem2;

          return result;
     }
}
