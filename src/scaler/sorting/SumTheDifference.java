package scaler.sorting;

import java.util.HashMap;
import java.util.*;

class Pair
{
    int val;
    int freq;

    public Pair(int val, int freq)
    {
        this.val = val;
        this.freq = freq;
    }

}


public class SumTheDifference {
    public static void main(String[] args) {
        int ans = 0;
        List<Pair> fCount = new ArrayList<>();
        fCount.add(new Pair(2,2));
        fCount.add(new Pair(3,2));
        fCount.add(new Pair(5,1));

        for(int i = 0 ; i < fCount.size(); i ++)
        {
            Pair p = fCount.get(i);
            int contribution = p.freq ;
            for(int j = i + 1 ; j < fCount.size() ; j++)
            {
                contribution *= (fCount.get(j).freq + 1);
            }
            ans -= (p.val * contribution);
        }

        for(int i =  0 ; i < fCount.size(); i++)
        {
            Pair p = fCount.get(i);
            int contribution = p.freq ;
            for(int j =  i -1 ; j >= 0; j --)
            {
                contribution *= (fCount.get(j).freq + 1);
            }
            ans += (p.val * contribution);
        }
        System.out.println(ans);
    }




}
