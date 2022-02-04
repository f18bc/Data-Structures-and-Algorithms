public class Bubble_sort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 1; i < n; i++) {
            swapped = false;
            for (int j = 1; j < n - i + 1; j++) {
                if ((arr[j] < arr[j - 1])) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }

            }
            if (!swapped) {
                break;
            }
        }   
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
