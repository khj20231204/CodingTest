package ch6.search_ex;

public class PermutationEx {

    public static void permute(int[] arr, int n) {
        if (n == 1) {
            // Base case: reached the end of permutation
            // Print the current permutation
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                // Swap the current element with the first element
                int temp = arr[i];
                arr[i] = arr[n - 1];
                arr[n - 1] = temp;

                // Recursively generate permutations for the remaining elements
                permute(arr, n - 1);

                // Restore the original order by swapping back
                temp = arr[i];
                arr[i] = arr[n - 1];
                arr[n - 1] = temp;
            }
        }
    }
}
