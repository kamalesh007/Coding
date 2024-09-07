package scaler.strings;

public class KMP1 {

    public static void main(String[] args) {
        String A = "aaaaa#aaaaa";
        char[] str = new char[A.length()];
        int[] lps = new int[str.length];
        int i = 0;
        int len = 0;
        while(i < A.length())
        {
            str[i] = A.charAt(i);
            i++;
        }
        for( i = 1 ; i < str.length ; i++)
        {
            if(str[len] == str[i])
            {
                lps[i] = ++len;
            }
            else
            {
                if(len == 0) lps[i] = 0;
                else
                {
                    while(len!= 0 && str[len] != str[i])
                    {
                        len = lps[len - 1];
                    }
                    if(str[len] == str[i])
                    {
                        lps[i] = ++len;

                    }
                    else
                    {
                        lps[i] = 0;
                    }
                }
            }
            System.out.print(lps[i] +"\t");
        }
    }
}
