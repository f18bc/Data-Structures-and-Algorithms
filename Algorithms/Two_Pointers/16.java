class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int twoSum = nums[l] + nums[r];
                if (twoSum + nums[i] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r - 1 && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r - 1 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (twoSum + nums[i] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
/*
//Backtracking time limited exceeded
class Solution {
    Set<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        ans = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, 0);
        return new ArrayList<>(ans);
    }
    public void dfs(int[] nums, List<Integer> path, int start, int sum) {
        if (path.size() == 3 && sum == 0) {
            ans.add(new ArrayList<>(path));
            return ;
        }
        
        if (path.size() > 3 || start >= nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, i + 1, sum + nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
*/
/*
// Original
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            List<Integer> path = new ArrayList<>();
            path.add(nums[i]);
            while (l < r) {
                int twoSum = nums[l] + nums[r];
                if (twoSum + nums[i] == 0) {
                    path.add(nums[l]);
                    path.add(nums[r]);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                    l++;
                    r--;
                } else if (twoSum + nums[i] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
*/
