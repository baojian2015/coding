package chapter_2_listproblem;

public class Problem_04_ReverseList {
    public static Node reverseList(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node pre = null;
        Node cur = head;  //cur变量是多余的，直接使用head就行
        while (cur != null)
        {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        Node head = reverseList(node1);
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
