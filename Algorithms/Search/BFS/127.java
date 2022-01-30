class Solution {
    // Time O(N * C ^ 2) N = wordList.length(), C = the longest length of a word in wordList
    // Space O(N * C ^ 2)
    
    public static final char[] ALPHABETS = new char[26];
    static {
        for (int i = 0; i < 26; i++) {
            ALPHABETS[i] = (char) (i + 'a');
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int length = 1;
        
        while (q.size() > 0) {
            int n = q.size();
            length++;
            for (int i = 0; i < n; i++) {
                String word = q.pop();
                for (int j = 0; j < word.length(); j++) {
                    for (char c : ALPHABETS) {
                        StringBuilder wordBuilder = new StringBuilder(word.length());
                        wordBuilder.append(word.substring(0, j));
                        wordBuilder.append(c);
                        wordBuilder.append(word.substring(j + 1));
                        String nextWord = wordBuilder.toString();
                        if (!words.contains(nextWord)) {
                            continue;
                        }
                        if (nextWord.equals(endWord)) {
                            return length;
                        }
                        q.add(nextWord);
                        words.remove(nextWord);
                    }
                }
            }
        }
        return 0;
    }
}