import java.util.Arrays;
import java.util.Collections;

public class ReverseOrder {
    public static void insertionSort(Integer arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Integer arr[] = {5, 4, 1, 3, 2};
        // insertionSort(arr);
        Arrays.sort(arr, Collections.reverseOrder());
        printArr(arr);
    }
}


