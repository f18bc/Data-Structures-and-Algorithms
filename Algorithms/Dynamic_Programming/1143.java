class Solution {
    // Time O(mn)
    // Space O(min(m,n))
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    cur[j] = pre[j-1] + 1;
                } else {
                    cur[j] = Math.max(cur[j-1], pre[j]);
                }
            }
            for (int j = 0; j <= n; j++) {
                pre[j] = cur[j];
            }
        }
        return cur[n];
    }
}
/*
class Solution {
    // Time O(mn)
    // Space O(mn)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
*/