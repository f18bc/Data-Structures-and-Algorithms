class Solution {
    // Time O(length of all characters in words)
    // Space O(length of all characters in words)
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word:words){
            trie.insert(word,++index);
        }
        trie.words =words;
        return trie.dfs();
    }
}

class Node{
    char c;
    HashMap<Character,Node> children = new HashMap();
    int end;
    public Node(char c){
        this.c = c;
    }
}

class Trie{
    Node root;
    String[] words;
    public Trie() {
        root = new Node('0');
    }
    
    public void insert(String word, int index){
        Node cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }
    
    public String dfs(){
        String res = "";
        Deque<Node> s = new LinkedList<>();
        s.push(root);
        
        while(!s.isEmpty()){
            Node node = s.poll();
            if(node.end>0||node==root){
                if(node!=root){
                    String word = words[node.end-1];
                    if(word.length()>res.length()||word.length() == res.length()&&word.compareTo(res)<0){
                        res = word;
                    }
                }
                for(Node child : node.children.values()){
                    s.push(child);
                }
            }
        }
        return res;
    }
}