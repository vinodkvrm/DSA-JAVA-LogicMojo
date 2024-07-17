package Array;

import java.util.ArrayList;
import java.util.Collections;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

/*  Function which returns the  root of 
    the flattened linked list. */
public class FlattenNode
{
    Node flatten(Node root)
    {
        // Your code here
        Node temp=root;
        ArrayList<Integer> list= new ArrayList<>();
        while(temp!=null){
            list.add(temp.data);
           Node b= temp.bottom;
           while(b!=null){
               list.add(b.data);
               b=b.bottom;
           }
           temp=temp.next;
            
        }
        Collections.sort(list);
        
        Node result=null;
        temp=null;
        for(int i=0;i<list.size();i++){
            int d=list.get(i);
           Node temp2=new Node(d);
            if(result==null){
                result=temp2;
                temp=result;
            }else{
                temp.bottom=temp2;
                temp=temp.bottom;
            }
        }
        return result;
    }
}