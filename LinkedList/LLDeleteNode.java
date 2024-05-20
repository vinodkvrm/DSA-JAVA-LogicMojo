package LinkedList;

// Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}
/*You are required to complete below method*/
class LLDeleteNode
{
    Node deleteNode(Node head, int x)
    {
        // Your code here
        Node curr = head;
        while(x-1 > 1 && curr != null){
            curr = curr.next;
            x--;
        }
        if(curr == null){
            return head;
        }
        curr.next = curr.next.next;
        return head;

    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node head = node1;

        Node node2 = new Node(4);
        node1.next = node2;

        Node node3 = new Node(8);
        node2.next = node3;

        Node node4 = new Node(83);
        node3.next = node4;

        Node node5 = new Node(18);
        node4.next = node5;

        Node node6 = new Node(1);
        node5.next = node6;

        LLDeleteNode ld = new LLDeleteNode();
        System.out.println(ld.deleteNode(head, 3));
    }
}