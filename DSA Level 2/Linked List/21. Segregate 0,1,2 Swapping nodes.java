1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by twos nodes.

Input Format
1->0->1->0->0->1->2->1->1->1->2->1->1->null
Output Format
0->0->0->1->1->1->1->1->1->1->1->2->2->null
Sample Input
17
2 2 0 2 1 0 0 2 2 1 2 1 2 0 1 0 0 
Sample Output
0 0 0 0 0 0 1 1 1 1 2 2 2 2 2 2 2 
__________________________________________________
3 dummy nodes for 0,1,2
dummyZero=new ListNode(-1);
prevZero=dummyZero;
dummyOne=new ListNode(-1);
prevOne=dummyOne;
dummyTwo=new ListNode(-1);
prevTwo=dummyTwo;

follow same procedure as q 19

prevZero.next=dummyOne.next;
prevOne.next=dummyTwo.next;
prevTwo.next=null //prevent loop

__________________________________________________

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

    public static ListNode segregate012(ListNode head) {
        ListNode dummyZero=new ListNode(-1);
        ListNode prevZero=dummyZero;
        ListNode dummyOne=new ListNode(-1);
        ListNode prevOne=dummyOne;
        ListNode dummyTwo=new ListNode(-1);
        ListNode prevTwo=dummyTwo;
        
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
            }else if(curr.val==2){ //if 2 is encountered
                prevTwo.next=curr;//connect iterator to recently encountered 2 value
                prevTwo=prevTwo.next; //move iterator there
                curr=curr.next; //go to next element
            }
        }
        
        prevZero.next=dummyOne.next;
        prevOne.next=dummyTwo.next;
        prevTwo.next=null; //prevent loop
        
        if(dummyZero.next!=null){
            return dummyZero.next;
        }else if(dummyOne.next!=null){
            return dummyOne.next;
        }else{
            return dummyTwo.next;
        }
        
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
        h1 = segregate012(h1);
        printList(h1);
    }
}