import java.util.Scanner;

public class Rectangle {
     public static void main(String args[]) {
          Scanner scannner = new Scanner(System.in);

          System.out.print("Enter the number of rows: ");
          int rows = scannner.nextInt();

          System.out.println();

          System.out.print("Enter the number of columns: ");
          int columns = scannner.nextInt();

          for (int i = 1; i <= rows; i++) {
               // Enters the ith row and fills-
               for (int j = 1; j <= columns; j++) {
                    System.out.print(" * ");
               }
               // Change line after a column is done,
               System.out.println();

          }

          scannner.close();

     }

}
