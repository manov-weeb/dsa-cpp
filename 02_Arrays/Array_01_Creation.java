import java.util.Scanner;

public class Array_01_Creation {
     public static void main(String[] args) {
          Scanner scannner = new Scanner(System.in);
          System.out.println("Enter the size of the array: ");

          int size = scannner.nextInt();

          int[] arr = new int[size];

          for (int i = 0; i < size; i++) {
               System.out.print("Enter the element for " + (i) + " index: ");
               arr[i] = scannner.nextInt();
               System.out.println("");
          }

          for(int element: arr){
               System.out.print(element + " ");

          }

          scannner.close();

     }

}
