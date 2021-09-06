class Solution {
    public int climbStairs(int n) {
        //Time O(N)
        //Space O(1)
        //Approach f(n) = f(n-1) + f(n-2)
        
        if(n<1) return -1;
        if(n==1) return 1; // When n equals 1
        if(n==2) return 2; // When n equals 2 
        
        int nm2 = 1; //initializing f(n-2)
        int nm1 = 2; //initializing f(n-1)
        int temp;
        
        for(int i=3;i<n;i++){
            temp = nm1;
            nm1+=nm2;
            nm2=temp;
        }
        return nm1+nm2;
    }
}