package LinkedList;

class RemoveNthNodeFromEnd {

    static class ListNode{
        int data;
        ListNode next = null;
        ListNode(int val) {
                this.data = val;
            }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int s = 0;
        ListNode temp = head;
        while(temp != null){
            s++;
            temp = temp.next;
        }
        int k = s - n;
        if(k == 0){
            return head.next;
        }
        temp = head;
        for(int i=1;i<k;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}