class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + r >> 1;
            if (minTime(piles, mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public int minTime(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}