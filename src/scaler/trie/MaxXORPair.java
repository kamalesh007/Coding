package scaler.trie;

public class MaxXORPair {

    public static  int ans;
    public static TrieBit root;
    public static void insert(int number)
    {
        TrieBit temp = root;

        for(int i = 0 ; i < 29 ; i++)
        {
            int bit = ((1 << i) & number) == 0 ? 0 : 1;
            if(temp.bits[bit] == null)
            {
                temp.bits[bit] = new TrieBit();
            }
            temp = temp.bits[bit];
        }

        temp.data = number;
    }

    public static int getMaxXor(int number) // search
    {
        int maxXor = 0;
        TrieBit temp = root;
        for(int i = 0 ; i < 29 ; i ++)
        {
            int bit = ((1 << i) & number) == 0 ? 0 : 1;
            if(temp.bits[bit ^ 1] != null)
            {
                maxXor += (1<<i);
                temp = temp.bits[bit ^ 1];
            }
            else
            {
                temp = temp.bits[bit & 1];
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20,30,15,25,10,5};
        ans = arr[0] ^ arr[1] ;
        root = new TrieBit();
        insert(arr[0]);
        insert(arr[1]);
        for(int i= 2; i < arr.length ; i++)
        {
            ans = Math.max(ans,getMaxXor(arr[i]));
        }
        System.out.println(ans);
    }
}

class TrieBit
{
    int data;
    TrieBit[] bits;
    TrieBit()
    {
        bits = new TrieBit[2];
    }
}
