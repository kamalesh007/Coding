package scaler.binarysearch;

public class Books {
    public int books(int[] A, int B) {

        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length ; i ++)
        {
            sum += A[i];
            max = Math.max(max,A[i]);
        }
        int low = max ;

        int high = sum ;

        while(low <= high)
        {
            int mid = low + (high - low >> 1);

            boolean check = isCheck(A,B,mid);

            if(check)
            {
              high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;

    }

    public static boolean isCheck(int[] A,int B,int C)
    {
       for(int i = 0 ; i < A.length ; i++)
       {
           if(A[i] > C )
           {
               return false;
           }
       }
       int alloc = 1;
       int curSum = 0;
       for(int i = 0 ; i < A.length ; i++)
       {
           curSum += A[i];

           if(curSum > C)
           {
               curSum = A[i];
               alloc++;
           }
       }

       return alloc <= B;
    }

    public static void main(String[] args) {
        Books b = new Books();
        System.out.println(b.books(new int[]{12, 34, 67, 90},2));

    }
}
