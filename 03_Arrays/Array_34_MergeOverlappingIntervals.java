import java.util.*;

public class Array_34_MergeOverlappingIntervals {
     public static void main(String[] args) {
          int[][] intervals = {
                    { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
          };

          List<List<Integer>> result = optimalSolution(intervals);
          System.out.println("Merged intervals : " + result);
     }

     public static List<List<Integer>> bruteForce(int[][] intervals) {
          List<List<Integer>> result = new ArrayList<>();
          int n = intervals.length;

          // Sort the intervals based on the start time
          Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

          for (int i = 0; i < n; i++) {
               int start = intervals[i][0];
               int end = intervals[i][1];

               // Check for overlap and merge intervals
               for (int j = i + 1; j < n; j++) {
                    if (intervals[j][0] <= end) {
                         end = Math.max(end, intervals[j][1]);
                         i = j; // Update i to skip the merged intervals
                    } else {
                         break;
                    }
               }

               result.add(Arrays.asList(start, end));
          }

          return result;
     }

     public static List<List<Integer>> optimalSolution(int arr[][]) {
          List<List<Integer>> result = new ArrayList<>();
        

          Arrays.sort(arr, new Comparator<int[]>() {
               public int compare(int a[], int b[]) {
                    return a[0] - b[0];
               }
          });

          for (int i = 0; i < arr.length; i++) {
               if (result.isEmpty() ||arr[i][0] > result.get(result.size() - 1).get(1)) {
                    result.add(Arrays.asList(arr[i][0], arr[i][1]));
               } else {
                    result.get(result.size() - 1).
                    set(1, Math.max(result.get(result.size() - 1).get(1), arr[i][1]));
               }
          }

          return result;
     }
}
