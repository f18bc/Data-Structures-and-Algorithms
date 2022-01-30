class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        
        int[] need = new int[256];
        int[] have = new int[256];
        
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        
        int left = 0;
        int right = 0;
        int min = 0x3f3f3f3f;
        int count = 0;
        int start = 0;
        
        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] == 0) {
                right++;
                continue;
            }
            if (have[r] < need[r]) {
                count++;
            }
            have[r]++;
            right++;
            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                if (have[l] == need[l]) {
                    count--;
                }
                have[l]--;
                left++;
            }
        }
        if (min == 0x3f3f3f3f) {
            return "";
        }
        return s.substring(start, start + min);
    }
}