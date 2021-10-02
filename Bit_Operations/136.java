class Solution {
    //Time O(n)
    //Space O(1)
    public int singleNumber(int[] nums) {
        int anw = 0;
        for(int num:nums) anw^=num;
        return anw;
    }
}
/*class Solution {
    //15 mins Accepted, another 20 mins for O(1) space and failed
    //Time O(n)
    //Space O(n)
    //Approach String.substring method to check if it contains the same number
    public int singleNumber(int[] nums) {
        //build a ArrayList for easy check and remove 
        List<String> l = new ArrayList<>();
        
        for (int num : nums){
            //Substring method to loop
            //Convert int to string here cuz remove(int) would be remove(index)
            if (!l.contains(String.valueOf(num))) l.add(String.valueOf(num));
            else l.remove(String.valueOf(num));
        }
        
        return Integer.valueOf(l.get(0));

    }
}*/