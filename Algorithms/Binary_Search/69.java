class Solution {
    public int mySqrt(int x) { 
        // Time O(logN)
        // Space O(1)
        int lo = 1;
        int hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}
