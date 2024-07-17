package LinkedList;

class RotateantiClockWise{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null){
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        int i = 0;
        while(i < k){
            Node x = new Node(head.data);
            temp.next = x;
            temp = temp.next;
            head = head.next;
            i++;
        }
        return head;
        
        
    }
    
    
}