# leetcode 208 实现Trie

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true


```java
class Trie {

    private int size = 26;
    private Trie childrens[] = new Trie[size];
    boolean isEnd = false;
    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie current = this;
        for(char c : word.toCharArray()) {
            if(current.childrens[c - 'a'] == null) {
                current.childrens[c - 'a'] = new Trie();
            }
            current = current.childrens[c - 'a'];
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie current = this;
        for(char c : word.toCharArray()) {
            if(current.childrens[c - 'a'] == null) {
                return false;
            }
            current = current.childrens[c - 'a'];
        }
        return current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie current = this;
        for(char c : prefix.toCharArray()) {
            if(current.childrens[c - 'a'] == null) {
                return false;
            }
            current = current.childrens[c - 'a'];
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
```