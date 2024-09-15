package scaler.trie;

import java.util.Stack;

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

    public static boolean isLeaf(Node node)
    {
        for(Node child : node.children)
        {
            if(child != null)
            {
                return false;
            }
        }
        return true;
    }

    public void delete(String word)
    {
        Node<Boolean> temp = this.trie;
        Stack<Node> path = new Stack<>();
        for(int i = 0 ; i < word.length() ;i ++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null)
            {
                //element no present
                return;
            }
            temp = temp.children[idx];
            path.push(temp);
        }
        temp.data = false;
        // data isEnd
        temp = path.pop();

        while(temp.data == false && isLeaf(temp) && !path.isEmpty())
        {
            Node<Boolean> popped = path.pop();

            for (int i = 0; i < popped.children.length; i++) {
                if (popped.children[i] == temp) {
                    popped.children[i] = null;  // Remove the child
                    break;
                }
            }
            temp = popped;
        }


    }


}
