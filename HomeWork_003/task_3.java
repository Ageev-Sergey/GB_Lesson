package HomeWork_003;

import java.util.Random;
import java.util.Arrays;

public class task_3 {

    public static void merge(int[] arr, int[] newArr, int low, int mid, int high) {
        int k = low;
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                newArr[k++] = arr[i++];
            } else {
                newArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void mergesort(int[] arr, int[] newArr, int low, int high) {
        if (high == low) {
            return;
        }

        int mid = (low + ((high - low) >> 1));

        mergesort(arr, newArr, low, mid);
        mergesort(arr, newArr, mid + 1, high);

        merge(arr, newArr, low, mid, high); 
    }

    public static boolean isSorted(int[] arr) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prev > arr[i]) {
                System.out.println("MergeSort Fails!!");
                return false;
            }
            prev = arr[i];
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[] newArr = Arrays.copyOf(arr, arr.length);

        mergesort(arr, newArr, 0, arr.length - 1);

        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
