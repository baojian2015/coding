package chapter_2_listproblem;

public class Problem_01_PrintCommonPart {
    public static class Node
    {
        public int data;
        public Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }
    public static void printCommonPart(Node head1, Node head2)
    {
        if(head1 == null || head2 == null)
        {
            return;
        }
        while (head1 != null || head2 != null)
        {
            if(head1.data < head2.data)
            {
                head1 = head1.next;
            }
            else if(head1.data > head2.data)
            {
                head2 = head2.next;
            }
            else {
                System.out.println(head1.data);
                head1 = head1.next;
                head2 = head2.next;
            }

        }
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        printCommonPart(node1, node2);

    }

}
