package scaler;

public class PairWithDifference {

    public static void main(String[] args) {
        int ans = 0;
        int[] arr = new int[]{-5,-2,1,1,2,8,10,12,12,13,15};
        int K = 11;

        int i = 0 ;
        int j = 1 ;

        while(j < arr.length)
        {
            if(arr[j] - arr[i] == K)
            {
                int cJ = 0;
                int cI = 0;

                int eleToCompare = arr[j];

                while(j < arr.length  && eleToCompare == arr[j])
                {
                    cJ ++;
                    j++;
                }

                eleToCompare = arr[i];

                while(i < j && eleToCompare == arr[i])
                {
                    cI ++;
                    i++;
                }
               ans += (cI * cJ);
            }
            else if(arr[j] - arr[i] > K)
            {
                i ++;
            }
            else
            {
                j ++;
            }
        }
        System.out.println(ans);



    }
}
