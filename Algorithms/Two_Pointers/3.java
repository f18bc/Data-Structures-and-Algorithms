class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Time O(N)
        // Space O(min(M,N))
        Map<Character, Integer> cmap = new HashMap<>();
        int len = s.length();
        int ans = 0;
        //The position of the last occurred character
        int loc = -1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (cmap.containsKey(c)) {
                loc = Math.max(loc, cmap.get(c));
            }
            ans = Math.max(i - loc, ans);
            cmap.put(c, i);
        }
        return ans;
    }
}