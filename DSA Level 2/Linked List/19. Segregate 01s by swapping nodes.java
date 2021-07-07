1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and followed by ones node.
3. You are only allowed to swap data not swap nodes.
Input Format
1->0->1->0->0->1->1->1->1->1->1->null
Output Format
0->0->0->1->1->1->1->1->1->1->1->null

_____________________________________________________________
dummyOne=new ListNode(-1); //start point of values of 0 
prevOne=dummyOne; //iterator for 1
dummyZero=new ListNode(-1);//start point of values of 0 
prevzero=dummyZero; //iterator for 0

ListNode curr=head;

while(curr!=null){
    if(curr.val==0){ //if 0 is encountered
        prevZero.next=curr; //connect iterator to recently encountered 0 value
        prevZero=prevZero.next;  //move iterator there
        curr=curr.next; //go to next element
    }else if(curr.val==1){ //if 1 is encountered
        prevOne.next=curr;//connect iterator to recently encountered 1 value
        prevOne=prevOne.next; //move iterator there
        curr=curr.next; //go to next element
    }
}

prevZero.next= dummyOne.next; //connect 0 and 1 nodes
prevone.next= null; //to prevent loop

return dummyZero.next;


_____________________________________________________________
import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode dummyOne=new ListNode(-1); //start point of values of 0 
        ListNode prevOne=dummyOne; //iterator for 1
        ListNode dummyZero=new ListNode(-1);//start point of values of 0 
        ListNode prevZero=dummyZero; //iterator for 0
        
        ListNode curr=head;
        
        while(curr!=null){
            if(curr.val==0){ //if 0 is encountered
                prevZero.next=curr; //connect iterator to recently encountered 0 value
                prevZero=prevZero.next;  //move iterator there
                curr=curr.next; //go to next element
            }else if(curr.val==1){ //if 1 is encountered
                prevOne.next=curr;//connect iterator to recently encountered 1 value
                prevOne=prevOne.next; //move iterator there
                curr=curr.next; //go to next element
            }
        }
        
        prevZero.next= dummyOne.next; //connect 0 and 1 nodes
        prevOne.next= null; //to prevent loop
        
        return dummyZero.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate01(h1);
        printList(h1);
    }
}