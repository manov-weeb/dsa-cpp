import java.util.Scanner;

public class Array_04_BinarySearch {
     public static int BinarySearch(int arr[], int element) {
          int low = 0, high = arr.length - 1, mid;
          while (low <= high) {
               mid = (low) + (high - low) / 2;

               if (arr[mid] == element) {
                    return mid;
               } else if (arr[mid] > element) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return -1;
     }

     public static int BinarySearchRecursive(int arr[], int element, int low, int high) {
          if (low > high) {
               return -1;
          }

          int mid = low + (high - low) / 2;

          if (arr[mid] == element)
               return mid;

          if (arr[mid] > element) {

               return BinarySearchRecursive(arr, element, low, mid - 1);
          } else {
               return BinarySearchRecursive(arr, element, mid + 1, high);
          }

     }

     public static void main(String args[]) {
          int arr[] = { 12, 17, 18, 19, 29, 40, 41 };
          Scanner scanner = new Scanner(System.in);

          System.out.print("Enter the element you want to search for: ");
          int element = scanner.nextInt();
          System.out.println();

          int index = BinarySearch(arr, element);

          if (index == -1) {
               System.out.println(element + " doesn't exists in the array");
          } else {
               System.out.println(element + " found at index " + index + " in the array");
          }

          System.out.print("Enter the element you want to search for(Recursive): ");
          element = scanner.nextInt();
          System.out.println();

          index = BinarySearchRecursive(arr, element, 0, arr.length - 1);

          if (index == -1) {
               System.out.println(element + " doesn't exists in the array");
          } else {
               System.out.println(element + " found at  index " + index + " in the array");
          }

          scanner.close();

     }

}
