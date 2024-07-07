public class Array_31_PascalsTriangle {
     public static void main(String args[]) {

          int[][] triangle = getPascalsTriangle(14);
          for (int[] row : triangle) {
              System.out.println(java.util.Arrays.toString(row));
          }
     }

     // Given the Row Number and Column Number, print the element at that place
     public static int getElement(int row, int column) {
          /*
           * we know to get the element from a pascal triangle
           * we can use n(C)r formula, where n = rows -1 and r = columns - 1
           */

          int element = 1;
          int n = row - 1, r = column - 1;
          for (int i = 0; i <= r; i++) {
               element = element * (n - i);
               element = element / (i + 1);

          }

          return element;
     }

     // Given The Row Number, print that whole row
     public static int[] getRow(int row) {
          int[] result = new int[row];
          result[0] = 1; // First element is always 1
          int element = 1;
          for (int i = 1; i < row; i++) {
              element = element * (row - i) / i;
              result[i] = element;
          }
          return result;
      }

     // Given the value of N, Print the Whole Pascal Triangle
     public static int[][] getPascalsTriangle(int numRows){
          int [][] triangle = new int[numRows][];

          for (int i = 0; i < numRows; i++) {
               triangle[i] = getRow(i+1);
          }

          return triangle;
     }

}
