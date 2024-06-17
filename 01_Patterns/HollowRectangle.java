
public class HollowRectangle {
     public static void main(String args[]) {
          int rows = 5, columns = 4;
          for (int i = 1; i <= rows; i++) {
               for (int j = 1; j <= columns; j++) {
                    if (j==1 || j == columns) {
                         System.out.print(" * ");
                    } else if(i==1 || i ==rows){
                         System.out.print(" * ");
                    } else { 
                         System.out.print("   ");
                    }
               }

               System.out.println();

          }

     }
}
