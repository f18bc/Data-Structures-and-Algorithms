class Solution {
    // Time O(N * 2^N)
    // Space O(N)
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' ||
                expression.charAt(i) == '-' ||
                expression.charAt(i) == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> ans1 = diffWaysToCompute(part1);
                List<Integer> ans2 = diffWaysToCompute(part2);
                for (Integer p1 : ans1) {
                    for (Integer p2 : ans2) {
                        int value = 0;
                        switch (expression.charAt(i)) {
                            case '+':
                                value = p1 + p2;
                                break;
                            case '-':
                                value = p1 - p2;
                                break;
                            case '*':
                                value = p1 * p2;
                                break;
                        }
                        ans.add(value);
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}