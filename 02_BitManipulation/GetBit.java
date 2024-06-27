public class GetBit {

     public static void main(String args[]) {
          int num = 9; // Number to check the bit from (binary: 1001)
          int position = 5; // Bit position to check (0-based index)

          // Create a mask by shifting 1 to the left by the position
          int mask = 1 << position;

          // Perform AND operation to isolate the bit at the desired position
          int andOperation = num & mask;

          // Check if the bit is 0 or 1
          if (andOperation == 0) {
               System.out.println("The bit at position " + position + " (" + (position + 1) + "th bit) is 0");
          } else {
               System.out.println("The bit at position " + position + " (" + (position + 1) + "th bit) is 1");
          }
     }
}

/*
 * Explanation:
 * Get Bit Operation is used to determine the bit at a specific position in a
 * number.
 * 
 * Steps:
 * 1. Create a mask by left-shifting 1 by the desired bit position.
 * Example: For position 5, mask = 1 << 5 which is 100000 (binary).
 * 2. Use the AND (&) operation between the original number and the mask.
 * This operation isolates the bit at the specified position.
 * 3. If the result of the AND operation is 0, the bit is 0; otherwise, it's 1.
 * 
 * Details:
 * - Left shifting 1 by 'position' places a 1 at the desired bit position.
 * - The AND operation results in a number where only the bit at the specified
 * position might be 1, and all other bits are 0.
 * - If the bit in the original number at the specified position is 1, the AND
 * operation will yield a non-zero value. Otherwise, it yields 0.
 */
