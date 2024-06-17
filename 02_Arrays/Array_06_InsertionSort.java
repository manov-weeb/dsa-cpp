public class Array_06_InsertionSort {
     public static void main(String args[]) {
          int arr[] = { 19, 12, 76, -12, 4, 8, -90 };

          System.out.print("Unsorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

          insertionSort(arr);

          System.out.println();
          System.out.print("Sorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

     }

     public static void insertionSort(int arr[]) {
          int n = arr.length;

          for (int i = 1; i < n; i++) {
               int key = arr[i];
               int j = i -1;

               while (j>=0 && arr[j] > key) {
                    arr[j+1] = arr[j];
                    

               }



          }
     }
}
