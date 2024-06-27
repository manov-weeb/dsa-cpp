public class Array_15_OccursOnce {
     public static void main(String args[]) {
          int arr[] = { 1, 1, 2, 3, 3, 4, 4 };
          System.out.println(findUsingHash(arr));
     }

     public static int findUsingHash(int arr[]) {
          int max = Integer.MIN_VALUE;

          for (int i = 0; i < arr.length; i++) {
               max = max < arr[i] ? arr[i] : max;
          }

          int hash[] = new int[max+1];
          for (int i = 0; i < hash.length; i++) {
               hash[i] = 0;
          }

          for (int i = 0; i < arr.length; i++) {
               hash[arr[i]]++;
          }

          for (int i = 0; i < arr.length; i++) {
               if (hash[arr[i]] == 1) {
                    return arr[i];
               }
          }

          return -1;
     }

     public static int find(int arr[]) {
          int XOR = 0;
          for (int i = 0; i < arr.length; i++) {
               XOR = arr[i] ^ XOR;

          }

          return XOR;
     }
}
