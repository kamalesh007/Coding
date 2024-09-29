package scaler.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void generate(int index, List<Character> arr,List<Character> ans)
    {
        if(index == arr.size())
        {
            System.out.println(ans);
            return;
        }

        ans.add(arr.get(index));
        generate(index + 1 , arr,ans);
        ans.remove(ans.size() -1 );
        generate(index + 1, arr,ans);
    }

    public static void main(String[] args) {
        generate(0,List.of('1','2','3'),new ArrayList<>());
    }
}
