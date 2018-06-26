package chapter_1_stackandqueue;

import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w)
    {
        if(arr == null || w < 1 || arr.length < w)
        {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i])
            {
                list.pollLast();
            }
            list.addLast(i);
            if(list.peekFirst() == i - w)
            {
                list.pollFirst();
            }
            if(i >= w -1)
            {
                res[j++] = arr[list.peekFirst()]; //不能用poll
            }
        }
        return  res;
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getMaxWindow(arr, 3);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
}
