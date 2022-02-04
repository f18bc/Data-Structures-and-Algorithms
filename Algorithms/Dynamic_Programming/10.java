class Solution {
    // Time O(mn)
    // Sapce O(mn)
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }
        
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
            }
        }
        
        /*
         * dp[i][j] = dp[i-1][j] // in this case, a* counts as multiple a
         * or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
         * or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
         */
        
        return dp[m][n];
    }
}