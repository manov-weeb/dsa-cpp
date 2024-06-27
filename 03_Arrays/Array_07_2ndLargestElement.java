
public class Array_07_2ndLargestElement {
     public static void main(String args[]) {
          int arr[] = { 7, 1, 4, 2, 7, 5 };

          System.out.println("Second largest in array is: " + secondLargestOptimal(arr));
     }

     public static int secondLargest(int arr[]) {
          int n = arr.length;

          if (n < 2) {
               System.out.println("The array has only one element!");
               return Integer.MIN_VALUE;
          }

          int largest = arr[0];

          for (int i = 0; i < n; i++) {
               if (arr[i] > largest) {
                    largest = arr[i];
               }
          }

          int secondLargest = Integer.MIN_VALUE;

          for (int i = 0; i < n; i++) {
               if (arr[i] > secondLargest && arr[i] != largest) {
                    secondLargest = arr[i];
               }

          }

          return secondLargest;
     }

     public static int secondLargestOptimal(int arr[]) {
          int n = arr.length;

          if (n < 2) {
               System.out.println("The array has only one element!");
               return Integer.MIN_VALUE;
          }

          int largest = arr[0];
          int secondLargest = Integer.MIN_VALUE;

          for (int i = 1; i < n; i++) {
               if (arr[i] > largest) {
                    secondLargest = largest;
                    largest = arr[i];
               } else if(arr[i] > secondLargest && arr[i] < largest){
                    secondLargest = arr[i];
               }

          }

          return secondLargest;

     }
}