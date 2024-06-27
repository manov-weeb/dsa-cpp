public class SetBit {
     public static void main(String args[]) {
          int number = 6; // Example number (binary: 110)
          int position = 4; // Bit position to set (0-based index)

          // Create a mask by shifting 1 to the left by the position
          int mask = 1 << position;

          // Perform OR operation with the mask to set the bit at the desired position
          int setBit = number | mask;

          System.out.println(
                    "Number " + number + " with the bit at position " + position + " set results in " + setBit);
     }
}

/*
 * Explanation:
 * The "Set Bit" operation refers to setting the bit at a specific position to
 * 1.
 * 
 * Steps:
 * 1. Create a mask by left-shifting 1 by the desired bit position.
 * Example: For position 4, mask = 1 << 4 which is 10000 (binary).
 * 2. Use the OR (|) operation between the original number and the mask.
 * This operation sets the bit at the specified position to 1 without affecting
 * other bits.
 * 3. The result is a new number with the bit at the specified position set to
 * 1.
 * 
 * Details:
 * - In binary, shifting 1 to the left by n positions creates a number with a
 * single 1 at the nth position and 0s elsewhere.
 * - The OR operation sets the target bit to 1 because `0 | 1` results in `1`
 * and `1 | 0` results in `1`.
 */
