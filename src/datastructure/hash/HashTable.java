package datastructure.hash;

import java.util.LinkedList;


public class HashTable {
    class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Node>[] hashTable;

    public HashTable(int size) {
        hashTable = new LinkedList[size];
    }

    public Long getHashCode(String key){
        Long hashCode = 0L;

        for(char c: key.toCharArray()){
            hashCode += (long) c;
        }
        return hashCode;
    }

    public int getIndex(Long hashCode){
        return (int) (hashCode % hashTable.length);
    }

    public Node searchNode(int index,String key){
        LinkedList<Node> indexList = hashTable[index];

        for (Node n : indexList) {
            if (n.key == key) { return n; }
        }

        return null;
    }

    public void put(String key, String value) {
        Long hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<Node>();
            hashTable[index].add(new Node(key, value));
        }
        else {
            Node searched = searchNode(index, key);

            if (searched != null) { searched.value = value; }
            else {hashTable[index].add(new Node(key, value)); }
        }
    }

    public String get(String key) {
        Long hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        Node searched = searchNode(index, key);

        if (searched == null) { return ""; }
        else { return searched.value; }
    }
}
