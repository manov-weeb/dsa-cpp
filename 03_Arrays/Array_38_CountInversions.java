import java.util.ArrayList;

public class Array_38_CountInversions {
     public static void main(String args[]) {

          int arr[] = { 5, 3, 2, 4, 1 };

          System.out.println(optimalSolution(arr));
     }

     public static int bruteForce(int arr[]) {
          int count = 0;

          for (int i = 0; i < arr.length; i++) {
               for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j])
                         count++;

               }
          }

          return count;
     }

     public static int optimalSolution(int arr[]) {
          return mergeSort(arr, 0, arr.length-1);
     }

     public static int mergeSort(int arr[], int low, int high){
          int count = 0;
          if(low >= high) return count;

          int mid = (low+high)/2;

          count += mergeSort(arr, low, mid);
          count += mergeSort(arr, mid+1, high);
          count += merge(arr, low, mid, high);

          return count;
     }

     public static int merge(int arr[], int low, int mid, int high) {
          ArrayList<Integer> temp = new ArrayList<>();
          int left = low;
          int right = mid + 1;

          int count = 0;

          while (left <= mid && right <= high) {
               if (arr[left] <= arr[right]) {
                    temp.add(arr[left]);
                    left++;
               } else {
                    temp.add(arr[right]);
                    count = count + (mid - left) + 1;
                    right++;

               }
          }

          // if elements on the left half are still left //

          while (left <= mid) {
               temp.add(arr[left]);
               left++;
          }

          // if elements on the right half are still left //
          while (right <= high) {
               temp.add(arr[right]);
               right++;
          }

          // transfering all elements from temporary to arr //
          for (int i = low; i <= high; i++) {
               arr[i] = temp.get(i - low);
          }

          return count;
     }
}
