package com.arrays;

public class FastPowerIterative {

    public int fastPower(int a,int b, int m)
    {
        long ans = 1L;
        while(b != 0)
        {
            if((b & 1) == 1)
            {
                ans = (ans * a) % m;
            }
            a =  (a*a)%m;
            b /= 2;
        }
        return (int) ans ;

    }

    public static void main(String[] args) {
        FastPowerIterative fastPowerIterative = new FastPowerIterative();
        System.out.println(fastPowerIterative.fastPower(3,7,4));
    }

}
