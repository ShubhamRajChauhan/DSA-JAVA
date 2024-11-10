
import java.util.Arrays;

public class InbuiltSort {
    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
       
    }
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }  
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 3, 2};
        //insertionSort(arr);
        //Arrays.sort(arr);         //<----------
        Arrays.sort(arr,0,3);       //<----------

        printArr(arr);  
    }
}


