package scaler.hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CountTriangles {

    public static void main(String[] args) {
        int[] x = new int[]{0,1,1};
        int[] y = new int[]{0,1,0,0,1,1};
        Set<Pair> s = new HashSet<>();
        new Pair(0,0);
        for(int i =0 ; i < x.length ; i++)
        {
            s.add(new Pair(x[i],y[i]));
        }
        int c = 0 ;
       for(int i = 0 ; i < x.length ; i++)
       {
           for(int j = i+1 ; j < x.length ; j++ )
           {
               int x1 = x[i];
               int y1 = y[i];
               int x2 = x[j];
               int y2 = y[j];

               if(y1 != y2 && x1 != x2) // not a st. line
               {
                  if (s.contains(new Pair(x1,y2)))
                  {
                      c++;
                  }
                  if(s.contains(new Pair(x2,y1)))
                  {
                      c++;
                  }
               }

           }
       }

        System.out.println(c);
    }

}

class Pair
{
    int i ;
    int j ;

    public  Pair(int i,int j)
    {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o)
    {
        Pair other = (Pair)o;
        if(other == this) return true;
        else if(other.i == this.i && other.j == this.j) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
