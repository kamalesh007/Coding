package scaler.strings;

public class MakePalindrome {

    public static void main(String[] args) {
        String A = "eylfpbnpljvrvipyamyehwqnq";
        char[] str = new char[A.length() * 2  + 1];

        int i = 0 ;
        int j = A.length() + 1;

        while(i < A.length())
        {
            str[i] = A.charAt(i);
            str[j] = A.charAt(i);
            i++;
            j++;
        }

        str[i] = '*';

        int[] Z = new int[A.length() * 2 + 1];

        Z[0] = A.length() * 2 - 1;

        int L = 0 ;
        int R = 0 ;

        for( i = 1 ; i < Z.length ; i++)
        {
            //System.out.print(str[i]+" ");
            if(i > R) // Do brute force
            {
                L = i ;
                R = i ;
                while(R < Z.length && str[R - L] == str[R]) R++;
                R --;
                Z[i] = R - L  + 1;

            }
            else
            {
                if(R - i + 1 > Z[i - L])
                {
                    Z[i] = Z[i - L];
                }
                else
                {
                    L = i ;
                    R ++;
                    while(R < Z.length && str[R - L] == str[R]) R++;
                    R --;
                    Z[i] = R - L + 1;

                }
            }

            System.out.print(Z[i] + "\t");
        }
        //System.out.println(A.length());


    }
}
