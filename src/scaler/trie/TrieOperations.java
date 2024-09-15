package scaler.trie;

public class TrieOperations {

    Node<Boolean> trie;
    public TrieOperations()
    {
        this.trie = new Node<Boolean>();
    }


    public void insert(String word)
    {
        Node<Boolean> temp = this.trie;
        for(int i = 0 ; i < word.length() ; i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null)
            {
                temp.children[idx] = new Node<Boolean>();
            }
            temp = temp.children[idx];
        }
        temp.data = true;
    }

    public boolean search(String word)
    {
        Node<Boolean> temp = this.trie;
        for(int i = 0 ; i < word.length() ; i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null)
            {
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.data;
    }


}
