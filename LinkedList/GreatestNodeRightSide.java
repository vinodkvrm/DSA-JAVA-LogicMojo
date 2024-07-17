package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GreatestNodeRightSide {
    public int[] nextLargerNodes(ListNode head) {        
        if(head == null){
            return new int[]{};
        }
        List<Integer> ls = new ArrayList<>();
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            ls.add(curr.val);
            curr = curr.next;
        }
        int ans[] = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i< len;i++){
            while(!st.isEmpty() && ls.get(st.peek()) < ls.get(i)){
                ans[st.pop()] = ls.get(i);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()] = 0;
        }
        return ans;
        
        
    }
}