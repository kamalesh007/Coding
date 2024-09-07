package scaler.strings;

public class KMP {
    public static void main(String[] args) {
       String pattern = "aabaabaaa";
       int[] lps = new int[pattern.length()];
       lps[0] = 0;
       int len = 0;
       int i = 1;
       while(i < pattern.length())
       {
            if(pattern.charAt(len) == pattern.charAt(i))
            {
                lps[i++] = len + 1;
                len++;
            }
            else
            {
                if(len == 0)
                {
                    lps[i++] = 0;
                }
                else
                {
                    len = lps[len - 1];
                }
            }
       }

        for( i = 0 ; i < lps.length ; i++)
        {
            System.out.print(lps[i] +"\t");
        }
    }
}
