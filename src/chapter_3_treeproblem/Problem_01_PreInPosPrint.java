package chapter_3_treeproblem;

import java.util.Stack;

public class Problem_01_PreInPosPrint {
    public static void preOrderRecur(Node head)
    {
        if(head == null)
        {
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(Node head)
    {
        if(head == null)
        {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head)
    {
        if(head == null)
        {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }
    public static void preOrderUnRecur(Node head)
    {
        System.out.println("pre-Order:");
        Stack<Node> stack = new Stack<Node>();
        if(head != null)
        {
            stack.push(head);
            while (!stack.isEmpty())
            {
                Node h = stack.pop();
                System.out.println(h.value);
                if(h.right != null)
                {
                    stack.push(h.right);
                }
                if(h.left != null)
                {
                    stack.push(h.left);
                }
            }
        }
    }
    public static void inOrderUnRecur(Node head)
    {
        System.out.println("inOrderUnRecur:");
        if(head != null)
        {

            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null)
            {
                if(head != null)
                {
                    stack.push(head);
                    head = head.left;
                }
                else
                {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }
    public static void posOrderUnRecur(Node head)
    {
        System.out.println("posOrderUnRecur:");
        if(head != null)
        {
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.push(head);
            while (!stack1.isEmpty())
            {
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null)
                {
                    stack1.push(head.left);
                }
                if(head.right != null)
                {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty())
            {
                System.out.println(stack2.pop().value);
            }
        }
        //while (!stack2.is)
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        preOrderRecur(node1);
        System.out.println("==========");
        inOrderRecur(node1);
        System.out.println("==========");
        posOrderRecur(node1);
        preOrderUnRecur(node1);
        inOrderUnRecur(node1);
        posOrderUnRecur(node1);
    }

}
