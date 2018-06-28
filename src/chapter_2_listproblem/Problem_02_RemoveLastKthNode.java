package chapter_2_listproblem;
public class Problem_02_RemoveLastKthNode {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public static Node removeLastKthNode(Node head, int k)
    {
        if(k < 1)
        {
            return head;
        }
        Node cur = head;
        while (cur != null)
        {
            k--;
            cur = cur.next;
        }
        if(k == 0)
        {
            return head.next;
        }
        /*else if(k > 0)
        {
            return head;
        }*/
        if(k < 0)
        {
            cur = head;
            /*while (cur != null)   //我写的
            {
                k++;
                if(k != 0)
                {
                    cur = cur.next;
                }
                else
                {
                    break;
                }
                //cur = cur.next;
            }*/
            while (++k != 0)
            {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    public static void main(String args[])
    {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        Node head = removeLastKthNode(node1, 2);
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
