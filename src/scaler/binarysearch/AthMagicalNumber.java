package scaler.binarysearch;

public class AthMagicalNumber {

    public static void main(String[] args) {
        int N = 5;
        int X = 10;
        int Y = 6;
        int lcm = X * Y / gcd(X,Y);

        int low = Math.min(X,Y);
        int high = Math.min(X,Y) * N;

        while(low <= high )
        {
            int mid = low + (high - low >> 1);

            int count =( mid / X )+ (mid / Y) - (mid / lcm );

           if(count < N)
           {
               low = mid + 1;
           }
           else
           {
               high = mid - 1;
           }
        }
        System.out.println(low);
    }

    public static int gcd(int a ,int b)
    {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
