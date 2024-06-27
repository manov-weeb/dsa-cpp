public class ClearBit {
     public static void main(String args[]) {
         int number = 5;    // Number from which to clear the bit (binary: 101)
         int position = 0;  // Bit position to clear (0-based index)
 
         // Create a mask by shifting 1 to the left by the position
         // and then applying NOT to invert bits
         int mask = ~(1 << position);
 
         // Perform AND operation to clear the bit at the desired position
         int clearBit = number & mask;
 
         // Output the result
         System.out.println(
                 "Number " + number + " with the bit at position " + position + " cleared results in " + clearBit);
     }
 }
 
 /*
  * Explanation:
  * 1) To perform the Clear Bit operation, first we create a mask.
  * 2) The mask is created by left-shifting 1 by 'n' positions, where 'n' is
  *    the position of the bit we want to clear.
  * 3) We then invert this mask using the bitwise NOT operator (~). This flips
  *    all bits, so the bit at the desired position becomes 0, and all other bits become 1.
  * 4) Finally, we perform an AND (&) operation between the number and the inverted mask.
  * 
  * Details:
  * - The left shift operation moves the single '1' in the binary representation
  *   to the correct bit position.
  * - Inverting this result using NOT creates a mask with '0' at the bit position
  *   we want to clear and '1's elsewhere.
  * - The AND operation will zero out the bit at the desired position, while leaving
  *   all other bits unchanged.
  * 
  * Example:
  * - For number 5 (binary: 101) and position 0:
  *   - Left shift 1 by 0:       1 << 0 -> 0001
  *   - Invert bits (NOT):       ~0001 -> 1110
  *   - AND with number:     0101 & 1110 -> 0100 (binary) = 4 (decimal)
  * - The bit at position 0 is cleared, resulting in 4.
  */
 