
1. You are give a single sorted linkedlist of numbers. 
2. remove all duplicate nodes such that duplicate numbers appear once and Return the remaning linked list.
Input Format
1->1->1->4->5->6->6->7->8->9->9->9->null
Output Format
1->4->5->6->7->8->9->null


Sample Input
12
1 1 1 4 5 6 6 7 8 9 9 9
Sample Output
1 4 5 6 7 8 9 
_________________________________________________________________


dummy=new ListNode(-1);

prev=dummy;
curr=head;

while(curr!=null){
    if(curr.next.val!=curr.val){
        prev.next=curr;
        curr=curr.next;
    }else{
        curr=curr.next;
    }
}

_________________________________________________________________
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

    public static ListNode removeDuplicates(ListNode head) {
        if(head==null){
           return head;
       }
       ListNode dummy=new ListNode(-1);

        ListNode prev=dummy;
        ListNode curr=head;
        
        while(curr!=null){
            if(curr.next!=null && curr.next.val!=curr.val){
                prev.next=curr;
                prev=prev.next;
                curr=curr.next;
            }else if(curr.next==null){
                curr=curr.next;
                prev=prev.next;
            }
            else{
                curr=curr.next;
            }
        }
        prev.next=null;
        return dummy.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}