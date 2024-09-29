package scaler.backtracking;

import java.util.HashMap;
import java.util.Map;

public class Squareful {

    public static void gen(int index,int[] ans,Map<Integer,Integer> fMap)
    {
        if(index == ans.length)
        {
            for(int a : ans)
            {
                System.out.print(a +"\t");
            }
            return;
        }

        for(Integer key : fMap.keySet())
        {
            int freq = fMap.get(key);
            if(freq > 0)
            {
                if(isValid(ans,index,key))
                {
                    ans[index] = key;
                    fMap.put(key,freq -1);
                    gen(index + 1, ans , fMap);
                    fMap.put(key,freq);
                }
            }
        }
    }

    public static boolean isValid(int[] arr,int index,int ele)
    {
        if(index == 0) return true;
        else return isPerfectSq(arr[index - 1] + ele);
    }

    public static boolean isPerfectSqN(int ele) {
        int sq = (int)Math.sqrt(ele);
        return sq*sq == ele;
    }
    public static boolean isPerfectSq(int ele) { // take care of overflow.
        long low = 1;
        long high = ele;
        while (low <= high) {
            // Corrected binary search mid-point calculation
            long mid = low + ((high - low) >> 1);
            if (mid * mid == ele) {
                return true;
            } else if (mid * mid > ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {

        int[] arr = new int[]{97022,1574,26,74,122,22,59};
        Map<Integer,Integer> fMap = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i ++)
        {
            int freq = fMap.getOrDefault(arr[i],0);
            fMap.put(arr[i],freq + 1);
        }
        gen(0,new int[arr.length],fMap);


    }
}
