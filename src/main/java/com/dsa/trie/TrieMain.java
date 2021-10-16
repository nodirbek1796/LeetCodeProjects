package com.dsa.trie;

public class TrieMain {
    public static void main(String[] args) {
        TrieArray trieArray = new TrieArray();
        trieArray.insert("john");
        trieArray.search("smith");
        trieArray.print();
    }
}
