package scaler.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation1 {

    public static List<List<Character>> permute(boolean[] vst,List<Character> characters, int index,List<Character> ans,List<List<Character>> result)
    {
        if(index == characters.size())
        {
            List<Character> temp = new ArrayList<>();
            for(Character a : ans)
            {
                temp.add(a);
            }
            result.add(temp);
            return result;
        }

        for(int i = 0 ; i < characters.size() ; i ++)
        {
            if(!vst[i])
            {
                vst[i] = true;
                ans.add(characters.get(i));
                permute(vst,characters,index + 1,ans,result);
                ans.remove(index);
                vst[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Character>> result = new ArrayList<>();
        List<Character> ans = new ArrayList<>();
        List<Character> characters = List.of('a','b','c');
        boolean[] vst = new boolean[characters.size()];
        result = permute(vst,characters,0,ans,result);
        result = result;
    }
}
