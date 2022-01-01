/*
// Time O(n^2)
// Space O(n^2)
// Define f[i][j] as the minimum number of operations 
// with i characters on the current notepad 
// and j characters on the pasteboard after the last operation.
class Solution {
    int INF = 0x3f3f3f3f;
    public int minSteps(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j] = INF;
            }
        }
        f[1][0] = 0; f[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = INF;
            for (int j = 0; j <= i; j++) {
                f[i][j] = f[i - j][j] + 1;
                min = Math.min(min, f[i][j]);
            }
            f[i][i] = min + 1;
        }
        int ans = INF;
        for (int i = 0; i <= n; i++) ans = Math.min(ans, f[n][i]);
        return ans;
    }
}
*/

class Solution {
    // Time O(n*sqrt(n))
    // Space O(n)
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <=n; i++) {
            dp[i] = 0x3f3f3f3f;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}

/*
class Solution {
    // Time O(sqrt(n))
    // Space O(1)
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }
        if (n != 1) {
            ans += n;
        }
        return ans;
    }
}
*/