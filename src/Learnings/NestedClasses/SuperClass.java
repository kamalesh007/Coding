package Learnings.NestedClasses;

import java.util.Iterator;
import java.util.function.Function;

public class SuperClass {
    String text;
    private static class InnerClass
    {

    }

    private class InClass
    {
        String text;

        public void doSome()
        {
            System.out.println(this.text);
            System.out.println(SuperClass.this.text);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArrayList<Integer> test = new MyArrayList<>();

        test.add(1);
        test.add(2);

        Iterator<Integer> itr = test.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}
