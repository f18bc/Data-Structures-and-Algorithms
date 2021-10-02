public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // Time O(N)
        // Space O(1)
        /*
        int bits = 0;
        int mask = 1;
        for(int i=0;i<32;i++){
            if((n&mask)!=0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
        */
        int bits = 0;
        while(n!=0){
            bits++;
            n &= (n-1);
        }
        return bits;
    }
}