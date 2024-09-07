package com.arrays;

import java.util.Stack;

public class Solution {
    public int solve() {
        String A = "(a+(b-(c-(d-e))))";
        Stack<Character> globalOperator = new Stack<Character>();
        globalOperator.push('+');
        boolean[] aSign = new boolean[26];
        for(int i = 0 ;  i < 26 ; i ++)
        {
            aSign[i] = true;
        }

        for(int i = 0 ; i < A.length() ; i++)
        {
            char ch = A.charAt(i);

            if(ch == '(')
            {
                continue;
            }

            if(ch == ')')
            {
                globalOperator.pop();
            }
            else if(ch == '+' || ch == '-')
            {
                if(A.charAt(i+1) == '(')
                {
                    boolean a = getCorrectSign(ch,globalOperator.peek());
                    globalOperator.push(a?'+':'-');
                }
            }
            else
            {
                if(i != 0 && A.charAt(i-1) == '(')
                {
                    aSign[ch - 'a'] = getCorrectSign(globalOperator.peek(),'+');
                }
                else if(i != 0. && (A.charAt(i-1) == '+' || A.charAt(i -1) == '-'))
                {
                    aSign[ch-'a']=getCorrectSign(globalOperator.peek(),A.charAt(i-1));
                }

            }
        }

        for(int i = 0 ; i < 26 ; i ++)
        {
            System.out.print(aSign[i] +"\t");
        }



        return 0;



    }

    public boolean getCorrectSign(char a , char b)
    {
        if(a == b) return true;
        else return false;
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
