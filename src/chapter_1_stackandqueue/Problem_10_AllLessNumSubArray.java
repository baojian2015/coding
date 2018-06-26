package chapter_1_stackandqueue;

import java.util.LinkedList;

public class Problem_10_AllLessNumSubArray {
    public static int getNum(int[] arr, int num)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        LinkedList<Integer> minq = new LinkedList<Integer>();
        LinkedList<Integer> maxq = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!minq.isEmpty() && arr[minq.peekLast()] >= arr[j]) {
                    minq.pollLast();
                }
                minq.add(j);
                while (!maxq.isEmpty() && arr[maxq.peekLast()] <= arr[j]) {
                    maxq.pollLast();
                }
                maxq.add(j);
                if (arr[maxq.peekFirst()] - arr[minq.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (maxq.peekFirst() == i) {
                maxq.pollFirst();
            }
            if (minq.peekFirst() == i) {
                minq.peekFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 3, 4};
        int num = getNum(arr, 3);
        System.out.println(num);
    }
}
