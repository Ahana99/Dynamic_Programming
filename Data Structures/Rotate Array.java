public class ArrayRotation {
    // Function to reverse a portion of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array by k steps
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is greater than the array size
        if (k == 0) return; // No rotation needed

        // Step 1: Reverse the entire array
        reverse(arr, 0, n - 1);
        
        // Step 2: Reverse the first k elements
        reverse(arr, 0, k - 1);
        
        // Step 3: Reverse the remaining n-k elements
        reverse(arr, k, n - 1);
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original Array:");
        printArray(arr);

        rotate(arr, k);

        System.out.println("Array After Rotation by " + k + " steps:");
        printArray(arr);
    }
}
