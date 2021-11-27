// QuickSlect and QuickSort
class Solution {
    // QuickSelect Time:O(N) Space:O(1)
    // QuickSort Time:O(NlogN) Space:O(1)
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    public int partition(int[][] arr, int left, int right) {
        int pivotIdx = (int) (Math.random() * (right - left + 1)) + left;
        swap(arr, pivotIdx, right);
        int[] pivot = arr[right];
        int pivotDistance = pivot[0] * pivot[0] + pivot[1] * pivot[1];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j][0] * arr[j][0] + arr[j][1] * arr[j][1] <= pivotDistance) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, right);
        return i+1;
    }
    public void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void quickSort(int[][] arr, int left, int right) {
        if (left >= right) {
            return ;
        }
        int pi = partition(arr, left, right);
        quickSort(arr, left, pi-1);
        quickSort(arr, pi+1, right);
    }
    public void quickSelect(int[][] arr, int left, int right, int k) {
        if (left < right) {
            int pi = partition(arr, left, right);
            if (pi == k) {
                return ;
            } else if (pi > k) {
                quickSelect(arr, left, pi-1, k);
            } else {
                quickSelect(arr, pi+1, right, k);
            }
        }
    }
}

/*
class Solution {
    // Time:O(NlogN) Space:O(logN)
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] * p1[0] + p1[1] * p1[1] - (p2[0] * p2[0] + p2[1] * p2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}
*/
/*
class Solution {
    // Time:O(Nlogk) Space:O(k)
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] p2, int[] p1) {
                return p1[0] * p1[0] + p1[1] * p1[1] - (p2[0] * p2[0] + p2[1] * p2[1]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
*/