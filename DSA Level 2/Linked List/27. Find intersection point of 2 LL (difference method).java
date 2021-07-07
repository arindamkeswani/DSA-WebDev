1. Given the heads of two singly linked-lists headA and headB
2. Return the node at which the two lists intersect. 
3. If the two linked lists have no intersection, return null.
Input Format
Input is managed for you.
Output Format
Output is managed for you.


Sample Input
4
14 12 8 7 
2
4
7 2 6 5 
Sample Output
8
______________________________________________________
//Level 1 algo
Take out length of both LL
Take diff and see which ll is smaller or larger
traverse accordingly
______________________________________________________
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
    
    static int getLength(ListNode head){
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        return count;
    }
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        
        int aLen= getLength(headA);
        int bLen= getLength(headB);
        
        int diff=Math.abs(aLen-bLen);
        
        
        ListNode ptr1=aLen<bLen ? headA : headB;
        ListNode ptr2=aLen<bLen ? headB : headA; //bigger list head, covers gap
        
        for(int i=0;i<diff;i++){
            ptr2=ptr2.next;
        }
        
        while(ptr2!=null && ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        
        return ptr2;
    }

    // Input_code===================================================

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
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}