package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_02_TwoStacksImplementQueue {
    public static class TwoStacksQueue
    {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;
        public TwoStacksQueue()
        {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();

        }
        public void add(int val)
        {
            stackPush.push(val);
        }
        public int poll()
        {
            if(stackPop.isEmpty() && stackPush.isEmpty()) //这里是与，两个stack都为空
            {
                throw new RuntimeException("stack is empty");
            }
            if(stackPop.isEmpty())
            {
                while (!stackPush.isEmpty())
                {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }
        public int peek()
        {
            if(stackPop.isEmpty() && stackPush.isEmpty())
            {
                throw new RuntimeException("stack is empty");
            }
            if(stackPop.isEmpty())
            {
                while (!stackPush.isEmpty())
                {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();

        }
    }
    public static void  main(String[] args)
    {
        TwoStacksQueue tsq = new TwoStacksQueue();
        tsq.add(1);
        tsq.add(2);
        tsq.add(3);
        tsq.add(4);
        System.out.println(tsq.poll());
        System.out.println(tsq.poll());
        System.out.println(tsq.poll());
        System.out.println(tsq.poll());
    }
}
