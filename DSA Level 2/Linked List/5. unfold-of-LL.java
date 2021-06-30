/*
Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
for more information watch video.
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null

Sample Input
9 5 1 1 4 4 6 6 9 9 
Sample Output
5 1 4 6 9 9 6 4 1 
*/



//__________________________________________________________
/*
//travel using 2 pointers (one on head other on head.next)
nHead=head.next;
p1=head;
p2=nHead;
while(p2!=null && p2.next!=null){
    p1.next=p1.next.next
    p2.next=p2.next.next   

    //go to next position
    p1=p1.next
    p2=p2.next 
}

//reverse LL that starts from nHead
p1.next=nHead;
return head;

*/


import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode nHead=head.next;
        ListNode p1=head;
        ListNode p2=nHead;
        
        while(p2!=null && p2.next!=null){
            p1.next=p1.next.next;
            p2.next=p2.next.next;
            
            //go to next position
            p1=p1.next;
            p2=p2.next;
        }
        
        nHead = reverse(nHead);
        p1.next=nHead;
        
        // return head;
    }
    public static ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode nbr=null;
        while(head!=null){
            
            nbr=head.next;
            
            head.next=prev;
            
            prev=head;
            head=nbr;
            
        }
        
        return prev;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}