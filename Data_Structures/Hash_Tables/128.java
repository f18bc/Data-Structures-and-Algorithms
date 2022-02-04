class Solution {
    public int longestConsecutive(int[] nums) {
        // Time O(n)
        // Space O(n)
        Set<Integer> hset = new HashSet<>();
        for (int num : nums) {
            hset.add(num);
        }
        
        int longest = 0;
        
        for (int num : hset) {
            if (!hset.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (hset.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}

/*
class Solution {
    public int longestConsecutive(int[] nums) {
        int start = (int) (-1e9);
        int end = (int) (1e9);
        int[] dict = new int[ 2 * (int) 1e9 + 1];
        for (int num : nums) {
            dict[num + (int)1e9]++;
        }
        
        int globalMax = 0;
        int localMax = 0;
        for (int i = start; i <= end; i++) {
            if (dict[i + (int)1e9] > 0) {
                localMax++;
            } else {
                localMax = 0;
            }
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}
*/