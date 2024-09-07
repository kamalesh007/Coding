package scaler.maths.scaler.recursion;

public class TOH {

    public void toh(int N , char start, char end, char aux)
    {
        if(N == 1) {
            System.out.println("Move 1 from "+ start + " to " +end );
            return;
        }

        toh(N-1 , start , aux , end);
        System.out.println("Move "+N+" from "+ start + " to " +end );
        toh(N-1 , aux,end,start);

    }

    public static void main(String[] args) {
        TOH toh = new TOH();
        toh.toh(3,'A','C', 'B');
    }


}
