package chapter_2_listproblem;

public class Problem_05_ReversePart {
    public static Node reversePart(Node head, int from, int to)
    {
        int len = 0;
        Node node1 = head;
        Node fpre = null;
        Node fpos = null;
        while (node1 != null)
        {
            len++;
            fpre = len == from -1 ? node1: fpre;
            fpos = len == to + 1 ? node1: fpos;
            node1 = node1.next;
        }
        if(from > to || from <1 || to > len)
        {
            return head;
        }
        node1 = fpre == null ? head : fpre.next;
        Node node2 = node1.next;
        node1.next = fpos;
        while (node2 != fpos)
        {
            Node next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fpre != null)
        {
            fpre.next = node1;
            return head;
        }
        return node1;
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        Node head = reversePart(node1, 2, 4);
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
