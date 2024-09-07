package com.arrays;

public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] num = {1,7,3,6,5,6};
        num = new int[]{-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumIndex(num));
    }

    public static int equilibriumIndex(int[] arr)
    {
        int lSum = 0;
        int rSum = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            rSum += arr[i];
        }

        for(int i = 0 ; i < arr.length ; i++)
        {
            rSum -= arr[i];

            if(rSum == lSum) return i;

            lSum += arr[i];

        }
        return -1;
    }





}
