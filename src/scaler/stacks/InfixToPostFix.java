package scaler.stacks;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        Stack<Character> operatorStack = new Stack<Character>();
        HashMap<Character,Integer> precedence = new HashMap<>();
        precedence.put('*',2);
        precedence.put('/',2);
        precedence.put('-',1);
        precedence.put('+',1);

        String infix = "a+b*c";
        for(int i = 0 ; i < infix.length() ; i++)
        {
            char c = infix.charAt(i);
            if(!precedence.containsKey(c) && c != '(' && c != ')')
            {
                System.out.print(c +"\t");
            }
            else
            {
                if(c == ')')
                {
                    while(operatorStack.peek() != '(')
                    {
                        System.out.print(operatorStack.pop() +"\t");
                    }
                    operatorStack.pop();
                }
                else if(c == '(')
                {
                    operatorStack.push('(');
                }
                else
                {
                    int curPrecedence = precedence.get(c);
                    while(!operatorStack.isEmpty() && precedence.get(operatorStack.peek()) >= curPrecedence)
                    {
                        System.out.print(operatorStack.pop()+"\t");
                    }
                    operatorStack.push(c);
                }

            }
        }

        while(!operatorStack.isEmpty())
        {
            System.out.print(operatorStack.pop()+"\t");
        }

    }
}
