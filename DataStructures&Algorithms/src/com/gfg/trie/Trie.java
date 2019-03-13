package com.gfg.trie;

public class Trie {

    private static final int ALPHABET = 26;

    static class TrieNode {

        TrieNode[] children = new TrieNode[ALPHABET];

        boolean isEndOfWord;

        TrieNode() {
            for(int i = 0; i< ALPHABET; i++){
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public static void insert(String key) {

        int index, length = key.length(), level;

        TrieNode pCrawl = root;

        for(level = 0; level < length ; level++){

            index = key.charAt(level) - 'a';

            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public static boolean isKeyPresent(String key) {

        int index, length = key.length(), level;

        TrieNode pCrwal = root;

        for(level = 0; level < length; level++){

            index = key.charAt(level) - 'a';
            if(pCrwal.children[index] == null)
                return false;

            pCrwal = pCrwal.children[index];
        }

        return (pCrwal != null && pCrwal.isEndOfWord);
    }

    public static void main(String[] args) {

        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        for (int i = 0; i < keys.length; i++)
            insert(keys[i]);

        if(isKeyPresent("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

    }
}
