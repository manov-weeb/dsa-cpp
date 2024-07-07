import java.util.ArrayList;

public class Array_37_MergeSort {

     public static void main(String args[]) {
          int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
          System.out.println("Original array: ");
          printArray(arr);
  
          mergeSort(arr, 0, arr.length - 1);
  
          System.out.println("\nSorted array: ");
          printArray(arr);
     }

     public static void mergeSort(int arr[], int start, int end) {
          if (start < end) {
               int mid = (start + end) / 2;

               mergeSort(arr, start, mid);
               mergeSort(arr, mid + 1, end);

               merge(arr, start, mid, end);

          }

     }

     private static void merge(int arr[], int start, int mid, int end) {
          ArrayList<Integer> temp = new ArrayList<>();

          int left = start;
          int right = mid + 1;

          while (left <= mid && right <= end) {
               if (arr[left] <= arr[right])
                    temp.add(arr[left++]);
               else
                    temp.add(arr[right++]);

          }

          while (left<=mid) {
               temp.add(arr[left++]);
          }
          while (right <= end) {
               temp.add(arr[right++]);
          }

          for (int i = 0; i <temp.size(); i++) {
               arr[start+i] = temp.get(i);
          }
     }

     public static void printArray(int[] arr) {
          for (int i = 0; i < arr.length; i++) {
              System.out.print(arr[i] + " ");
          }
          System.out.println();
      }
}
