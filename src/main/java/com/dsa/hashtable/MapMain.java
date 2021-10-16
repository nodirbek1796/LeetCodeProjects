package com.dsa.hashtable;

import java.util.HashMap;

public class MapMain {
    public static void main(String[] args) {
        String word = "PDp academy";
        System.out.println(getCharacter(word));
        System.out.println(firstUnrepeatedCharacter(word));

        HashTable hashTable = new HashTable();
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");
        hashTable.put(4, "Four");
        System.out.println(hashTable);
    }

    public static Character getCharacter(String word){
        String s = word.toLowerCase();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Integer put = hashMap.put(s.charAt(i), i);
            if (put != null)
                return s.charAt(i);
        }
        return null;
    }

    public static Character firstUnrepeatedCharacter(String word){
        String s = word.toLowerCase();
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Boolean put = hashMap.put(s.charAt(i), true);
            if (put != null)
                hashMap.replace(s.charAt(i), true, false);
        }
        char result;
        for (int i = 0; i < hashMap.size(); i++) {
            result = s.charAt(i);
            if (hashMap.get(result))
                return result;
        }
        return null;
    }

    public static Character findMoreRepeatedLetter(String word){
        String s = word.toLowerCase();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = s.charAt(i);
            boolean containsKey = hashMap.containsKey(c);
            if (!containsKey)
                hashMap.put(c, 1);
            else {
                Integer integer = hashMap.get(c);
                hashMap.replace(c, integer, integer++);
            }
        }
        return null;
    }
}
