package LinkedList;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class RotateClockWise {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode temp = head;
        int len = 0;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        len = len+1;
        k = k % len;
        k = len - k;
        int i =0;
        while(i < k){
            ListNode x = new ListNode(head.val);
            temp.next = x;
            temp = temp.next;
            head = head.next;
            i++;
        }
        return head;
    }
}