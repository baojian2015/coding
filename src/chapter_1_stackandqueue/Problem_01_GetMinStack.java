package chapter_1_stackandqueue;
import java.util.Stack;
public class Problem_01_GetMinStack {

    public static class MyStack
    {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack()
        {
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }
        public int pop()
        {
            if(stackData.isEmpty())
            {
                throw new RuntimeException("stackData is empty");
            }
            int val = stackData.pop();
            System.out.println("pop data:" + val);
            if(getMin() == val)
            {
                //stackMin.pop();
                System.out.println("pop min data:" + stackMin.pop());
            }
            System.out.println("##################");
            return val;
        }
        public void  push(int val)
        {
            stackData.push(val);
            if(stackMin.isEmpty())
            {
                System.out.println("push min " + val);
                stackMin.push(val);
            }
            else if(val <= getMin())
            {
                System.out.println("push min " + val);
                stackMin.push(val);
            }

        }
        public int getMin()
        {
            if(stackMin.isEmpty())
            {
                throw new RuntimeException("stackMin is empty");
            }
            return stackMin.peek();

        }
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(1);
        int cnt = 6;
        //while(cnt-- > 0)  //pop出最后一个数时候，stack为空了，此时没有最小值
        {
            System.out.println("val:" + myStack.pop());
            //System.out.println("=========");
            System.out.println("min:" + myStack.getMin());
            System.out.println("=========");
            System.out.println("val:" + myStack.pop());
            //System.out.println("=========");
            System.out.println("min:" + myStack.getMin());
            System.out.println("=========");
            System.out.println("val:" + myStack.pop());
            //System.out.println("=========");
            System.out.println("min:" + myStack.getMin());
            System.out.println("=========");
            System.out.println("val:" + myStack.pop());
            //System.out.println("=========");
            System.out.println("min:" + myStack.getMin());
            System.out.println("=========");
            System.out.println("val:" + myStack.pop());
            //System.out.println("=========");
            System.out.println("min:" + myStack.getMin());
            System.out.println("=========");
        }
    }
}
