import java.util.ArrayList;

public class Array_39_ReversePairs {
    public static void main(String args[]) {
        int arr[] = { 40, 25, 19, 12, 9, 6, 2 };
        System.out.println("Brute Force Count: " + bruteForce(arr));
        System.out.println("Optimized Count: " + mergeSort(arr, 0, arr.length - 1));
    }

    public static int bruteForce(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j])
                    count++;
            }
        }
        return count;
    }

    public static int countPairs(int arr[], int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    public static int mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int count = 0;

        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += countPairs(arr, start, mid, end);
        merge(arr, start, mid, end);

        return count;
    }

    private static void merge(int arr[], int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }

        while (left <= mid)
            temp.add(arr[left++]);

        while (right <= end)
            temp.add(arr[right++]);

        for (int i = 0; i < temp.size(); i++)
            arr[start + i] = temp.get(i);
    }
}
