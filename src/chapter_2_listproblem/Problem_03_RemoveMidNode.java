package chapter_2_listproblem;
public class Problem_03_RemoveMidNode {
    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) { //判定头节点为空或者只有一个节点的情况
            return head;
        }
        if (head.next.next == null) //删除头节点的特殊情况
        {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;  //含有3个节点是出现规律，没增加2个节点，删除节点向后移动一个
        while (cur.next != null && cur.next.next != null)
        {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        Node head = removeMidNode(node1);
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
