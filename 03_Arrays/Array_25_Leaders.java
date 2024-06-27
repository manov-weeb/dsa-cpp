import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array_25_Leaders {
     public static void main(String args[]) {

          int arr[] = {1, 2, 3, 2};
          int result[] = solution(arr);
          for (int i : result) {
               System.out.print(i + " ");
          }

     }

     public static int[] solution(int arr[]) {
          int n = arr.length;
          List<Integer> maxList = new ArrayList<>();
          int maximum = Integer.MIN_VALUE;
          

          for (int i = n - 1; i >= 0; i--) {
               if (arr[i] > maximum) {
                    maximum = arr[i];
                    maxList.add(maximum);
               }
          }

          Collections.reverse(maxList);

          int result[] = new int[maxList.size()];

          for (int i = 0; i < result.length; i++) {
               result[i] = maxList.get(i);

          }

          if (result.length > 0)
               return result;

          return new int[] { -1, -1 };
     }
}
