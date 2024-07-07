public class Array_40_MaximumProductSubarray {
     public static void main(String args[]) {
          int arr1[] = {2, 3, -2, 4};
         
  
          System.out.println("Maximum product of subarray in arr1: " + solution(arr1)); 
     

     }

     public static int solution(int arr[]) {
          int n = arr.length;
          int prefix = 1, suffix = 1, result = Integer.MIN_VALUE;

          for (int i = 0; i < n; i++) {
               if (prefix == 0)
                    prefix = 1;
               if (suffix == 0)
                    suffix = 1;

               prefix *= arr[i];
               suffix *= arr[n-1-i];

               result = Math.max(result, Math.max(prefix, suffix));


          }

          return result;
     }
}
