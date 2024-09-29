package scaler.backtracking;

import scaler.Tree.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumBalancedParantheses {

    public Set<String> visited;
    public int maxLevel;
    public void bfs(String str)
    {
        maxLevel = str.length();
        visited = new HashSet<>();
        Queue<Pair<String,Integer>> q = new ArrayDeque<>();
        //visited.add(str);
        q.add(new Pair<String,Integer>(str,0));
        while(!q.isEmpty())
        {
            Pair<String,Integer> p = q.remove();
            String cur = p.left;
            int level = p.right;
            if(level <= maxLevel)
            {
                for(int i = 0 ; i < cur.length() ; i ++)
                {
                    if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                        continue;  // Only modify parentheses
                    }

                    String tempStr = str.substring(0,i) + str.substring(i+1);
                    int tempLevel = level + 1;
                    if(isValid(tempStr) && tempLevel <= maxLevel)
                    {
                        maxLevel = tempLevel;
                        if(!visited.contains(tempStr))
                        {
                            System.out.println(tempStr +"->" + tempLevel);
                        }
                    }
                    if(!visited.contains(tempStr))
                    {
                        q.add(new Pair<>(tempStr,tempLevel));
                        visited.add(tempStr);
                    }

                }
            }
        }
        System.out.println(maxLevel);

    }

    public boolean isValid(String str)
    {
        int lCount = 0;
        int rCount =  0;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(lCount < rCount) return false;

            if(str.charAt(i) == '(') lCount++;
            else if(str.charAt(i) == ')') rCount++;
        }
        return lCount == rCount;
    }

    public static void main(String[] args) {
        String str = "()))()";
        MinimumBalancedParantheses obj = new MinimumBalancedParantheses();
        obj.bfs(str);
    }

}


