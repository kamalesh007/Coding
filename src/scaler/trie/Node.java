package scaler.trie;

public class Node <TYPE>{

    public Node children[];
    public TYPE data;

    public Node()
    {
        children = new Node[26];
    }
}
