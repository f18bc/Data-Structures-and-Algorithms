/*class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> rightSide = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            switch (s.charAt(i)){
                case ')':
                    if (rightSide.isEmpty() || rightSide.pop() != '(' ) return false;
                    break;
                case '}':
                    if (rightSide.isEmpty() || rightSide.pop() != '{' ) return false;
                    break;
                case ']':
                    if (rightSide.isEmpty() || rightSide.pop() != '[' ) return false;
                    break;
                default:
                    rightSide.push(s.charAt(i));
            }
        }
        
        if (!rightSide.isEmpty()) return false;
        else return true;
    }
}*/
// Time O(N)
// Space O(N)
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Map<Character,Character> leftMap = new HashMap<>();
        Stack<Character> rightSide = new Stack<>();
        leftMap.put(')','(');
        leftMap.put('}','{');
        leftMap.put(']','[');     
        
        for(int i=0;i<s.length();i++) {
            if(leftMap.containsKey(s.charAt(i))){
                if(rightSide.isEmpty() || leftMap.get(s.charAt(i))!=rightSide.pop()) return false;
            } else rightSide.push(s.charAt(i));
        }
        
        if (!rightSide.isEmpty()) return false;
        else return true;
    }
}
