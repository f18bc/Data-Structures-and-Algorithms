// Time O(N)
// Space O(N)
class Solution {
    static Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
    static {
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
    }
    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1)/ 2 ];
        int size = 0;
        for (String token : tokens) {
            if (operations.containsKey(token)) {
                int v2 = stack[--size];
                int v1 = stack[--size];
                int result = operations.get(token).apply(v1, v2);
                stack[size++] = result;
            } else {
                stack[size++] = Integer.valueOf(token);
            }
        }
        return stack[--size];
    }
}
/*
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        int ans = 0;
        int v1 = 0;
        int v2 = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    v2 = Integer.valueOf(stack.pop());
                    v1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(v1 + v2));
                    break;
                case "-":
                    v2 = Integer.valueOf(stack.pop());
                    v1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(v1 - v2));
                    break;
                case "*":
                    v2 = Integer.valueOf(stack.pop());
                    v1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(v1 * v2));
                    break;
                case "/":
                    v2 = Integer.valueOf(stack.pop());
                    v1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(v1 / v2));
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
*/