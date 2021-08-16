class Solution {
    public int mySqrt(int x) { 
        // Time O(logN)
        // Space O(1)
        int left = 0, right = x;
        int anw = -1;
        while(left<= right){
            int mid = left + (right - left) / 2;
            // long class to deal with extremely large value
            if ((long)mid * mid == x) return mid;
            else if ((long)mid * mid > x) right = mid - 1;
            else {
                anw = mid > anw ? mid : anw;
                left = mid + 1;
            }
        }
        //Could be improved by just putting right here cuz v[right] < v[mid] < v[left] at this stage
        return anw;
    }
}