package scaler.strings;

public class Zfunction {
    public static void main(String[] args) {
        String str= "xxyaxxyazxxyaxxyaxz";
        int[] Z = new int[str.length()];
        Z[0] = Z.length;
        int N = Z[0];
        int L = 0;
        int R = 0;
        for(int i = 1; i < Z.length ; i++)
        {
            if(i > R)
            {
                L = i ;
                R = i ;
                while(R < N && str.charAt(R-L) == str.charAt(R))
                {
                    R ++;
                }
                R --;
                Z[i] = R - L + 1;
            }
            else
            {
                if(Z[i - L] + i <= R) //  R - i + 1 >  Z[i - L] If the no of terms from I - R is greater than Z[i - L] then lies within the window so copy
                {
                    Z[i] = Z[i-L];
                }
                else
                {
                    L = i;
                    while(R < N && str.charAt(R - L ) == str.charAt(R))
                    {
                        R ++;
                    }
                    R --;
                    Z[i] = R - L + 1;
                }
            }

            System.out.print(Z[i] +"\t");
        }
    }
}
