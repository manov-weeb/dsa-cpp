import java.util.Scanner;

public class UpdateBit {
     public static void main(String args[]) {
          Scanner scanner = new Scanner(System.in);

          // Prompt the user to enter the new bit value
          System.out.print("Change the Bit to? (0 or 1): ");
          int updateTo = scanner.nextInt();

          // The number to update the bit in and the bit position to update
          int number = 7;
          int position = 4;

          // Check the input and perform the appropriate bit update
          if (updateTo == 1) {
               // Create a mask with a 1 at the desired bit position
               int mask = 1 << position;
               // Perform OR operation to set the bit
               int result = mask | number;

               System.out.println("Updating the bit to 1 at position " + position + " results in: " + result);
          } else if (updateTo == 0) {
               // Create a mask with a 0 at the desired bit position by negating a 1 shifted to
               // that position
               int mask = ~(1 << position);
               // Perform AND operation to clear the bit
               int result = mask & number;

               System.out.println("Updating the bit to 0 at position " + position + " results in: " + result);
          } else {
               System.out.println("Invalid input! Please enter 0 or 1.");
          }

          // Close the scanner
          scanner.close();
     }
}

/*
 * Explanation:
 * When we need to Set the Bit to 0, we perform 'Clear Bit' and when we need to
 * Set the Bit to 1, we perform 'Set Bit'
 */