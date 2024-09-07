package scaler.maths;

public class GCD {


    public static int gcd(int a , int b)
    {
        a  = a % b ; // if a bigger making it smaller
        while(a > 0 )
        {
            b = b % a;
            int temp = a;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(15,25));
    }
}
