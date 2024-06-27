public class Array_05_SelectionSort {
     public static void main(String args[]) {
          int arr[] = { 19, 12, 76, -12, 4, 8, -90 };

          System.out.print("Unsorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

          selectionSort(arr);

          System.out.println();
          System.out.print("Sorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

     }

     public static void selectionSort(int arr[]) {
          int n = arr.length;

          for (int i = 0; i < n - 1; i++) {
               int minIndex = i;

               for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                         minIndex = j;
                    }

               }

               if (minIndex != i) {
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[i];
                    arr[i] = temp;

               }

          }
     }
}
