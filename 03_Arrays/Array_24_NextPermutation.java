import java.util.ArrayList;
import java.util.List;

public class Array_24_NextPermutation {

    public static void main(String[] args) {
        int arr[] = {1, 3, 2};

        // Using brute force method
        int[] nextPermutationBruteForce = bruteForce(arr);
        System.out.print("Next Permutation (Brute Force): ");
        printArray(nextPermutationBruteForce);

        // Using optimal method
        int[] nextPermutationOptimal = optimalSolution(arr);
        System.out.print("Next Permutation (Optimal): ");
        printArray(nextPermutationOptimal);
    }

    public static int[] bruteForce(int arr[]) {
        List<List<Integer>> permutations = getPermutations(arr);

        // Convert input array to list
        List<Integer> input = new ArrayList<>();
        for (int element : arr) {
            input.add(element);
        }

        // Find the index of the input permutation
        int indexOfArr = -1;
        for (int i = 0; i < permutations.size(); i++) {
            if (permutations.get(i).equals(input)) {
                indexOfArr = i;
                break;
            }
        }

        // Find the next permutation
        if (indexOfArr != -1 && indexOfArr < permutations.size() - 1) {
            List<Integer> nextPermList = permutations.get(indexOfArr + 1);
            int[] nextPerm = new int[arr.length];
            for (int i = 0; i < nextPerm.length; i++) {
                nextPerm[i] = nextPermList.get(i);
            }
            return nextPerm;
        }

        // If no next permutation, return the smallest permutation
        return arr; // Can also reverse arr to get the smallest permutation if needed
    }

    public static int[] optimalSolution(int arr[]) {
        int n = arr.length;

        // Step 1: Find the first decreasing element from the end
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // If the entire array is in descending order, reverse it to get the smallest permutation
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return arr;
        }

        // Step 2: Find the next larger element to swap with
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }

        // Step 3: Reverse the sub-array to the right of index
        reverse(arr, index + 1, n - 1);
        return arr;
    }

    private static void reverse(int arr[], int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private static void permute(int[] arr, List<Integer> permutation, List<List<Integer>> result, boolean[] freq) {
        if (permutation.size() == arr.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                permutation.add(arr[i]);
                permute(arr, permutation, result, freq);
                permutation.remove(permutation.size() - 1);
                freq[i] = false;
            }
        }
    }

    private static void permuteUsingSwap(int index, int[] arr, List<List<Integer>> result) {
        if (index == arr.length) {
            // Convert the array to a list and add to result
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i); // Swap current element with index
            permuteUsingSwap(index + 1, arr, result); // Recur for the next index
            swap(arr, index, i); // Backtrack by swapping back
        }
    }

    // Helper method to swap elements
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static List<List<Integer>> getPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUsingSwap(0, arr, result);
        return result;
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
