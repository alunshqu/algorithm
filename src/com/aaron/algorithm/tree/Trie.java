package com.aaron.algorithm.tree;

public class Trie {
    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("boy");
        trie.insert("boss");
        trie.insert("cowboy");
        trie.insert("cow");
        System.out.println(trie.search("boss"));
        System.out.println(trie.search("bosses"));
        System.out.println(trie.search("countdown"));
        System.out.println(trie.search("cowboy"));
        System.out.println(trie.startWith("bo"));
        System.out.println(trie.startWith("co"));
        System.out.println(trie.startWith("cowf"));
    }

}
