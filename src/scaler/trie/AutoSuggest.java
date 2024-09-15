package scaler.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AutoSuggest {

    public static TrieNode root;
    static class TrieNode
    {
        TrieNode[] children;
        List<String> candidates;

        TrieNode()
        {
            this.children = new TrieNode[26];
            candidates = new ArrayList<>(5);
        }
    }

    public static void insert(String word)
    {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ; i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null)
            {
                temp.children[idx] = new TrieNode();
            }
            if(temp.children[idx].candidates.size() < 5)
            {
                temp.children[idx].candidates.add(word);
            }
            temp = temp.children[idx];
        }
    }

    public static List<String> getAutoSuggestion(String prefix)
    {
        TrieNode temp = root;
        for(int i = 0 ; i < prefix.length() ; i++)
        {
            int idx = prefix.charAt(i) - 'a';
            if(temp.children[idx] == null)
            {
                //return temp.candidates; // return partial candidates
                return null; // return exact candidates
            }
            temp = temp.children[idx];
        }
        return temp.candidates;
    }
    public static void main(String[] args) {
        root = new TrieNode();

        String[] words = new String[]{"abcd", "aecd", "abaa", "abef", "acdcc", "acbcc"};
        int[] weight = new int[]{2,1,3,4,6,5};
        Pair<String,Integer>[] pairs = new Pair[6];
        String[] prefix = new String[]{"ab","abc","a"};
        for(int i = 0 ; i < words.length ; i ++)
        {
            pairs[i] = new Pair<String,Integer>(words[i],weight[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                if(o1.right < o2.right)
                {
                    return 1;
                }
                else if(o1.right == o2.right)
                {
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0 ; i < words.length ; i ++)
        {
            insert(pairs[i].left);
            //System.out.println(pairs[i].left);
        }

        for(int i = 0 ; i < prefix.length ; i++)
        {
            List<String> str = getAutoSuggestion(prefix[i]);
            for(String s : str)
            {
                System.out.print(s + "\t");
            }
            System.out.println();
        }







    }
}

class Pair<LEFT,RIGHT>
{
    LEFT left;
    RIGHT right;
    Pair(LEFT l,RIGHT r)
    {
        this.left = l;
        this.right = r;
    }
}
