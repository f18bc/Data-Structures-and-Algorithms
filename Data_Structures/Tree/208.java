class Trie {
    // Time Constructor O(1), the rest O(S), s = word / prefix
    // Space O(T*Σ) Σ = 26, T = sum of all inserted words
    private Trie[] children;
    private boolean isEnd;
    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(node.children[index]==null)
                node.children[index] = new Trie();
            node = node.children[index];
        }
        node.isEnd = true;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(node.children[index]==null)
                return false;
            node = node.children[index];
        }
        if (node.isEnd == false) return false;
        return true;        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            int index = c-'a';
            if(node.children[index]==null)
                return false;
            node = node.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */