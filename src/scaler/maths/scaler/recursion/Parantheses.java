package scaler.maths.scaler.recursion;
public class Parantheses
{
    public static void generate(StringBuffer str,int open,int close,int N,int index)
    {
        if(open > N || close > N|| close > open) return;
        if(str.toString().length() == 2 * N)
        {
            System.out.println(str.toString());
            return;
        }
        int x = str.length();
        str.append("(");
        generate(str,open + 1,close,N,index+1);
        str.deleteCharAt(x);
        str.append(")");
        generate(str,open , close + 1,N,index+1);
        str.deleteCharAt(x);
    }


    public static void solve(int N ,String s,int open , int close)
    {
        if(open + close == 2 * N)
        {
            System.out.println(s);
            return;
        }
        if(open < N)
            solve(N , s + "(" , open + 1,close);
        if(close < open)
            solve(N,s + ")",open,close+1);

    }

    public static void main(String[] args) {
        //generate(new StringBuffer(),0,0,3,0);
        solve(3, "",0,0);
    }
}