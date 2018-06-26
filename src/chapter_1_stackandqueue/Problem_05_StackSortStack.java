package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_05_StackSortStack {
    public static void sort(Stack<Integer> stack)
    {
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty())
        {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur)
            {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty())
        {
            stack.push(help.pop());
        }
    }
    public static void main(String args[])
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        sort(stack);
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
