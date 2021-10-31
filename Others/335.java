class Solution {
    // Time O(n)
    // Space O(1)
    public boolean isSelfCrossing(int[] distance) {
        int length = distance.length;
        if (length < 4) {
            return false;
        }
        for (int i = 3; i < length; i ++) {
            if (distance[i] >= distance[i-2] && distance[i-1] <= distance[i-3]) {
                return true;
            }
            if (i >= 4 && distance[i-1] == distance[i-3] && distance[i] + distance[i-4] >= distance[i-2]) {
                return true;
            }
            if (i >= 5 && distance[i] + distance[i-4] >= distance[i-2] && distance[i-1] + distance[i-5] >= distance[i-3] && distance[i-1] <= distance[i-3] && distance[i-2] > distance[i-4]) {
                return true;
            }
        }
        
        return false;
    }
}