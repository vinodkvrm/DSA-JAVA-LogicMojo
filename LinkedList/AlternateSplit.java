package LinkedList;

public class AlternateSplit {

    public void alternatingSplitList(MainLL.Node head){
        MainLL.Node head1, head2, temp, curr=head;
        head1 = head;
        if(head==null || head.next==null) {
            head2 = null;
            return;
        }
        head2 = head.next;
        while(curr.next!=null) {
            temp =curr.next;
            curr.next = curr.next.next;
            curr = temp;
        }
    }

    public static void main(String[] args) {
        MainLL.Node head= new MainLL.Node(5);
        MainLL.Node node1= new MainLL.Node(9);
        head.next = node1;
        MainLL.Node node2= new MainLL.Node(15);
        node1.next = node2;
        MainLL.Node node3= new MainLL.Node(7);
        node2.next = node3;
        MainLL.Node node4= new MainLL.Node(7);
        node3.next = node4;
        MainLL.Node node5= new MainLL.Node(7);
        node4.next = node5;
        AlternateSplit split = new AlternateSplit();
        split.alternatingSplitList(head);
    }
}
