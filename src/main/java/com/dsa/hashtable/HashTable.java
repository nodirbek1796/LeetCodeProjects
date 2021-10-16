package com.dsa.hashtable;

import java.util.LinkedList;

public class HashTable {

    static class Entry {
        private final int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] entries;

    public HashTable() {
        entries = new LinkedList[5];
    }

    public void put(int key, String value){
        int index = hash(key);

        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var list = entries[index];

        for (Entry entry : list) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        Entry entry = new Entry(key, value);
        list.addLast(entry);
    }

    public String get(int key){
        return null;
    }

    public boolean remove(int key){
        return false;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (LinkedList<Entry> entry : entries) {
            if (!entry.isEmpty()) {
                for (Entry entry1 : entry) {
                    s.append(entry1.key).append(" = ").append(entry1.value);
                }
                s.append("\n");
            }
        }
        return s.toString();
    }

    private int hash(int key){
        return key % entries.length;
    }
}
