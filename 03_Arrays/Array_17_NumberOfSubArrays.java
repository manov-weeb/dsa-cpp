public class Array_17_NumberOfSubArrays {
     public static void main(String args[]){
          int arr[] = { 1, 2, 0, 0, 3, 1, 1, 1, 1, 4, 2, 3 };
          int k = 5;

          System.out.println(bruteForce(arr, k));
     }

     public static int bruteForce(int arr[], int k){
          int n = arr.length;
          int count = 0;

          for (int i = 0; i < n; i++) {
               int sum = 0;
               for (int j = i; j < n; j++) {
                    sum+=arr[j];
                    if(sum == k){
                         count++;
                    }
               }
               
          }

          return count;
     }

}
