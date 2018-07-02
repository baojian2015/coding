package chapter_3_treeproblem;

public class Tree {
    public static class Node
    {
        public Node left;
        public Node right;
        public int value;
        public Node(int data)
        {
            value = data;
        }
    }
    public static void setEdgeMap(Node h, int l, Node[][] edgeMap)
    {
        if(h == null)
        {
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        System.out.println("l:" + l);
        System.out.println(edgeMap[l][0].value);
        System.out.println(edgeMap[l][1].value);
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        Node[][] edgeMap = new Node[2][2];
        setEdgeMap(node1, 0, edgeMap);
    }

}
