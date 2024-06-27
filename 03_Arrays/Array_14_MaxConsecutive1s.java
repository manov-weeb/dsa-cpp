public class Array_14_MaxConsecutive1s {
     public static void main(String[] args) {
          int arr[] = { 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 };
          System.out.println(maxOnes(arr));
     }

     public static int maxOnes(int arr[]) {
          int n = arr.length;

          int count = 0, max = 0;

          for (int i = 0; i < n; i++) {
               if (arr[i] == 1) {
                    count++;
                    max = Math.max(max, count); // Update max if current count is greater
               } else {
                    count = 0; // Reset count if we encounter 0
               }
          }

          return max;
     }
}
