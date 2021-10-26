class Solution {
    // Time O(N)
    // Space O(N)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int ele : pushed) {
            stack.offerFirst(ele);
            while (!stack.isEmpty() && stack.getFirst() == popped[n]) {
                stack.pollFirst();
                n++;
            }
        }
        return popped.length == n;
    }
}