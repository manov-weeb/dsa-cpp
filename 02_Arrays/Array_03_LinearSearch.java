import java.util.Scanner;

public class Array_03_LinearSearch {

     public static int LinearSearch(int arr[], int element) {
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == element) {
                    return i;
               }

          }

          return -1;
     }

     public static void main(String args[]) {
          int arr[] = { 12, 19, 18, 17, 29, 40, 41 };
          Scanner scanner = new Scanner(System.in);

          System.out.print("Enter the element you want to search for: ");
          int element = scanner.nextInt();
          System.out.println();

          int index = LinearSearch(arr, element);

          if (index == -1) {
               System.out.println(element + " doesn't exists in the array");
          } else {
               System.out.println(element + " found at  index " + index + " in the array");
          }

          scanner.close();

     }

}
