class Solution {
    // Time O(permutation k)
    // Time O(k)
    // 15 mins
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Collections.shuffle(Arrays.asList(arr));
        backtracking(arr, k, n, new ArrayList<Integer>(), 0);
        return ans;
    }
    public void backtracking(Integer[] arr, int k, int n, List<Integer> comb, int in) {
        if (n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        // arr.length always equals to 9
        for (int i = in; i < arr.length; i++) {
            comb.add(arr[i]);
            backtracking(arr, k - 1, n - arr[i], comb, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}