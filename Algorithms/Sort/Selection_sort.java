public class Selection_sort {
    public void selectionSort(int[] arr) {
        int n = arr.length;
        int minIdx;
        for (int i = 0; i < n - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
