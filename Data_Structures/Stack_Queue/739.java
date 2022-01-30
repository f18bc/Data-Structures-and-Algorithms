class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Time O(N)
        // Space O(N)
        int days = temperatures.length;
        int[] ans = new int[days];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < days; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}