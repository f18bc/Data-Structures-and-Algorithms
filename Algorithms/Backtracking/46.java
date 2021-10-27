class Solution {
    // Time O(n*n!)
    // Space O(n!)
    // 8mins
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> comb = new ArrayList<>();
        helper(comb, nums, visited);
        return ans;
    }
    public void helper(List<Integer> comb, int[] nums, boolean[] visited) {
        if (comb.size() == nums.length) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb.add(nums[i]);
                helper(comb, nums, visited);
                comb.remove(comb.size() - 1);
                visited[i] = false;
            }
        }
    }
}