class Solution {
    public int countPrimes(int n) {
        // Time O(Math.sqrt(n)*log(logN))
        // Space O(n)
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ans++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}