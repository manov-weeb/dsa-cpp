public class Array_19_Sort012s {
     public static void main(String args[]) {
          int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
          dutchNationalFlag(arr);

          for (int i : arr) {
               System.out.print(i + " ");
          }
     }

     public static void dutchNationalFlag(int arr[]) {
          int low = 0, mid = 0, high = arr.length - 1;

          while (mid <= high) {
               if (arr[mid] == 0) {
                    swap(arr, low++, mid++);
               } else if (arr[mid] == 1) {
                    mid++;
               } else {
                    swap(arr, mid, high--); 
               }
          }
     }

     // Swaps elements at index i and j in the array
     public static void swap(int[] arr, int i, int j) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
     }
}