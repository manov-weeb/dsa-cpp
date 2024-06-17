public class Array_02_Reversing {

     public static void reverseIteratively(int arr[]) {
          int n = arr.length;

          for (int i = 0; i < n / 2; i++) {
               int temp = arr[i];
               arr[i] = arr[n - i - 1];
               arr[n - i - 1] = temp;

          }

     }

     public static void reverseRecursively(int arr[], int start, int end) {
          if (start >= end) {
               return;
          }

          int temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;

          reverseRecursively(arr, start + 1, end - 1);
     }

     public static void main(String args[]) {
          int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };

          System.out.print("Before Reversing: ");
          for (int i : arr) {
               System.out.print(i + " ");

          }
          System.out.println();

          reverseIteratively(arr);

          System.out.print("After Reversing: ");
          for (int i : arr) {
               System.out.print(i + " ");

          }
          System.out.println();

          reverseRecursively(arr, 0, arr.length - 1);
          System.out.print("Again Reversing Recursively: ");
          for (int i : arr) {
               System.out.print(i + " ");

          }

     }

}
