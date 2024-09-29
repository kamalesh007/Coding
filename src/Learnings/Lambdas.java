package Learnings;

public class Lambdas {


    public  void methodRef(String a ,String b)
    {

    }

    public void doSomething()
    {
        Fun<Dummy> f = Dummy::aaa;
        f.apply(null,"a","b");
        Fun<Lambdas> f1 = Lambdas::methodRef;
    }




    public static void main(String[] args) {
        Lambdas l = new Lambdas();
    }

}

interface Fun<T>
{
    public void apply(T a,String b,String c);
}

class Dummy
{
    public void aaa(String a,String b)
    {

    }
}

