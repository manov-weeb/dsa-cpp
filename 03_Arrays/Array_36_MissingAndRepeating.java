public class Array_36_MissingAndRepeating {
     public static void main(String args[]) {
          int arr[] = { 4, 3, 6, 2, 2, 1 };
          int result[] = optimalSolution(arr);

          System.out.println("Repeating: " + result[0]);
          System.out.println("Missing: " + result[1]);
     }

     public static int[] bruteForce(int arr[]) {
          int n = arr.length;
          int result[] = new int[2];
          int repeating = -1;
          int missing = -1;

          for (int i = 1; i <= n; i++) {
               int count = 0;
               for (int j = 0; j < n; j++) {
                    if (arr[j] == i)
                         count++;
               }
               if (count == 2)
                    repeating = i;
               else if (count == 0)
                    missing = i;

               if (missing != -1 && repeating != -1)
                    break;

          }

          result[0] = repeating;
          result[1] = missing;

          return result;
     }

     public static int[] betterSolution(int arr[]) {
          int n = arr.length;

          if (n <= 1)
               return new int[] { -1, -1 };

          int countArray[] = new int[n + 1];
          int repeating = -1, missing = -1;

          for (int i = 0; i < n; i++) {

               countArray[arr[i]]++;

          }

          for (int i = 1; i <= n; i++) {
               if (countArray[i] == 2)
                    repeating = i;

               else if (countArray[i] == 0)
                    missing = i;

               if (repeating != -1 && missing != -1)
                    break;
          }

          return new int[] { repeating, missing };
     }

     public static int[] optimalSolution(int arr[]) {
          int n = arr.length;

          int Sn = (n*(n+1))/2, S = 0;
          int S2n = (n*(n+1)*((2*n)+1)/6), S2 =0;

          int repeating = -1, missing = -1;

          for (int i = 0; i <n; i++) {
               S += arr[i];
               S2 += arr[i] * arr[i];
               
          }

         // Difference between expected sum and actual sum
         int eq1 = S - Sn;
         // Difference between expected sum of squares and actual sum of squares
         int eq2 = S2 - S2n;

         // eq2 = repeating^2 - missing^2
        // eq1 = repeating - missing

        // Rearrange equations to find repeating and missing
        eq2 = eq2 / eq1; // eq2 becomes repeating + missing

          repeating = (eq1+eq2)/2;
          missing = eq2-repeating;

          return new int[] {repeating, missing};


     }
}