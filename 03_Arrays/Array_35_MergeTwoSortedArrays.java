import java.util.Arrays;

public class Array_35_MergeTwoSortedArrays {
     public static void main(String args[]) {
          int[] arr1 = { 1, 3, 5, 7 };
          int[] arr2 = { 2, 4, 6, 8 };

          gapMethod(arr1, arr2);

          System.out.println("Merged and sorted arr1: " + Arrays.toString(arr1));
          System.out.println("Merged and sorted arr2: " + Arrays.toString(arr2));
     }

     public static void merge(int[] arr1, int[] arr2) {
          int n = arr1.length, m = arr2.length;
          int left = n - 1, right = 0;

          // Swap elements to maintain sorted order
          while (left >= 0 && right < m) {
               if (arr1[left] > arr2[right]) {
                    int temp = arr1[left];
                    arr1[left] = arr2[right];
                    arr2[right] = temp;
                    left--;
                    right++;
               } else {
                    break;
               }
          }

          // Sort both arrays after swapping
          Arrays.sort(arr1);
          Arrays.sort(arr2);
     }

     public static void gapMethod(int arr1[], int arr2[]) {
          int n = arr1.length, m = arr2.length;
          int gap = (n + m + 1) / 2;

          while (gap > 0) {
               for (int left = 0; left + gap < n + m; left++) {
                    int right = left + gap;

                    if (left < n && right < n) {
                         if (arr1[left] > arr1[right]) {
                              int temp = arr1[left];
                              arr1[left] = arr1[right];
                              arr1[right] = temp;
                         }
                    } else if (left >= n && right >= n) {
                         if (arr2[left - n] > arr2[right - n]) {
                              int temp = arr2[left - n];
                              arr2[left - n] = arr2[right - n];
                              arr2[right - n] = temp;
                         }
                    } else if (left < n && right >= n) {
                         if (arr1[left] > arr2[right - n]) {
                              int temp = arr1[left];
                              arr1[left] = arr2[right - n];
                              arr2[right - n] = temp;
                         }
                    }
               }

               if(gap==1) break;

               gap = gap / 2 + gap % 2;
          }
     }
}
