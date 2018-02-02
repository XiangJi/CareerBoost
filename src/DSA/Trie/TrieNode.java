package DSA.Trie;

public class TrieNode {
    public TrieNode[] children;
    public boolean isWord; // if end word
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}