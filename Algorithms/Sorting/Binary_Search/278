/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // Time O(logN)
    // Space O(1)
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right=mid;
            } else left=mid+1;
        }
        System.out.println(left);
        return left; //could also be right here
    }
    /*public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if(!isBadVersion(mid-1)) return mid;
                right=mid;
            } else left=mid+1;
        }
        return n;
    }*/
}
