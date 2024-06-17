public class Butterfly {
     public static void main(String[] args) {
         int n = 4; // Number of rows for the upper or lower half
 
         // Upper Half
         for (int i = 1; i <= n; i++) {
             // Left stars
             for (int j = 1; j <= i; j++) {
                 System.out.print("* ");
             }
 
             // Spaces
             int spaces = 2 * (n - i);
             for (int j = 1; j <= spaces; j++) {
                 System.out.print("  ");
             }
 
             // Right stars
             for (int j = 1; j <= i; j++) {
                 System.out.print("* ");
             }
 
             System.out.println();
         }
 
         // Lower Half
         for (int i = n; i >= 1; i--) {
             // Left stars
             for (int j = 1; j <= i; j++) {
                 System.out.print("* ");
             }
 
             // Spaces
             int spaces = 2 * (n - i);
             for (int j = 1; j <= spaces; j++) {
                 System.out.print("  ");
             }
 
             // Right stars
             for (int j = 1; j <= i; j++) {
                 System.out.print("* ");
             }
 
             System.out.println();
         }
     }
 }
 