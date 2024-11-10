//Find First and Last Position of Elements in Sorted Array (leetcode - 34)

public class FirstandLast {
    public static void result(int arr[], int target) {
        
        int firstIndex = -1;
        int lastIndex = -1;

        
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                firstIndex = i;
                break; // Stop after finding the first occurrence
            }
        }

        
        for (int j = arr.length - 1; j >= 0; j--) {
            if (target == arr[j]) {
                lastIndex = j;
                break; // Stop after finding the last occurrence
            }
        }

        // Print the results
        System.out.println(firstIndex+ " " +lastIndex);
        
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        result(arr, target);
    }
}