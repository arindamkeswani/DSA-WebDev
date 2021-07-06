Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
Input Format
1->7->2->6->3->5->4->null
Output Format
2->6->4->1->7->3->5->null


Sample Input
4
0
6
7
5
Sample Output
0 6 7 5 
________________________________________________
ALGO
evenDummy = new ListNode(-1);
evenTail=evenDummy

oddDummy = new ListNode(-1);
oddTail=offDummy;

curr=head;
while(true){
    if(evenTail==null || oddTail==null){
        break;
    }

    if (curr.val=odd){
        oddTail.next=curr;
        oddTail=curr;
        curr=curr.next;
    }else if(curr.val=even){
        evenTail.next=curr;
        evenTail=curr;
        curr=curr.next;
    }
    
}

evenTail.next=oddDummy.next;
oddTail.next=null; //to prevent cycle

return evenDummy.next;

________________________________________________
import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode evenDummy = new ListNode(-1);
        ListNode evenTail=evenDummy;
        
        ListNode oddDummy = new ListNode(-1);
        ListNode oddTail=oddDummy;
        
        ListNode curr=head;
        while(curr!=null){
            if(evenTail==null || oddTail==null){
                break;
            }
            // System.out.print(curr.val);
            if ((curr.val)%2==1){ 
                oddTail.next=curr;
                oddTail=curr;
                curr=curr.next;
            }else{
                evenTail.next=curr;
                evenTail=curr;
                curr=curr.next;
            }
    
        }
        
        evenTail.next=oddDummy.next; //connecting even and odd sections
        oddTail.next=null; //to prevent cycle
        
        return evenDummy.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}