public class Array_04_BubbleSort {
     public static void bubbleSort(int arr[]) {
          int n = arr.length;
  
          for (int i = 0; i < n - 1; i++) {
              for (int j = 0; j < n - i - 1; j++) { 
                  if (arr[j] > arr[j + 1]) {
                     
                      int temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
      }

     public static void main(String args[]) {
          int arr[] = { 19, 12, 76, -12, 4, 8, -90 };

          System.out.print("Unsorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

          bubbleSort(arr);

          System.out.println();
          System.out.print("Sorted Array: ");
          for (int i : arr) {
               System.out.print(i + " ");
          }

     }

}
