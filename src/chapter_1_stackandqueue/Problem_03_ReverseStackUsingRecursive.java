package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_03_ReverseStackUsingRecursive {
    public static int getAndRemoveLastElement(Stack<Integer> s) {
        int result = s.pop();
        if (s.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(s);
            s.push(result);
            //System.out.println("val:" + last + ",result:" + result);
            return last;
        }

    }
    public static void reverse(Stack<Integer> stack)
    {
        if(stack.isEmpty())
        {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        //int last = getAndRemoveLastElement(stack);
        //System.out.println("last:" + last);
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
