package scaler.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsWithDuplicate {

    public static void generate(int index, int maxSize,List<Integer> ans,Map<Character,Integer> fMap)
    {
        if(index == maxSize)
        {
            System.out.println(ans);
            return;
        }
        List<Character> keySet = new ArrayList<>(fMap.keySet());
        int freq = fMap.get(keySet.get(index));
        if(freq <= 0) return;
        for(int i = 0 ; i <= freq ; i ++)
        {
            ans.add(i);
            generate(index + 1 , maxSize , ans,fMap);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Map<Character,Integer> fMap = new HashMap<>();
        fMap.put('1',2);
        fMap.put('2',1);
        fMap.put('3',1);
        generate(0,3,new ArrayList<>(),fMap);
    }
}
